package xyz.mrcraftteammc.grasslauncher.common.base;

import lombok.Getter;
import org.jetbrains.annotations.ApiStatus;

@Getter
public enum LoaderConstant {
    VANILLA(PlatformConstant.VANILLA, "vanilla"),
    BDS(PlatformConstant.VANILLA, "bds"),

    BUKKIT(PlatformConstant.PLUGIN, "bukkit"),
    SPIGOT(PlatformConstant.PLUGIN, "spigot"),
    PAPER(PlatformConstant.PLUGIN, "paper"),
    PURPUR(PlatformConstant.PLUGIN, "purpur"),
    LEAVES(PlatformConstant.PLUGIN, "leaves"),


    FABRIC(PlatformConstant.MOD ,"fabric"),
    FORGE(PlatformConstant.MOD ,"forge"),

    @ApiStatus.Experimental
    QUILT(PlatformConstant.MOD ,"quilt"),

    @ApiStatus.Experimental
    NEOFORGE(PlatformConstant.MOD ,"neoforge"),

    @Deprecated
    LITELOADER(PlatformConstant.MOD ,"liteloader"),

    @Deprecated
    RIFT(PlatformConstant.MOD ,"rift"),

    @Deprecated
    RML(PlatformConstant.MOD ,"rml"),


    CATSERVER(PlatformConstant.MOD_WITH_PLUGIN, "catserver"),
    MOHIST(PlatformConstant.MOD_WITH_PLUGIN, "mohist"),
    ARCLIGHT(PlatformConstant.MOD_WITH_PLUGIN, "arclight"),


    LITELOADERBDS(PlatformConstant.BDS, "liteloaderbds"),
    NUKKIT(PlatformConstant.BDS, "nukkit");

    private final String platform;
    private final String id;

    LoaderConstant(PlatformConstant platform,  String id) {
        this.platform = platform.getId();
        this.id = id;
    }
}
