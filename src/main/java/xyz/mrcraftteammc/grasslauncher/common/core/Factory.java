package xyz.mrcraftteammc.grasslauncher.common.core;

@FunctionalInterface
public interface Factory<T> {
    T build();
}
