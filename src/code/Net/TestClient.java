package code.Net;

import java.util.Scanner;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TestClient {
    public static void main(String [] args) throws Exception {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9999);//与IP地址为"10.220.7.68"的主机上的端口为"9999"服务器端建立TCP连接

        Scanner cin = new Scanner(System.in);
        String name = cin.nextLine();
        OutputStream outputStream = socket.getOutputStream();//向服务端发送数据
        outputStream.write(name.getBytes());
        socket.shutdownOutput();//关闭输出流

        InputStream inputStream = socket.getInputStream();//从服务端接受数据
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(bufferedReader.readLine());
        socket.shutdownInput();//关闭接收流

        socket.close();//关闭监听Socket
    }
}
