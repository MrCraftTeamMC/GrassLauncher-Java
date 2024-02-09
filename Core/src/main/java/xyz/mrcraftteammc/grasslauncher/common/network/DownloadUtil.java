package xyz.mrcraftteammc.grasslauncher.common.network;

import lombok.Getter;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;
import xyz.mrcraftteammc.grasslauncher.common.util.FileUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public final class DownloadUtil {
    @Getter
    private final String url;
    @Getter
    private final String path;
    @Getter
    private final String file;
    private OkHttpClient client = HTTPClientUtil.get();
    private int bufLong = 2048;

    public DownloadUtil(String url, String path) {
        this.url = url;
        this.path = path;
        this.file = FileUtil.getFilenameFromUrl(url);
    }

    public DownloadUtil(String url, String path, String file) {
        this.url = url;
        this.path = path;
        this.file = file;
    }

    public DownloadUtil(String url, String path, String file, OkHttpClient client, int bufLong) {
        this.url = url;
        this.path = path;
        this.file = file;
        this.client = client;
        this.bufLong = bufLong;
    }

    public void download() {
        new AsyncHTTPRequestUtil(this.url, this.client).get(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                GrassLauncher.LOGGER.error("Failed to Download.");
                GrassLauncher.logThrowable(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                try {
                    ResponseBody body = Objects.requireNonNull(response.body());
                    InputStream is = body.byteStream();
                    FileOutputStream fos = new FileOutputStream(new File(path, file));

                    byte[] buf = new byte[bufLong];
                    int len;

                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    fos.flush();
                    fos.close();
                    is.close();
                } catch (IOException e) {
                    this.onFailure(call, e);
                }
            }
        });

        return;
    }

    public void continuableDownload() {

    }
}
