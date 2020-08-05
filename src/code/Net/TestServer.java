package code.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String [] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(9999);//创建一个服务端，端口为：9999

        Socket socket = serverSocket.accept();//监听客户端的TCP连接

        InputStream inputStream = socket.getInputStream();//接收客户端发送的数据；
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));//把接收的数据进行转换
        String answer = bufferedReader.readLine();//用字符串来接收服务端发过来的内容
        System.out.println("服务端收到客服端的请求为: " + answer);

        OutputStream outputStream = socket.getOutputStream();//向客户端发送数据
        outputStream.write("服务端已经收到你的请求，你好客户端".getBytes());
        outputStream.write("111".getBytes());

        socket.shutdownInput();//关闭接收流
        socket.shutdownOutput();//关闭输出流
        socket.close();//关闭连接
//      serverSocket.close();//关闭服务器端
    }
}
