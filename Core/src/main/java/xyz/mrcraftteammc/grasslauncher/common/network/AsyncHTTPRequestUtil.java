package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.*;
import org.jetbrains.annotations.ApiStatus;

import java.io.File;

@ApiStatus.Experimental
@SuppressWarnings({"deprecation", "unused"})
public final class AsyncHTTPRequestUtil {
    @Getter
    private final String str;
    private final OkHttpClient client;

    public AsyncHTTPRequestUtil(String str) {
        this.str = str;
        this.client = HTTPClientUtil.get();
    }

    public AsyncHTTPRequestUtil(String str, OkHttpClient client) {
        this.str = str;
        this.client = client;
    }

    public void get(Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .get()
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void post(RequestBody body, Callback cb) {
        Request request = new Request.Builder()
                .url(this.str)
                .post(body)
                .build();

        this.client.newCall(request).enqueue(cb);
    }
    
    public void post(MediaType type, String body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .post(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void post(MediaType type, File body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .post(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void put(RequestBody body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .put(body)
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void put(MediaType type, String body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .put(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void put(MediaType type, File body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .put(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void delete(Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .delete()
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void delete(RequestBody body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .delete(body)
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void delete(MediaType type, String body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .delete(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void delete(MediaType type, File body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .delete(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void patch(RequestBody body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .patch(body)
                .build();

        this.client.newCall(request).enqueue(cb);
    }

    public void patch(MediaType type, String body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .patch(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }
    
    public void patch(MediaType type, File body, Callback cb)  {
        Request request = new Request.Builder()
                .url(this.str)
                .patch(RequestBody.create(type, body))
                .build();

        this.client.newCall(request).enqueue(cb);
    }
}
