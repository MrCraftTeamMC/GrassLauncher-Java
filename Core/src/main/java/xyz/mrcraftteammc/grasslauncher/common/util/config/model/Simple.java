package xyz.mrcraftteammc.grasslauncher.common.util.config.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.mrcraftteammc.grasslauncher.common.annotation.TestOnly;

import java.util.List;
import java.util.Map;

@TestOnly
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Simple {
    private String name;
    private int id;
    private float age;
    private char grade;
    private List<String> hobbies;
    private Map<String, String> urls;
    private boolean verified;
}
