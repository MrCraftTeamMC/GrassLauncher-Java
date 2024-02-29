package xyz.mrcraftteammc.grasslauncher.common.network

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.Test

import java.util.concurrent.TimeUnit

class HTTPRequestTest {
    private final String url = "http://www.baidu.com/"
    private final OkHttpClient client = HTTPClientUtil.get 3000, TimeUnit.SECONDS

    @Test
    void httpGet() {
        Response response = new HTTPRequestUtil(this.url, this.client).get()
        if (response.isSuccessful()) {
            println "Successful!"
            println Objects.requireNonNull(response.body()).string()
        } else {
            println "Noop."
        }
    }

    @Test
    void httpGetAsync() {
        new AsyncHTTPRequestUtil(this.url, this.client).get(new TestCallBack())
        Thread.sleep 3500
    }

    private static final class TestCallBack implements CallBackImpl {
        @Override
        void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            println "Successful!"
            println Objects.requireNonNull(response.body()).string()
        }
    }
}