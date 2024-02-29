package xyz.mrcraftteammc.grasslauncher.common.game.download.mojang

import com.fasterxml.jackson.databind.json.JsonMapper
import org.apache.commons.io.IOUtils
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences

import java.nio.charset.StandardCharsets

class MCManifestReader {
    JsonMapper mapper = new JsonMapper()

    @Test
    void readManifest() {
        String manifest = IOUtils.toString(new URL("https://launchermeta.mojang.com/mc/game/version_manifest_v2.json"), StandardCharsets.UTF_8)

        Map<String, ?> map = (Map<String, ?>) mapper.readValue(manifest, TypeReferences.MAP.getTypeReference())
        map.forEach { k, v ->
            if (k == "versions" && v instanceof List<?>) {
                v.forEach { a ->
                    if (a instanceof Map<String, ?>) {
                        println a.getOrDefault("id", "?")
                    }
                }
            }
        }
    }

    @Test
    void readVersionManifest() {
        String manifest = IOUtils.toString(new URL("https://piston-meta.mojang.com/v1/packages/487afa9d48c57e0b2137367c6596e0cf4f9fc64e/1.20.4.json"), StandardCharsets.UTF_8)

        Map<String, ?> map = (Map<String, ?>) mapper.readValue(manifest, TypeReferences.MAP.getTypeReference())
        map.forEach { k, v ->
            if (k == "downloads" && v instanceof Map<String, Map<String, ?>>) {
                v.forEach { k1, v1 ->
                    if (k1 == "server") {
                        v1.forEach { v2, k2 ->
                            println "$v2 | $k2"
                        }
                    }
                }
            }
        }
    }
}
