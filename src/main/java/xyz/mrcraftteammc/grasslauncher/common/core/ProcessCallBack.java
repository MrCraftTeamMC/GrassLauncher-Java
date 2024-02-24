package xyz.mrcraftteammc.grasslauncher.common.core;

import lombok.Getter;

@Getter
public class ProcessCallBack {
    private final int exitCode;
    private boolean crashed = false;

    public ProcessCallBack(int exitCode) {
        this.exitCode = exitCode;
        if (exitCode != 0) {
            this.crashed = true;
        }
    }
}
