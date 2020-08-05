package code.XML;

import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestSAX {
    public static void main(String []args) throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newDefaultInstance();//创建SAX解析器工厂对象
        SAXParser saxParser = saxParserFactory.newSAXParser();//通过SAX工厂创建SAX解析器对象

        XMLReader xmlReader = saxParser.getXMLReader();//利用SAX解析器对象创建Reader对象

        xmlReader.setContentHandler(new XMLContentHandler());//设置内容处理器

        xmlReader.parse("D:\\java\\Java_Study\\src\\code\\XML\\TestDta.xml");//设置需要读取的文件的路径
    }
}
class XMLContentHandler implements ContentHandler{

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("开始执行");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("执行完毕");
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        System.out.print("<" + qName + " ");
        for(int i = 0;i < atts.getLength();i++){
            System.out.print(atts.getQName(i) + "=\"" +atts.getValue(i) +"\" ");
        }
        System.out.println(">");
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("</" + qName +">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println(new String(ch,start,length));
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {

    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {

    }

    @Override
    public void skippedEntity(String name) throws SAXException {

    }
}
