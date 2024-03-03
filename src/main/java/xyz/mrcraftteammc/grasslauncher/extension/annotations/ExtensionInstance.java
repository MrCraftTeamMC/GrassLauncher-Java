package xyz.mrcraftteammc.grasslauncher.extension.annotations;

import xyz.mrcraftteammc.grasslauncher.extension.Extension;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ExtensionInstance {
    Class<?> value() default Extension.class;
}
