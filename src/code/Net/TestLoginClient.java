package code.Net;

import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TestLoginClient {
    public static void main(String [] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),3030);//�뱾���ϵĶ˿�Ϊ"7654"�������˽���TCP����

        while(true) {

            OutputStream outputStream = socket.getOutputStream();//�����˷�������
            Scanner cin = new Scanner(System.in);
            String user_name_passwords = cin.nextLine();
            outputStream.write(user_name_passwords.getBytes());
            socket.shutdownOutput();//�ر������

            InputStream inputStream = socket.getInputStream();//�ӷ���˽�������
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());//�������˷��͹���������
            bufferedReader.close();
            socket.shutdownInput();//�رս���
            socket.close();
        }



    }
}
