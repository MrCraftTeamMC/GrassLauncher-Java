package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.extension.ExtensionManifest

class ExtensionYmlParseTest {
    @Test
    void test() {
        URLClassLoader loader = new URLClassLoader(new URL[]{"file://D:/Github/GrassLauncher/temp/extensions/GrassLauncher-Extension-Template-1.0.0.jar".toURL()})

        InputStream is = loader.getResourceAsStream("grasslauncher.extension.yml")

        YAMLMapper mapper = new YAMLMapper()

        println mapper.readValue(is, ExtensionManifest.class)
    }

    @Test
    void decode() {
        YAMLMapper mapper = new YAMLMapper()

        println mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ExtensionManifest.defaultManifest())
    }
}
