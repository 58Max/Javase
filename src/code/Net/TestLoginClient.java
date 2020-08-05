package code.Net;

import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TestLoginClient {
    public static void main(String [] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),3030);//与本机上的端口为"7654"服务器端建立TCP连接

        while(true) {

            OutputStream outputStream = socket.getOutputStream();//向服务端发送数据
            Scanner cin = new Scanner(System.in);
            String user_name_passwords = cin.nextLine();
            outputStream.write(user_name_passwords.getBytes());
            socket.shutdownOutput();//关闭输出流

            InputStream inputStream = socket.getInputStream();//从服务端接受数据
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());//输出服务端发送过来的数据
            bufferedReader.close();
            socket.shutdownInput();//关闭接收
            socket.close();
        }



    }
}
