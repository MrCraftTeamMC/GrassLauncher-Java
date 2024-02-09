package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.TypeReferences
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class JsonParseTest {
    private final ObjectMapper mapper = new ObjectMapper()
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}"
    private final String contentList = "[{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}]"
    private final String contentMap = "{\"key1\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},\"key2\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},\"key3\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}}"

    @Test
    void parseObject() throws JsonProcessingException {
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simple)
    }

    @Test
    void parseList() throws JsonProcessingException {
        for (int i=1; i<=3; i++) {
            this.simpleList.add(this.simple)
        }
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simpleList)
    }

    @Test
    void parseMap() throws JsonProcessingException {
        for (int i=1; i<=3; i++) {
            this.simpleMap.put("key" + i, this.simple)
        }
        println this.mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this.simpleMap)
    }

    @Test
    void parseJson() throws JsonProcessingException {
        println this.mapper.readValue(this.content, Simple.class)
    }

    @Test
    void parse2List() throws JsonProcessingException {
        println this.mapper.readValue(this.contentList, TypeReferences.LIST.getTypeReference())
    }

    @Test
    void parse2Map() throws JsonProcessingException {
        println this.mapper.readValue(this.content, TypeReferences.MAP.getTypeReference())
    }

    @Test
    void parse2Maps() throws JsonProcessingException {
        println this.mapper.readValue(this.contentMap, TypeReferences.MAP.getTypeReference())
    }
}
