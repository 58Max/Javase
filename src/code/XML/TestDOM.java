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
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();//创建一个DOM解析工厂

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();//有解析工厂创建一个XML文件DOM解析器

        File file = new File("D:\\java\\Java_Study\\src\\code\\XML\\TestDta.xml");//对文件的控制

        Document document = documentBuilder.parse(file);//将XML文件解析到内存中，形成一个Document树

        Element root = document.getDocumentElement();//获取根节点

        NodeList taglist = root.getElementsByTagName("user");//获取根节点下标签名为"user"的标签

        Element newUser = document.createElement("user");//创建一个新“user”节点

        Element newUserName = document.createElement("username");//创建一个新的节点"username"

        Element newPassword = document.createElement("passwords");//创建一个新的节点"passwords"

        newUser.setAttribute("id","u_003");//设置newUser的属性

        newUserName.setTextContent("admin3");//设置newUserName的内容

        newPassword.setTextContent("23455");//设置newPassword的内容

        newUser.appendChild(newUserName);//将newUserName设置为newUser的子节点
        newUser.appendChild(newPassword);//将newPassword设置为newUser的子节点

        root.appendChild(newUser);//将newUser设置为根节点的子节点

        document.removeChild(newUser);


        Element user = null;

        for(int i = 0;i < taglist.getLength();i++){
            user =(Element)taglist.item(i);
            System.out.println("根节点下的标签为： " + user.getNodeName() + ", 标签的属性为： " + user.getAttribute("id") );

            NodeList childList = user.getChildNodes();//获取节点的所有子节点

            Element childTag = null;

            for(int j = 0;j < childList.getLength();j++){
                if(childList.item(j) instanceof Element) {
                    childTag = (Element) childList.item(j);
                    System.out.println("标签为： " + childTag.getNodeName() + " ,属性为： " +childTag.getTextContent());
                }
            }
        }

        //以上的这些操作改动的是文件通过解析在内存中的Document树，对文件本身并不会产生影响
        //若想将以上操作改动应用到文件中，则需执行以下操作

        TransformerFactory transformerFactory = TransformerFactory.newInstance();//创建一个转换工厂对象

        Transformer transformer = transformerFactory.newTransformer();//利用工厂创建一个转换器对象

        DOMSource domSource = new DOMSource(document);//生成一个domSource的数据源

        transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");//编码
        transformer.setOutputProperty(OutputKeys.INDENT,"yes");//缩进

        StreamResult streamResult = new StreamResult(new FileOutputStream(file));//对原文件的操作

        transformer.transform(domSource,streamResult);//将数据源传到文件中





    }
}
