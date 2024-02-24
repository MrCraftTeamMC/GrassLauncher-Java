package xyz.mrcraftteammc.grasslauncher.common.core;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 *
 * @param <T>
 */
public interface Builder<T> extends Cloneable, Serializable {
    /**
     * For {@link Serializable}.
     */
    long serialVersionUID = 1L;

    /**
     * Build {@link T} Instance.
     * @return The Instance of {@link T}.
     */
    T build();

    /**
     * Build {@link T} Instance with Args.
     * @param objects Args for building {@link T} Instance.
     * @return The Instance of {@link T}.
     */
    T build(Object... objects);

    /**
     * Likely a {@link Supplier} of {@link Builder}.
     * @param <T> The Type of the {@link Builder}.
     * @see Builder
     * @see Supplier
     */
    @FunctionalInterface
    interface BuilderSupplier<T> {
        /**
         * Get a {@link Builder} Instance.
         * @return A {@link Builder} Instance.
         */
        Builder<T> get();
    }
}
