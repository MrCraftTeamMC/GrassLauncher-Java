package xyz.mrcraftteammc.grasslauncher.i18n

import org.junit.jupiter.api.Test

class i18nTest {
    @Test
    void lang() {
        println "${Locale.getDefault().getLanguage()}_${Locale.getDefault().getCountry().toLowerCase(Locale.ROOT)}"
    }
}
