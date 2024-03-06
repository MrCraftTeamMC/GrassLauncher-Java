package xyz.mrcraftteammc.grasslauncher.i18n;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.ApiStatus;
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

@ToString
@Getter
public abstract class Text {
    private final Locale locale = Locale.getDefault();

    public abstract String getText(String id, Object[] args, String defaultText) throws IOException;

    public String getText(String id, Object[] args) throws IOException {
        return this.getText(id, args, "");
    }

    public String getText(String id) throws IOException {
        return this.getText(id, null);
    }

    public static Text literal() {
        return new LiteralText();
    }

    public static Text translatable() {
        return new TranslatableText();
    }

    @ApiStatus.Experimental
    public static Text immutable() {
        return null;
    }

    private static final class LiteralText extends Text {
        @Override
        public String getText(String id, Object[] args, String defaultText) {
            if (id == null || id.isEmpty()) {
                return defaultText;
            }

            return id;
        }
    }

    private static final class TranslatableText extends Text {
        @Override
        public String getText(String id, Object[] args, String defaultText) throws IOException {
            if (id == null || id.isEmpty()) {
                return defaultText;
            }

            ResourceBundle bundle = ResourceBundle.getBundle("i18n.lang", Locale.getDefault());
            String text = bundle.getString(id);

            if (args != null) {
                for (Object o : args) {
                    text = text.replaceFirst("%?", o.toString());
                }
            }

            return text;
        }
    }

    @ApiStatus.Experimental
    private static abstract class ImmutableText extends Text {
    }

    @FunctionalInterface
    public interface TextSupplier {
        String get(String id);
    }

    @FunctionalInterface
    public interface TextModifiable {
        String toText();
    }
}
