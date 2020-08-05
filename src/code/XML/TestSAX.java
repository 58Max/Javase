package code.XML;

import org.xml.sax.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class TestSAX {
    public static void main(String []args) throws Exception{
        SAXParserFactory saxParserFactory = SAXParserFactory.newDefaultInstance();//����SAX��������������
        SAXParser saxParser = saxParserFactory.newSAXParser();//ͨ��SAX��������SAX����������

        XMLReader xmlReader = saxParser.getXMLReader();//����SAX���������󴴽�Reader����

        xmlReader.setContentHandler(new XMLContentHandler());//�������ݴ�����

        xmlReader.parse("D:\\java\\Java_Study\\src\\code\\XML\\TestDta.xml");//������Ҫ��ȡ���ļ���·��
    }
}
class XMLContentHandler implements ContentHandler{

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("��ʼִ��");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("ִ�����");
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
