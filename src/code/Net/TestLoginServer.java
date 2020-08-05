package code.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestLoginServer {
    public static void main(String [] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(3030);//����һ������ˣ��˿�Ϊ��9999

        Socket socket = serverSocket.accept();//�����ͻ��˵�TCP����

        while(true) {
            InputStream inputStream = socket.getInputStream();//���տͻ��˷��͵����ݣ�
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));//�ѽ��յ����ݽ���ת��
            String answer = bufferedReader.readLine();//���ַ��������շ���˷�����������
            System.out.println(answer);
            socket.shutdownInput();//�رս�����

            OutputStream outputStream = socket.getOutputStream();//��ͻ��˷�������
            outputStream.write(answer.getBytes());
            socket.shutdownOutput();//�ر������
            socket.close();
        }

        //      serverSocket.close();//�رշ�������
        }

}
