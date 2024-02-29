package xyz.mrcraftteammc.grasslauncher.common.util

import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.annotation.TestOnly

class FileTests {
    @Test
    void dirs() {
        println "tempDir"
        println new File("temp/1.txt").getAbsolutePath()

        println "root"
        println new File("/").getAbsolutePath()
    }

    @TestOnly
    private final String url = "https://res.abc.com/api/v4/download/xyz/mrcraftteammc/grasslauncher/1.0.0-SNAPSHOT/GrassLauncher-1.0.0-SNAPSHOT.jar"

    @Test
    void filename() {
        println url.substring(url.lastIndexOf("/") + 1, url.length())
    }
}
