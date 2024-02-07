package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.*;
import xyz.mrcraftteammc.grasslauncher.common.core.Container;

import java.io.File;
import java.io.IOException;

@SuppressWarnings({"deprecation", "unused"})
@Getter
public class HTTPRequestUtil {
    protected final String str;

    public HTTPRequestUtil(String str) {
        this.str = str;
    }

    public Container<Response> get(OkHttpClient client) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(OkHttpClient client, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(OkHttpClient client, MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> post(OkHttpClient client, MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .post(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(OkHttpClient client, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(body)
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(OkHttpClient client, MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> put(OkHttpClient client, MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .put(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(OkHttpClient client) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete()
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(OkHttpClient client, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(body)
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(OkHttpClient client, MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> delete(OkHttpClient client, MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .delete(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(OkHttpClient client, RequestBody body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(body)
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(OkHttpClient client, MediaType type, String body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public Container<Response> patch(OkHttpClient client, MediaType type, File body) throws IOException {
        Request request = new Request.Builder()
                .url(str)
                .patch(RequestBody.create(type, body))
                .build();

        Response response = client.newCall(request).execute();
        return Container.of(response);
    }

    public static MediaType get(String str) {
        return MediaType.parse(str);
    }
}
