package code.Net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

//���ַ�ʽ��ȡ���ӵ���Ϣ
public class TestURL {
    public static void main(String []args) throws Exception{
        URL url = new URL("http://how2j.cn/");

        System.out.println(url.getProtocol());//��ȡ�����ӵ�Э��
        System.out.println(url.getHost());//��ȡ���ӵ�����

//        InputStream inputStream = url.openStream();//�������϶�ȡ����
//        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//ת����
//        String line = "";
//        while(null != (line = bufferRead.readLine())){           //��������ӵ���������
//            System.out.println(line);
//        }
//
//        inputStream.close();//�ر��ֽ���
//        bufferRead.close();//�ر�ת�����ֽ���


        URLConnection urlConnection =url.openConnection();//����URLConnection����

        InputStream inputStream = urlConnection.getInputStream();//�����ҳ��������Ϣ

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//ת����
        String line = "";
        while(null != (line = bufferRead.readLine())){           //��������ӵ���������
            System.out.println(line);
        }

        inputStream.close();//�ر��ֽ���
        bufferRead.close();//�ر�ת�����ֽ���

    }
}
