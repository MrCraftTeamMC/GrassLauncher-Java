package xyz.mrcraftteammc.grasslauncher.common.core;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

@SuppressWarnings({"unused"})
@EqualsAndHashCode
@ToString
public abstract class Text
        implements Serializable, Cloneable, Comparable<String>, CharSequence {
    private static final long serialVersionUID = 1L;

    public abstract String getText(String id, String defaultText, Object... args);

    public String getText(String id, Object... args) {
        return this.getText(id, "" , args);
    }

    public String getText(String id) {
        return this.getText(id, (Object[]) null);
    }

    public String getText(Object o) {
        return this.getText(o.toString());
    }

    @Contract(" -> new")
    @NotNull
    public static Text literal() {
        return new LiteralText();
    }

    @Contract(" -> new")
    @NotNull
    public static Text translatable() {
        return new TranslatableText();
    }

    @Override
    public Text clone() {
        try {
            return (Text) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    private static class LiteralText extends Text {
        private String text = "";

        @Override
        public String getText(String id, String defaultText, Object... args) {
            if (id == null || id.isEmpty()) {
                return defaultText;
            }

            if (args != null) {
                for (Object o : args) {
                    id = id.replaceFirst("%_", o.toString());
                }
            }

            this.text = id;
            return id;
        }

        @Override
        public int length() {
            return this.text.length();
        }

        @Override
        public char charAt(int index) {
            return this.text.charAt(index);
        }

        @NotNull
        @Override
        public CharSequence subSequence(int start, int end) {
            return this.text.subSequence(start, end);
        }

        @Override
        public int compareTo(@NotNull String o) {
            return this.text.compareTo(o);
        }
    }

    private static class TranslatableText extends Text {
        private String text = "";

        @Override
        public String getText(String id, String defaultText, Object... args) {
            if (id == null || id.isEmpty()) {
                return defaultText;
            }

            ResourceBundle bundle = ResourceBundle.getBundle("i18n.lang", Locale.getDefault());
            String text2 = bundle.getString(id);

            if (args != null) {
                for (Object o : args) {
                    text2 = text2.replaceFirst("%_", o.toString());
                }
            }

            this.text = text2;
            return text2;
        }

        @Override
        public int length() {
            return this.text.length();
        }

        @Override
        public char charAt(int index) {
            return this.text.charAt(index);
        }

        @NotNull
        @Override
        public CharSequence subSequence(int start, int end) {
            return this.text.subSequence(start, end);
        }

        @Override
        public int compareTo(@NotNull String o) {
            return this.text.compareTo(o);
        }
    }
}
