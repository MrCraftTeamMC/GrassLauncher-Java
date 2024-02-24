package xyz.mrcraftteammc.grasslauncher.common.core;

import java.util.Optional;

@FunctionalInterface
public interface OptionalSupplier<T> {
    Optional<T> generate();
}
