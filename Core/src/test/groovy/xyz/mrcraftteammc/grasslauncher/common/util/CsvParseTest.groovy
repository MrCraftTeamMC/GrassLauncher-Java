package xyz.mrcraftteammc.grasslauncher.common.util

import com.fasterxml.jackson.databind.MappingIterator
import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import org.junit.jupiter.api.Test
import xyz.mrcraftteammc.grasslauncher.common.util.config.model.CsvSimple

class CsvParseTest {
    private final CsvMapper mapper = new CsvMapper()
    private final CsvSimple simple = new CsvSimple("Mr_zmh5", 41, 11.4f, 'A' as char, true)
    private final String content = "Mr_zmh5,41,11.4,A,true"
    private final CsvSchema schema = this.mapper.schemaFor CsvSimple.class

    @Test
    void parseObject() {
        println this.mapper.writer(this.schema).writeValueAsString(this.simple)
    }

    @Test
    void parseCsv() {
        println this.mapper.readerFor(CsvSimple.class).with(this.schema).readValue(this.content)
    }

//    @Test
    void parseCsvs() {
        MappingIterator<CsvSimple> iterator = this.mapper.readerFor(CsvSimple.class).with(this.schema).readValue(this.content)
        List<CsvSimple> csvSimpleList = iterator.readAll()
        csvSimpleList.forEach { item ->
            println item
        }
    }
}
