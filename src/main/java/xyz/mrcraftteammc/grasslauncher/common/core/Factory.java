package xyz.mrcraftteammc.grasslauncher.common.core;

import javax.annotation.Nullable;

@FunctionalInterface
public interface Factory<T> {
    T work(@Nullable Object... objects);
}
