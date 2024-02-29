package xyz.mrcraftteammc.grasslauncher.common.util.config;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public enum TypeReferences {
    LIST(new TypeReference<List<?>>() {
    }),
    MAP(new TypeReference<Map<?, ?>>(){
    });

    private final TypeReference<?> typeReference;

    TypeReferences(TypeReference<?> typeReference) {
        this.typeReference = typeReference;
    }
}
