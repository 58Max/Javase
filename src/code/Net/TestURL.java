package code.Net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//两种方式获取连接的信息
public class TestURL {
    public static void main(String []args) throws Exception{
        URL url = new URL("http://how2j.cn/");

        System.out.println(url.getProtocol());//获取该链接的协议
        System.out.println(url.getHost());//获取链接的域名

//        InputStream inputStream = url.openStream();//从网络上读取数据
//        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//转换流
//        String line = "";
//        while(null != (line = bufferRead.readLine())){           //输出该链接的所有内容
//            System.out.println(line);
//        }
//
//        inputStream.close();//关闭字节流
//        bufferRead.close();//关闭转化换字节流


        URLConnection urlConnection =url.openConnection();//返回URLConnection对象

        InputStream inputStream = urlConnection.getInputStream();//输出网页的所有信息

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//转换流
        String line = "";
        while(null != (line = bufferRead.readLine())){           //输出该链接的所有内容
            System.out.println(line);
        }

        inputStream.close();//关闭字节流
        bufferRead.close();//关闭转化换字节流

    }
}
