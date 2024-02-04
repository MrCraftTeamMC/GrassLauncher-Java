package xyz.mrcraftteammc.grasslauncher.common.core;

import org.jetbrains.annotations.ApiStatus;
import xyz.mrcraftteammc.grasslauncher.common.annotations.MustOverride;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Supplier;

/**
 * A simple container of almost everything. Like {@link Optional}.
 * @param <T> The Type of the value.
 * @see java.util.Optional
 * @author Mr_limr267
 * @since 1.0.0-SNAPSHOT
 */
@SuppressWarnings({"unchecked", "unused"})
public interface Container<T> extends Cloneable, Serializable {
    /**
     * For {@link Serializable}.
     */
    long serialVersionUID = 1L;

    /**
     * Get empty {@link Container}.
     * @return An empty {@link Container} Instance.
     * @see SimpleContainer#empty()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    Container<? extends T> empty();

    /**
     * Check if the value is not {@code null}.
     * @return Is the value not {@code null}?
     * @see SimpleContainer#isPresent()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    boolean isPresent();

    /**
     * Check if the value is {@code null}.
     * @return Is the value {@code null}?
     * @see SimpleContainer#isNull()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    boolean isNull();

    /**
     * Get the value of the type {@code T}. If you want to process {@code null}, you can try {@link #getOrDefault(Object)}, {@link #getOrElse(Supplier)}, {@link #getOrThrow()}, {@link #getOrThrow(Throwable)}, {@link #getOrThrow(Supplier)}.
     * @return The value.
     * @see SimpleContainer#get()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    T get();

    /**
     * Get the value of the type {@code T}. An alternative of {@link #get()}.
     * @param defaultValue If the value is {@code null}, the return value will be.
     * @return The value. If the value is {@code null}, it will be {@code defaultValue}.
     * @see SimpleContainer#getOrDefault(Object)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    T getOrDefault(T defaultValue);

    /**
     * Get the value of the type {@code T}. Another alternative of {@link #get()}.
     * @param elseValue If the value is {@code null}, the return value will be.
     * @return The value. If the value is {@code null}, it will be {@code elseValue} ({@link Supplier#get()}).
     * @see Supplier#get()
     * @see SimpleContainer#getOrElse(Supplier)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    T getOrElse(Supplier<? extends T> elseValue);

    /**
     * Get the value of the type {@code T}. Another alternative of {@link #get()}.
     * @return The value.
     * @throws NullPointerException If the value is {@code null}.
     * @see SimpleContainer#getOrThrow()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    T getOrThrow() throws NullPointerException;

    /**
     * Get the value of the type {@code T}. Another alternative of {@link #get()}.
     * @param throwable The Exception/Error you want to {@code throw}.
     * @return The value.
     * @param <E> The Type of the Exception/Error.
     * @throws E If the value is {@code null}.
     * @see SimpleContainer#getOrThrow(Throwable)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    <E extends Throwable> T getOrThrow(E throwable) throws E;

    /**
     * Get the value of the type {@code T}. Yet another alternative of {@link #get()}.
     * @param throwable The Supplier of Exception/Error you want to {@code throw}.
     * @return The value.
     * @param <E> The Type of the Exception/Error.
     * @throws E If the value is {@code null} ({@link Supplier#get()}).
     * @see SimpleContainer#getOrThrow(Supplier)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    <E extends Throwable> T getOrThrow(Supplier<? extends E> throwable) throws E;

    /**
     * Cast a {@link Container} Instance to {@link Optional}.
     * @return An {@link Optional} Instance of the value.
     * @throws NoSuchElementException See {@link Optional#get()}.
     * @see SimpleContainer#toOptional()
     * @see Optional#ofNullable(Object)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    Optional<T> toOptional() throws NoSuchElementException;

    /**
     * Cast a {@link Container} Instance to {@link Optional}.
     * @param nullable The value will be {@code null}?
     * @return An {@link Optional} Instance of the value.
     * @throws NoSuchElementException See {@link Optional#get()}.
     * @throws NullPointerException See {@link Objects#requireNonNull(Object)}.
     * @see SimpleContainer#toOptional(boolean) 
     * @see Optional#of(Object)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    Optional<T> toOptional(boolean nullable) throws NoSuchElementException, NullPointerException;

    /**
     * Cast the value to the Type.
     * @return The Type of the value.
     * @param <V> The Type you want to cast the value to.
     * @throws ClassCastException If the value cannot cast to the Type.
     * @see SimpleContainer#to()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    <V> V to() throws ClassCastException;

    /**
     * Cast the value to the {@link Supplier} of Type.
     * @return The Type of the value.
     * @param <V> The Type you want to cast the value to.
     * @throws ClassCastException If the value cannot cast to the Type.
     * @see SimpleContainer#toSupplier()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    <V> Supplier<V> toSupplier() throws ClassCastException;

    /**
     * Cast the value to {@link String}.
     * @return A {@link String} of the value.
     * @throws ClassCastException If the value cannot cast to {@link String}.
     * @deprecated Please use {@link #to()} instead.
     * @see SimpleContainer#toStr()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @Deprecated
    String toStr() throws ClassCastException;

    /**
     * Cast the value to {@link UUID}
     * @return A {@link UUID} of the value.
     * @throws ClassCastException If the value cannot cast to {@link String}.
     * @deprecated Please use {@link #to()} instead.
     * @see SimpleContainer#toUUID()
     * @see UUID#fromString(String) 
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @Deprecated
    UUID toUUID() throws ClassCastException;

    /**
     * Cast the value to {@link Byte}.
     * @return A {@link Byte} of the value.
     * @throws ClassCastException If the value cannot cast to {@link Byte}.
     * @deprecated Please use {@link #to()} instead.
     * @see SimpleContainer#toByte() 
     * @see Byte#parseByte(String) 
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @Deprecated
    byte toByte() throws ClassCastException;

    /**
     * Cast the value to {@link Byte} with range.
     * @param range See {@link Byte#parseByte(String, int)}
     * @return A {@link Byte} of the value.
     * @throws NumberFormatException See {@link Byte#parseByte(String, int)}.
     * @see SimpleContainer#toByte(int)
     * @see Byte#parseByte(String, int)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    byte toByte(int range) throws NumberFormatException;

    /**
     * Cast a {@link Container} Instance to {@link Object}.
     * @return An {@link Object} Instance of the value.
     * @deprecated All the value and the class are based on {@link Object}.
     * @see SimpleContainer#toObject()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @Deprecated
    Object toObject();

    /**
     * Clone of {@link Container} Instance.
     * @return A copy/clone of {@link Container} Instance.
     * @throws CloneNotSupportedException Do you think it is possible to throw this Exception?
     * @see SimpleContainer#clone()
     * @see Object#clone()
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @MustOverride
    Object clone() throws CloneNotSupportedException;

    /**
     * Compare the value and obj.
     * @param obj The object to compare with the value.
     * @return They are equal?
     * @see SimpleContainer#equals(Object)
     * @see Object#equals(Object)
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    boolean equals(Object obj);

    /**
     * Make a debug string for logger to output.
     * @return The debug string.
     * @see SimpleContainer#toString()
     * @see Object#toString() 
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    @MustOverride
    String toString();


    /**
     * A simple implementation of {@link Container}.
     * @param <V> The Type of the value.
     * @see Container
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    class SimpleContainer<V>
            implements Container<V> {
        private final V value;
        private static final Container<?> EMPTY = new SimpleContainer<>(null);

        public SimpleContainer(V value) {
            this.value = value;
        }

        public SimpleContainer(V value, boolean nullable) {
            this(nullable ? value : Objects.requireNonNull(value));
        }

        @Override
        public Container<? extends V> empty() {
            return (Container<V>) SimpleContainer.EMPTY;
        }

        @Override
        public boolean isPresent() {
            return value != null;
        }

        @Override
        public boolean isNull() {
            return value == null;
        }

        @Override
        public V get() {
            return this.value;
        }

        @Override
        public V getOrDefault(V defaultValue) {
            return this.value == null ? defaultValue : this.value;
        }

        @Override
        public V getOrElse(Supplier<? extends V> elseValue) {
            return this.value == null ? elseValue.get() : this.value;
        }

        @Override
        public V getOrThrow() throws NullPointerException {
            if (this.value == null) throw new NullPointerException();
            return this.value;
        }

        @Override
        public <E extends Throwable> V getOrThrow(E throwable) throws E {
            if (this.value == null) throw throwable;
            return this.value;
        }

        @Override
        public <E extends Throwable> V getOrThrow(Supplier<? extends E> throwable) throws E {
            if (this.value == null) throw throwable.get();
            return this.value;
        }

        @Override
        public Optional<V> toOptional() throws NoSuchElementException {
            return Optional.ofNullable(this.value);
        }

        @Override
        public Optional<V> toOptional(boolean nullable) throws NoSuchElementException, NullPointerException {
            return nullable ? this.toOptional() : Optional.of(this.value);
        }

        @Override
        public <E> E to() throws ClassCastException {
            return (E) this.value;
        }

        @Override
        public <E> Supplier<E> toSupplier() throws ClassCastException {
            return this::to;
        }

        @Override
        @Deprecated
        public String toStr() throws ClassCastException {
            return (String) this.value;
        }

        @Override
        @Deprecated
        public UUID toUUID() throws ClassCastException  {
            return UUID.fromString(this.toStr());
        }

        @Override
        @Deprecated
        public byte toByte() throws ClassCastException {
            return (byte) this.value;
        }

        @Override
        public byte toByte(int range) throws NumberFormatException {
            return Byte.parseByte(this.toStr(), range);
        }

        @Override
        @Deprecated
        public Object toObject() {
            return (Object) this.value;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return "CommonContainer->SimpleContainer{" +
                    "value=" + this.value +
                    '}';
        }
    }

    /**
     * An extension of {@link SimpleContainer}, for {@link Comparable} things.
     * @param <V> The Type of the value.
     * @see Container
     * @see SimpleContainer
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    class ComparableContainer<V extends Comparable<V>>
            extends SimpleContainer<V>
            implements Container<V> {
        private final V value;

        public ComparableContainer(V value) {
            super(value);
            this.value = super.get();
        }

        public ComparableContainer(V value, boolean nullable) {
            super(value, nullable);
            this.value = super.get();
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "CommonContainer->ComparableContainer{" +
                    "value=" + this.value +
                    '}';
        }
    }

    /**
     * An extension of {@link SimpleContainer}, for {@link Cloneable} things.
     * @param <V> The Type of the value.
     * @see Container
     * @see SimpleContainer
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    class CloneableContainer<V extends Cloneable>
            extends SimpleContainer<V>
            implements Container<V> {
        private final V value;

        public CloneableContainer(V value) {
            super(value);
            this.value = super.get();
        }

        public CloneableContainer(V value, boolean nullable) {
            super(value, nullable);
            this.value = super.get();
        }

        @ApiStatus.Experimental
        public V cloneValue() {
            return this.value;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "CommonContainer->CloneableContainer{" +
                    "value=" + this.value +
                    '}';
        }
    }

    /**
     * An extension of {@link SimpleContainer}, for {@link Serializable} things.
     * @param <V> The Type of the value.
     * @see Container
     * @see SimpleContainer
     * @author Mr_limr267
     * @since 1.0.0-SNAPSHOT
     */
    class SerializableContainer<V extends Serializable>
            extends SimpleContainer<V>
            implements Container<V> {
        private final V value;

        public SerializableContainer(V value) {
            super(value);
            this.value = super.get();
        }

        public SerializableContainer(V value, boolean nullable) {
            super(value, nullable);
            this.value = super.get();
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "CommonContainer->SerializableContainer{" +
                    "value=" + this.value +
                    '}';
        }
    }

    /**
     * Likely a {@link Supplier} of {@link Container}.
     * @param <T> The Type of the value.
     * @see Container
     * @see Supplier
     */
    @FunctionalInterface
    interface ContainerSupplier<T> {
        /**
         * Get a {@link Container} Instance.
         * @param value The value to make the {@link Container} Instance.
         * @return A {@link Container} Instance.
         */
        Container<T> get(T value);
    }
}
