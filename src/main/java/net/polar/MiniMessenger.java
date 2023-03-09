package net.polar;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import org.bson.Document;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;

public final class MiniMessenger {
    private MiniMessenger() {}

    public static @NotNull CompletableFuture<MiniMessage> create(
            @NotNull MongoDatabase tagsDatabase,
            @NotNull String collectionName
    ) {
        return CompletableFuture.supplyAsync(() -> {
            MongoCollection<Document> collection = tagsDatabase.getCollection(collectionName);
            TagResolver.Builder resolver = TagResolver.builder();
            List<MessengerTag> tags = new ArrayList<>();
            collection.find().forEach((Document document) -> {
                String name = document.getString("name");
                String replacement = document.getString("replacement");
                if (name == null || replacement == null) {
                    return;
                }
                tags.add(new MessengerTag(name, replacement));
            });
            for (MessengerTag tag : tags) {
                resolver = resolver.resolver(Placeholder.parsed(tag.getName(), tag.getReplacement()));
            }
            resolver = resolver.resolver(TagResolver.standard()); // Add standard resolver
            return MiniMessage.builder().tags(resolver.build()).build();
        }, ForkJoinPool.commonPool());
    }

}
