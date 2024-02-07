package xyz.mrcraftteammc.grasslauncher.common.network;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HTTPRequestTest {
    private final String url = "http://www.baidu.com/";
    private final OkHttpClient client = HTTPClientUtil.get(3000, TimeUnit.SECONDS);

    @Test
    public void testGet() throws IOException {
        Response response = new HTTPRequestUtil(this.url).get(this.client).get();
        if (response.isSuccessful()) {
            System.out.println("Successful!");
            System.out.println(Objects.requireNonNull(response.body()).string());
        } else {
            System.err.println("Noop.");
        }
    }

    @Test
    public void testGetAsync() throws IOException, InterruptedException {
        AsyncHTTPRequestUtil util = new AsyncHTTPRequestUtil(this.url);
        util.get(this.client, new TestCallBack());
        Thread.sleep(3500);
    }


    private static final class TestCallBack implements CallBackImpl {
        @Override
        public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            System.out.println("Successful!");
            System.out.println(Objects.requireNonNull(response.body()).string());
        }
    }
}
