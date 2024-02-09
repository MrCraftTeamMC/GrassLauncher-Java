package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class YamlParseTest {
    private final YAMLMapper mapper = YAMLMapper.builder()
            .disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
            .build()
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "name: \"Mr_zmh5\"\n" +
            "id: 41\n" +
            "age: 11.4\n" +
            "grade: \"A\"\n" +
            "hobbies:\n" +
            "- \"Bilibili\"\n" +
            "- \"Minecraft\"\n" +
            "- \"Steam\"\n" +
            "urls: {}\n" +
            "verified: true"
    private final String contentList = "- name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true\n" +
            "- name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true\n" +
            "- name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true"
    private final String contentMap = "key1:\n" +
            "  name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true\n" +
            "key2:\n" +
            "  name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true\n" +
            "key3:\n" +
            "  name: \"Mr_zmh5\"\n" +
            "  id: 41\n" +
            "  age: 11.4\n" +
            "  grade: \"A\"\n" +
            "  hobbies:\n" +
            "  - \"Bilibili\"\n" +
            "  - \"Minecraft\"\n" +
            "  - \"Steam\"\n" +
            "  urls: {}\n" +
            "  verified: true"

    @Test
    void parseObject() {
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simple)
    }

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
    void parseYaml() {
        println this.mapper.readValue(this.content, Simple.class)
    }

    @Test
    void parse2List() {
        println this.mapper.readValue(this.contentList, TypeReferences.LIST.getTypeReference())
    }

    @Test
    void parse2Map() {
        println this.mapper.readValue(this.contentMap, TypeReferences.MAP.getTypeReference());
    }
}
