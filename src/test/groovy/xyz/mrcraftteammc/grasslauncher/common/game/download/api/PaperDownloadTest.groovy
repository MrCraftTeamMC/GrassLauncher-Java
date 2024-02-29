package xyz.mrcraftteammc.grasslauncher.common.game.download.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import okhttp3.OkHttpClient
import okhttp3.Request
import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences

import java.nio.charset.StandardCharsets

class PaperDownloadTest {
    private final String base_url = "https://api.papermc.io/v2/"
    private final OkHttpClient client = new OkHttpClient()
    private final ObjectMapper mapper = new JsonMapper()

    @Test
    void projects() {
        String project = this.client.newCall(new Request.Builder()
                    .url(this.base_url + "projects")
                    .get()
                    .build())
                .execute().body().string()

        Map<String, List<?>> map = (Map<String, List<?>>) this.mapper.readValue(project, TypeReferences.MAP.getTypeReference())

        map.forEach { k,v ->
            v.forEach {
                println it
            }
        }
    }

    @Test
    void description() {
        String project = this.client.newCall(new Request.Builder()
                .url(this.base_url + "projects")
                .get()
                .build())
                .execute().body().string()

        Map<String, List<?>> map = (Map<String, List<?>>) this.mapper.readValue(project, TypeReferences.MAP.getTypeReference())

        map.forEach { k,v ->
            v.forEach {
                println "$it | ${IOUtils.toString(new URL(this.base_url + "projects/$it"), StandardCharsets.UTF_8)}"
            }
        }
    }


    // Paper Only
    @Test
    void versions() {
        // https://api.papermc.io/v2/projects/paper/versions/1.20.4
        String project = this.client.newCall(new Request.Builder()
                .url(this.base_url + "projects/paper/versions/1.20.4")
                .get()
                .build())
                .execute().body().string()

        println project
    }

    @Test
    void builds() {
        String project = this.client.newCall(new Request.Builder()
                .url(this.base_url + "projects/paper/versions/1.20.4/builds")
                .get()
                .build())
                .execute().body().string()

        println project
    }

    @Test
    void download() {
        // ${PROJECT}-${LATEST_VERSION}-${LATEST_BUILD}.jar
    }
}
