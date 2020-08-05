package code.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String [] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);//����һ������ˣ��˿�Ϊ��9999

        Socket socket = serverSocket.accept();//�����ͻ��˵�TCP����

        InputStream inputStream = socket.getInputStream();//���տͻ��˷��͵����ݣ�
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//�ѽ��յ����ݽ���ת��
        String answer = bufferedReader.readLine();//���ַ��������շ���˷�����������
        System.out.println("������յ��ͷ��˵�����Ϊ: " + answer);

        OutputStream outputStream = socket.getOutputStream();//��ͻ��˷�������
        outputStream.write("������Ѿ��յ����������ÿͻ���".getBytes());
        outputStream.write("111".getBytes());

        socket.shutdownInput();//�رս�����
        socket.shutdownOutput();//�ر������
        socket.close();//�ر�����
//      serverSocket.close();//�رշ�������
    }
}
