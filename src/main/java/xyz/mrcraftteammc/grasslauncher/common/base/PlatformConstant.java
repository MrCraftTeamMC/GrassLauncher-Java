package xyz.mrcraftteammc.grasslauncher.common.base;

import lombok.Getter;

@Getter
public enum PlatformConstant {
    VANILLA("vanilla"),

    PROXY("proxy"), // For BungeeCord-Like / Velocity

    PLUGIN("plugin"), // For Bukkit-Like / Sponge

    MOD("mod"), // For Fabric / Forge etc.

    MOD_WITH_PLUGIN("mod_with_plugin"), // For SpongeForge / Mohist / Arclight / Fabric with Cardboard or Banner mod etc.

    BDS("bds"), // For Bedrock Edition Server / LiteLoaderBDS

    @Deprecated
    MCDR("MCDR");

    private final String id;

    PlatformConstant(String id) {
        this.id = id;
    }
}
