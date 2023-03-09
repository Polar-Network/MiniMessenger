package net.polar;

import org.jetbrains.annotations.NotNull;

public final class MessengerTag {

    private final @NotNull String name;
    private final @NotNull String replacement;

    MessengerTag(@NotNull String name, @NotNull String replacement) {
        this.name = name;
        this.replacement = replacement;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getReplacement() {
        return replacement;
    }
}
