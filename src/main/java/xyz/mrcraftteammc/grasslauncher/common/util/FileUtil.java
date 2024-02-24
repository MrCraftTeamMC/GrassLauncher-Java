package xyz.mrcraftteammc.grasslauncher.common.util;

import java.io.File;
import java.io.IOException;

public final class FileUtil {
    public static String getFilenameFromUrl(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }

    public static String getOrCreateDir(String path) throws IOException {
        File file = new File(path);

        if (!file.exists()) {
            file.createNewFile();
        }
        return file.getAbsolutePath();
    }
}
