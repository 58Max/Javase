package code.XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;

public class TestDOM {
    public static void main(String []args) throws Exception{
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();//����һ��DOM��������

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();//�н�����������һ��XML�ļ�DOM������

        File file = new File("D:\\java\\Java_Study\\src\\code\\XML\\TestDta.xml");//���ļ��Ŀ���

        Document document = documentBuilder.parse(file);//��XML�ļ��������ڴ��У��γ�һ��Document��

        Element root = document.getDocumentElement();//��ȡ���ڵ�

        NodeList taglist = root.getElementsByTagName("user");//��ȡ���ڵ��±�ǩ��Ϊ"user"�ı�ǩ

        Element newUser = document.createElement("user");//����һ���¡�user���ڵ�

        Element newUserName = document.createElement("username");//����һ���µĽڵ�"username"

        Element newPassword = document.createElement("passwords");//����һ���µĽڵ�"passwords"

        newUser.setAttribute("id","u_003");//����newUser������

        newUserName.setTextContent("admin3");//����newUserName������

        newPassword.setTextContent("23455");//����newPassword������

        newUser.appendChild(newUserName);//��newUserName����ΪnewUser���ӽڵ�
        newUser.appendChild(newPassword);//��newPassword����ΪnewUser���ӽڵ�

        root.appendChild(newUser);//��newUser����Ϊ���ڵ���ӽڵ�

        document.removeChild(newUser);


        Element user = null;

        for(int i = 0;i < taglist.getLength();i++){
            user =(Element)taglist.item(i);
            System.out.println("���ڵ��µı�ǩΪ�� " + user.getNodeName() + ", ��ǩ������Ϊ�� " + user.getAttribute("id") );

            NodeList childList = user.getChildNodes();//��ȡ�ڵ�������ӽڵ�

            Element childTag = null;

            for(int j = 0;j < childList.getLength();j++){
                if(childList.item(j) instanceof Element) {
                    childTag = (Element) childList.item(j);
                    System.out.println("��ǩΪ�� " + childTag.getNodeName() + " ,����Ϊ�� " +childTag.getTextContent());
                }
            }
        }

        //���ϵ���Щ�����Ķ������ļ�ͨ���������ڴ��е�Document�������ļ������������Ӱ��
        //���뽫���ϲ����Ķ�Ӧ�õ��ļ��У�����ִ�����²���

        TransformerFactory transformerFactory = TransformerFactory.newInstance();//����һ��ת����������

        Transformer transformer = transformerFactory.newTransformer();//���ù�������һ��ת��������

        DOMSource domSource = new DOMSource(document);//����һ��domSource������Դ

        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");//����
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");//����

        StreamResult streamResult = new StreamResult(new FileOutputStream(file));//��ԭ�ļ��Ĳ���

        transformer.transform(domSource,streamResult);//������Դ�����ļ���





    }
}
