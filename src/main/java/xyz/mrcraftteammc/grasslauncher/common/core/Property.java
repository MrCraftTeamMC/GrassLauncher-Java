package xyz.mrcraftteammc.grasslauncher.common.core;

@FunctionalInterface
public interface Property<T extends Comparable<T>, C> {
    T get(C type);
}
