package xyz.mrcraftteammc.grasslauncher.common.game

import com.fasterxml.jackson.databind.json.JsonMapper
import okhttp3.OkHttpClient
import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.network.HTTPClientUtil
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences

import java.nio.charset.StandardCharsets
import java.util.concurrent.TimeUnit

class GameDownloadTest {
    private final String url = "http://launchermeta.mojang.com/mc/game/version_manifest_v2.json"
    private final JsonMapper mapper = new JsonMapper()
    private final OkHttpClient client = HTTPClientUtil.get(10000, TimeUnit.MILLISECONDS)

    @Test
    void parseManifest() {
        String manifest = IOUtils.toString(new URL(this.url), StandardCharsets.UTF_8)
        Map<String, ?> map = this.mapper.readValue(manifest, TypeReferences.MAP.getTypeReference())

        Map<String, String> latest = (Map<String, String>) map.get("latest")
        println "Latest Release: " + latest.get("release")
        println "Latest Snapshot: " + latest.get("snapshot")

        List<Map<String, String>> versions = (List<Map<String, String>>) map.get("versions")
        versions.forEach { version ->
            version.forEach { key, value ->
                println key + " | " + value
            }
        }
    }

    private final String version_url = "https://piston-meta.mojang.com/v1/packages/1ea0afa4d4caba3a752fd8f0725b7b83eb879514/1.20.4.json"

    @Test
    void parseVersion() {
        String manifest = IOUtils.toString(new URL(this.version_url), StandardCharsets.UTF_8)
        Map<String, ?> map = this.mapper.readValue(manifest, TypeReferences.MAP.getTypeReference())

        Map<String, List<?>> arguments = (Map<String, List<?>>) map.get("arguments")

        arguments.forEach { key, value ->
            value.forEach { item ->
                if (item instanceof Map<String, ?>) {
                    item.forEach { key2, value2 ->
                        if (value2 instanceof List<?>) {
                            value2.forEach {item2 ->
                                if (item2 instanceof Map<String, ?>) {
                                    item2.forEach { key3, value3 ->
                                        if (value3 instanceof Map<String, ?>) {
                                            value3.forEach { key4, value4 ->
                                                println key4 + " | " + value4
                                            }
                                        } else {
                                            println key3 + " | " + value3
                                        }
                                    }
                                } else {
                                    println item2
                                }
                            }
                        } else {
                            println key2 + " | " + value2
                        }
                    }
                } else {
                    println item
                }
            }
        }
    }
}
