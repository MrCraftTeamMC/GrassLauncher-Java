package xyz.mrcraftteammc.grasslauncher.common.util.config.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import xyz.mrcraftteammc.grasslauncher.common.annotation.TestOnly;

import java.util.List;
import java.util.Map;

@TestOnly
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonPropertyOrder({"name", "id", "age", "grade", "verified"})
public final class CsvSimple {
    private String name;
    private int id;
    private float age;
    private char grade;
    private boolean verified;
}
