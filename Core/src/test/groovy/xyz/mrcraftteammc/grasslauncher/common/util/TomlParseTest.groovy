package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.dataformat.toml.TomlMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.annotation.Bug
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class TomlParseTest {
    private final TomlMapper mapper = new TomlMapper()
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "name = 'Mr_zmh5'\n" +
            "id = 41\n" +
            "age = 11.4\n" +
            "grade = 'A'\n" +
            "hobbies = ['Bilibili', 'Minecraft', 'Steam']\n" +
            "urls = {}\n" +
            "verified = true"
    private final String contentList = "[{name = 'Mr_zmh5', id = 41, age = 11.4, grade = 'A', hobbies = ['Bilibili', 'Minecraft', 'Steam'], urls = {}, verified = true}, {name = 'Mr_zmh5', id = 41, age = 11.4, grade = 'A', hobbies = ['Bilibili', 'Minecraft', 'Steam'], urls = {}, verified = true}, {name = 'Mr_zmh5', id = 41, age = 11.4, grade = 'A', hobbies = ['Bilibili', 'Minecraft', 'Steam'], urls = {}, verified = true}]"
    private final String contentMap = "key1.name = 'Mr_zmh5'\n" +
            "key1.id = 41\n" +
            "key1.age = 11.4\n" +
            "key1.grade = 'A'\n" +
            "key1.hobbies = ['Bilibili', 'Minecraft', 'Steam']\n" +
            "key1.urls = {}\n" +
            "key1.verified = true\n" +
            "key2.name = 'Mr_zmh5'\n" +
            "key2.id = 41\n" +
            "key2.age = 11.4\n" +
            "key2.grade = 'A'\n" +
            "key2.hobbies = ['Bilibili', 'Minecraft', 'Steam']\n" +
            "key2.urls = {}\n" +
            "key2.verified = true\n" +
            "key3.name = 'Mr_zmh5'\n" +
            "key3.id = 41\n" +
            "key3.age = 11.4\n" +
            "key3.grade = 'A'\n" +
            "key3.hobbies = ['Bilibili', 'Minecraft', 'Steam']\n" +
            "key3.urls = {}\n" +
            "key3.verified = true"

    @Test
    void parseObject() {
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simple)
    }

    @Bug
    @Test
    void parseList() {
        for (int i=1; i<=3; i++) {
            this.simpleList.add this.simple
        }
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simpleList)
    }

    @Test
    void parseMap() {
        for (int i=1; i<=3; i++) {
            this.simpleMap.put "key" + i, this.simple
        }
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simpleMap)
    }

    @Test
    void parseToml() {
        println this.mapper.readValue(this.content, Simple.class)
    }

//    @Test
    void parse2List() {
        println this.mapper.readValue(this.contentList, TypeReferences.LIST.getTypeReference())
    }

    @Test
    void parse2Map() {
        println this.mapper.readValue(this.contentMap, TypeReferences.MAP.getTypeReference());
    }
}
