package xyz.mrcraftteammc.grasslauncher.common.game.download.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import okhttp3.OkHttpClient
import org.junit.jupiter.api.Test

class PurpurDownloadTest {
    private final String base_url = "https://api.purpurmc.org/v2?/"
    private final OkHttpClient client = new OkHttpClient()
    private final ObjectMapper mapper = new JsonMapper()

    @Test
    void versions() {

    }
}
