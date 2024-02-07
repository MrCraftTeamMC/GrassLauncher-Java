package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.*;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"deprecation", "unused"})
public final class HTTPRequestUtil {
    @Getter
    private final String str;
    private final OkHttpClient client;

    public HTTPRequestUtil(String str) {
        this.str = str;
        this.client = HTTPClientUtil.get();
    }

    public HTTPRequestUtil(String str, OkHttpClient client) {
        this.str = str;
        this.client = client;
    }

    public Container<Response> get() throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .get()
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(body)
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(body)
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete() throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete()
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(body)
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(body)
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(RequestBody.create(type, body))
                .build();

        Response response = this.client.newCall(request).execute();
        return Container.of(response);
    }

    public static MediaType get(String str) {
        return MediaType.parse(str);
    }
}
