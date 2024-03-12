package xyz.mrcraftteammc.grasslauncher.common;

import java.nio.file.FileSystems;

public final class CommonConstants {
    public static final String NAME = "GrassLauncher";
    public static final String VERSION = "1.0.0-SNAPSHOT";

    public static final String RUN_DIR = System.getProperty("user.dir");
    public static final String JAVA_HOME = System.getProperty("java.home");
    public static final String PATH_SEPARATOR = FileSystems.getDefault().getSeparator();

    public static final String EXTENSIONS_DIR = "extensions/";
}
