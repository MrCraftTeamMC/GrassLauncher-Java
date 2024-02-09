package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.Simple

class YamlParseTest {
    private final ObjectMapper mapper = new YAMLMapper();
    private final Simple simple = new Simple("Mr_zmh5", 41, 11.4f, 'A' as char, Arrays.asList("Bilibili", "Minecraft", "Steam"), new LinkedHashMap<>(), true)
    private final List<Simple> simpleList = new ArrayList<>()
    private final Map<String, Simple> simpleMap = new LinkedHashMap<>()
    private final String content = "{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}"
    private final String contentList = "[{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}]"
    private final String contentMap = "{\"key1\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},\"key2\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true},\"key3\":{\"name\":\"Mr_zmh5\",\"id\":41,\"age\":11.4,\"grade\":\"A\",\"hobbies\":[\"Bilibili\",\"Minecraft\",\"Steam\"],\"urls\":{},\"verified\":true}}"
}
