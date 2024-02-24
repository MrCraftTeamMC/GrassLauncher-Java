package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

@Getter
public final class HTTPClientUtil {
    public static OkHttpClient get() {
        return new OkHttpClient();
    }

    public static OkHttpClient get(long timeout, TimeUnit unit) {
        return new OkHttpClient.Builder()
                .connectTimeout(timeout, unit)
                .callTimeout(timeout, unit)
                .readTimeout(timeout, unit)
                .writeTimeout(timeout, unit)
                .build();
    }

    public static OkHttpClient get(long timeout, TimeUnit unit, Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(timeout, unit)
                .callTimeout(timeout, unit)
                .readTimeout(timeout, unit)
                .writeTimeout(timeout, unit)
                .build();
    }

    public static OkHttpClient get(long timeout, TimeUnit unit, Cache cache, boolean redirect) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .connectTimeout(timeout, unit)
                .followRedirects(redirect)
                .callTimeout(timeout, unit)
                .readTimeout(timeout, unit)
                .writeTimeout(timeout, unit)
                .build();
    }
}
