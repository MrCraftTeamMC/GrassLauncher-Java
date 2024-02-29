package xyz.mrcraftteammc.grasslauncher.common.game.download.getbukkit

import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import org.jetbrains.annotations.NotNull
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.network.AsyncHTTPRequestUtil
import xyz.mrcraftteammc.grasslauncher.common.network.CallBackImpl
import xyz.mrcraftteammc.grasslauncher.common.network.HTTPClientUtil
import xyz.mrcraftteammc.grasslauncher.common.util.FileUtils

class CraftBukkitDownloadTest {
    private final String url_modern = "https://download.getbukkit.org/craftbukkit/craftbukkit-1.20.4.jar" // >=1.17
    private final String url_legacy = "https://cdn.getbukkit.org/craftbukkit/craftbukkit-1.16.5.jar" // <=1.16.5

    private final String filename_modern = FileUtils.getFilenameFromUrl this.url_modern
    private final String filename_legacy = FileUtils.getFilenameFromUrl this.url_legacy
    private final String filename = "craftbukkit.jar"
    private final String filepath = "temp/"

    private final OkHttpClient client = HTTPClientUtil.get()

    @Test
    void modern_download() {
        new AsyncHTTPRequestUtil(this.url_modern, this.client).get(new DownloadCallBack())
        Thread.sleep 10000
    }

    @Test
    void legacy_download() {
        new AsyncHTTPRequestUtil(this.url_legacy, this.client).get(new DownloadCallBack())
        Thread.sleep 10000
    }

    private final class DownloadCallBack implements CallBackImpl {
        @Override
        void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
            ResponseBody body = Objects.requireNonNull response.body()
            InputStream is = body.byteStream()

            File file = new File(filepath, filename)
//            if (!file.exists()) {
//                file.createNewFile()
//            }
            FileOutputStream fos = new FileOutputStream(file)

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
