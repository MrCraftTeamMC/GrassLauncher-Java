package xyz.mrcraftteammc.grasslauncher.common.network

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.Test

import java.util.concurrent.TimeUnit

class HTTPDownloadTest {
    private final String url = "https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png"
    protected static final String path = "D:\\Github\\GrassLauncher\\temp"
    protected static final String name = "Baidu.png"
    private final OkHttpClient client = HTTPClientUtil.get 30000, TimeUnit.MILLISECONDS

    @Test
    void downloadTest() {
        Response response = new HTTPRequestUtil(this.url, this.client).get().get()

        ResponseBody body = Objects.requireNonNull response.body()
        InputStream is = body.byteStream()
        FileOutputStream fos = new FileOutputStream(new File(path, name))

        byte[] buf = new byte[2048]
        int len

        while ((len = is.read(buf)) != -1) {
            fos.write(buf, 0, len)
        }

        fos.flush()
        fos.close()
        is.close()
    }

    @Test
    void downloadTestAsync() {
        new AsyncHTTPRequestUtil(this.url, this.client).get(new DownloadCallBack())
        Thread.sleep 30000
    }

    private static final class DownloadCallBack implements CallBackImpl {
        @Override
        String failureMessage() {
            return "Failed to Download."
        }

        @Override
        void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            ResponseBody body = Objects.requireNonNull response.body()
            InputStream is = body.byteStream()
            FileOutputStream fos = new FileOutputStream(new File(path, name))

            byte[] buf = new byte[2048]
            int len

            while ((len = is.read(buf)) != -1) {
                fos.write(buf, 0, len)
            }
            fos.flush()
            fos.close()
            is.close()
        }
    }
}
