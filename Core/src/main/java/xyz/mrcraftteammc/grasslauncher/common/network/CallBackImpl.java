package xyz.mrcraftteammc.grasslauncher.common.network;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public interface CallBackImpl extends Callback {
    @Override
    default void onFailure(@NotNull Call call, @NotNull IOException e) {
        System.err.println(this.failureMessage());
        System.err.println(e.getLocalizedMessage());
    }

    default String failureMessage() {
        return "Failed to Request.";
    }

    @Override
    void onResponse(@NotNull Call call, @NotNull Response response) throws IOException;
}
