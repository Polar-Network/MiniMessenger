package net.polar;

import org.jetbrains.annotations.NotNull;

public final class MessengerTag {

    final @NotNull String name;
    final @NotNull String replacement;

    MessengerTag(@NotNull String name, @NotNull String replacement) {
        this.name = name;
        this.replacement = replacement;
    }

    public static MessengerTag of(@NotNull String name, @NotNull String replacement) {
        return new MessengerTag(name, replacement);
    }

}
