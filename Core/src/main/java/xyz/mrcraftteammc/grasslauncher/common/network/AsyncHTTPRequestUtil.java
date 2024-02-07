package xyz.mrcraftteammc.grasslauncher.common.network;

import okhttp3.*;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;
import java.io.IOException;

@ApiStatus.Experimental
@SuppressWarnings("unused")
public class AsyncHTTPRequestUtil {
    private final String str;

    public AsyncHTTPRequestUtil(String str) {
        this.str = str;
    }

    public void get(OkHttpClient client, Callback cb) throws IOException {
        Request request = new Request.Builder()
                .url(this.str)
                .get()
                .build();

        client.newCall(request).enqueue(cb);
    }

    public void post(OkHttpClient client, RequestBody body, Callback cb) throws IOException {
    }
    
    public void post(OkHttpClient client, MediaType type, String body, Callback cb) throws IOException {
    }

    public void post(OkHttpClient client, MediaType type, File body, Callback cb) throws IOException {
    }

    public void put(OkHttpClient client, RequestBody body, Callback cb) throws IOException {
    }

    public void put(OkHttpClient client, MediaType type, String body, Callback cb) throws IOException {
    }

    public void put(OkHttpClient client, MediaType type, File body, Callback cb) throws IOException {
    }

    public void delete(OkHttpClient client, Callback cb) throws IOException {
    }

    public void delete(OkHttpClient client, RequestBody body, Callback cb) throws IOException {
    }

    public void delete(OkHttpClient client, MediaType type, String body, Callback cb) throws IOException {
    }

    public void delete(OkHttpClient client, MediaType type, File body, Callback cb) throws IOException {
    }

    public void patch(OkHttpClient client, RequestBody body, Callback cb) throws IOException {
    }

    public void patch(OkHttpClient client, MediaType type, String body, Callback cb) throws IOException {
    }
    
    public void patch(OkHttpClient client, MediaType type, File body, Callback cb) throws IOException {
    }
}
