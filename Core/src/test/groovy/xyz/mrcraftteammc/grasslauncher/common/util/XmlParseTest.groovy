package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.dataformat.xml.XmlMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences
import xyz.mrcraftteammc.grasslauncher.common.util.config.XmlParseHelper
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class XmlParseTest {
    private final XmlParseHelper helper = new XmlParseHelper()
    private final XmlMapper mapper = this.helper.getMapper()
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "<Simple>\n" +
            "  <name>Mr_zmh5</name>\n" +
            "  <id>41</id>\n" +
            "  <age>11.4</age>\n" +
            "  <grade>A</grade>\n" +
            "  <hobbies>\n" +
            "    <hobbies>Bilibili</hobbies>\n" +
            "    <hobbies>Minecraft</hobbies>\n" +
            "    <hobbies>Steam</hobbies>\n" +
            "  </hobbies>\n" +
            "  <urls/>\n" +
            "  <verified>true</verified>\n" +
            "</Simple>"
    private final String contentList = "<ArrayList>\n" +
            "  <item>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </item>\n" +
            "  <item>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </item>\n" +
            "  <item>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </item>\n" +
            "</ArrayList>"
    private final String contentMap = "<LinkedHashMap>\n" +
            "  <key1>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </key1>\n" +
            "  <key2>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </key2>\n" +
            "  <key3>\n" +
            "    <name>Mr_zmh5</name>\n" +
            "    <id>41</id>\n" +
            "    <age>11.4</age>\n" +
            "    <grade>A</grade>\n" +
            "    <hobbies>\n" +
            "      <hobbies>Bilibili</hobbies>\n" +
            "      <hobbies>Minecraft</hobbies>\n" +
            "      <hobbies>Steam</hobbies>\n" +
            "    </hobbies>\n" +
            "    <urls/>\n" +
            "    <verified>true</verified>\n" +
            "  </key3>\n" +
            "</LinkedHashMap>"

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
    void parseXml() {
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
