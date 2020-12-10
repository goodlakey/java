package by.gsu.pms;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.ArrayList;

public class SaxParser {
    public static Channel channelObj;
    public static Channel parse() throws ParserConfigurationException, SAXException, IOException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        parser.parse("resources/alfaBank.xml", handler);
        return channelObj;
    }
    private static class XMLHandler extends DefaultHandler{
        private static final ArrayList<Item> items_t = new ArrayList<Item>();
        private String title_t;
        private String link_t;
        private String date_t;
        private Channel channel_t;

        boolean title_b = false;
        boolean link_b = false;
        boolean date_b = false;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes){
            if (qName.equalsIgnoreCase("title")){
                title_b = true;
            }
            if (qName.equalsIgnoreCase("link")){
                link_b = true;
            }
            if (qName.equalsIgnoreCase("pubDate")){
                date_b = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length){
            String information = new String(ch, start, length);
            information = information.replace("\n", "").trim();
            if(!information.isEmpty()){
                if(title_b){
                    title_t = information;
                    title_b = false;
                }
                if(link_b){
                    link_t = information;
                    link_b = false;
                }
                if(date_b){
                    date_t = information;
                    date_b = false;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName){
            if(qName.equalsIgnoreCase("item")){
                if((title_t != null && !title_t.isEmpty())
                        && (link_t != null && !title_t.isEmpty())
                        && (date_t != null && !date_t.isEmpty())){
                    items_t.add(new Item(title_t, link_t, date_t));
                    channel_t = new Channel(items_t);
                }
                title_t = null;
                link_t = null;
                date_t = null;
            }
        }

        @Override
        public void endDocument(){
            channelObj = channel_t;
        }
    }
}
