package xyz.mrcraftteammc.grasslauncher.common.network;

import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HTTPDownloadTest {
    private final String url = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png";
    protected static final String path = "D:\\Github\\GrassLauncher\\temp";
    protected static final String name = "Baidu.png";
    private final OkHttpClient client = HTTPClientUtil.get(30000, TimeUnit.MILLISECONDS);

    @Test
    public void downloadTest() throws IOException {
        Response response = new HTTPRequestUtil(this.url, this.client).get().get();

        ResponseBody body = Objects.requireNonNull(response.body());
        InputStream is = body.byteStream();
        FileOutputStream fos = new FileOutputStream(new File(path, name));

        byte[] buf = new byte[2048];
        int len;

        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
    }

    @Test
    public void downloadTestAsync() throws InterruptedException {
        new AsyncHTTPRequestUtil(this.url, this.client).get(new DownloadCallBack());
        Thread.sleep(30000);
    }

    private static final class DownloadCallBack implements CallBackImpl {
        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            ResponseBody body = Objects.requireNonNull(response.body());
            InputStream is = body.byteStream();
            FileOutputStream fos = new FileOutputStream(new File(path, name));

            byte[] buf = new byte[2048];
            int len;

            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }
            fos.flush();
            fos.close();
            is.close();
        }
    }
}
