package xyz.mrcraftteammc.grasslauncher.common.core;

public interface CallBackEvent<R> {
    void failed(Throwable t);

    void cancelled();

    void succeed();

    default void retry() {

    }
}
