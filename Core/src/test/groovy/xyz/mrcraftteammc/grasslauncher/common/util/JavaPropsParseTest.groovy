package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.dataformat.javaprop.JavaPropsMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class JavaPropsParseTest {
    private final JavaPropsMapper mapper = new JavaPropsMapper()
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "name=Mr_zmh5\n" +
            "id=41\n" +
            "age=11.4\n" +
            "grade=A\n" +
            "hobbies.1=Bilibili\n" +
            "hobbies.2=Minecraft\n" +
            "hobbies.3=Steam\n" +
            "verified=true"
    private final String contentList = "1.name=Mr_zmh5\n" +
            "1.id=41\n" +
            "1.age=11.4\n" +
            "1.grade=A\n" +
            "1.hobbies.1=Bilibili\n" +
            "1.hobbies.2=Minecraft\n" +
            "1.hobbies.3=Steam\n" +
            "1.verified=true\n" +
            "2.name=Mr_zmh5\n" +
            "2.id=41\n" +
            "2.age=11.4\n" +
            "2.grade=A\n" +
            "2.hobbies.1=Bilibili\n" +
            "2.hobbies.2=Minecraft\n" +
            "2.hobbies.3=Steam\n" +
            "2.verified=true\n" +
            "3.name=Mr_zmh5\n" +
            "3.id=41\n" +
            "3.age=11.4\n" +
            "3.grade=A\n" +
            "3.hobbies.1=Bilibili\n" +
            "3.hobbies.2=Minecraft\n" +
            "3.hobbies.3=Steam\n" +
            "3.verified=true"
    private final String contentMap = "key1.name=Mr_zmh5\n" +
            "key1.id=41\n" +
            "key1.age=11.4\n" +
            "key1.grade=A\n" +
            "key1.hobbies.1=Bilibili\n" +
            "key1.hobbies.2=Minecraft\n" +
            "key1.hobbies.3=Steam\n" +
            "key1.verified=true\n" +
            "key2.name=Mr_zmh5\n" +
            "key2.id=41\n" +
            "key2.age=11.4\n" +
            "key2.grade=A\n" +
            "key2.hobbies.1=Bilibili\n" +
            "key2.hobbies.2=Minecraft\n" +
            "key2.hobbies.3=Steam\n" +
            "key2.verified=true\n" +
            "key3.name=Mr_zmh5\n" +
            "key3.id=41\n" +
            "key3.age=11.4\n" +
            "key3.grade=A\n" +
            "key3.hobbies.1=Bilibili\n" +
            "key3.hobbies.2=Minecraft\n" +
            "key3.hobbies.3=Steam\n" +
            "key3.verified=true"

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
    void parseJavaProps() {
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
