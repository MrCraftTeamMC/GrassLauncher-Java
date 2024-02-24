package xyz.mrcraftteammc.grasslauncher.main;

import xyz.mrcraftteammc.grasslauncher.common.GrassLauncher;

public class Main {
    public static void main(String[] args) {
        GrassLauncher.LOGGER.info("Hello GrassLauncher!");

        if (args != null) {
            return;
        }

        System.err.println("No Args!");
    }
}
