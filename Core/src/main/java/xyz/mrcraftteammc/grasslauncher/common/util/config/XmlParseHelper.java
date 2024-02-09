package xyz.mrcraftteammc.grasslauncher.common.util.config;

import com.ctc.wstx.api.WstxInputProperties;
import com.ctc.wstx.api.WstxOutputProperties;
import com.ctc.wstx.stax.WstxInputFactory;
import com.ctc.wstx.stax.WstxOutputFactory;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.Getter;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;

@Getter
public class XmlParseHelper {
    private final XmlMapper mapper;

    public XmlParseHelper() {
        XMLInputFactory ifactory = new WstxInputFactory();
        ifactory.setProperty(WstxInputProperties.P_MAX_ATTRIBUTE_SIZE, 32000);
// configure
        XMLOutputFactory ofactory = new WstxOutputFactory();
        ofactory.setProperty(WstxOutputProperties.P_OUTPUT_CDATA_AS_TEXT, true);
        XmlFactory xf = XmlFactory.builder()
                .xmlInputFactory(ifactory) // note: in 2.12 and before "inputFactory()"
                .xmlOutputFactory(ofactory) // note: in 2.12 and before "outputFactory()"
                .build();

        this.mapper = new XmlMapper(xf);
    }
}
