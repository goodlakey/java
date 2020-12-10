package by.gsu.pms;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StaxParser {
    private static ArrayList<Item> items = new ArrayList<Item>();
    private static Channel channelObj;

    public static Channel parse() throws FileNotFoundException, XMLStreamException {
        String file = "resources/alfaBank.xml";
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(file));

        String title_t = null;
        String link_t = null;
        String date_t = null;

        boolean item_b = false;
        boolean title_b = false;
        boolean link_b = false;
        boolean date_b = false;

        while (reader.hasNext()) {
            XMLEvent xmlEvent = reader.nextEvent();
            switch (xmlEvent.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    StartElement startElement = xmlEvent.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    if (qName.equalsIgnoreCase("item")) {
                        item_b = true;
                        channelObj = new Channel();
                    }
                    if (qName.equalsIgnoreCase("title")) {
                        title_b = true;

                    } else if (qName.equals("link")) {
                        link_b = true;

                    } else if (qName.equals("pubDate")) {
                        date_b = true;

                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    Characters characters = xmlEvent.asCharacters();
                    if (title_b && item_b) {
                        title_t = characters.getData();
                        title_b = false;
                    }
                    if (link_b && item_b) {
                        link_t = characters.getData();
                        link_b = false;
                    }
                    if (date_b && item_b) {
                        date_t = characters.getData();
                        date_b = false;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("item") && item_b) {
                        if (title_t != null
                                && link_t != null
                                && date_t != null) {
                            items.add(new Item(title_t, link_t, date_t));
                        }
                        item_b = false;
                    }
                    if (endElement.getName().getLocalPart().equalsIgnoreCase("channel")) {
                        channelObj.setItems(items);
                    }
                    break;
            }
        }

        return channelObj;
    }
}
