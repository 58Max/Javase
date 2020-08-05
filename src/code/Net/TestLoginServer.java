package code.Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestLoginServer {
    public static void main(String [] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(3030);//创建一个服务端，端口为：9999

        Socket socket = serverSocket.accept();//监听客户端的TCP连接

        while(true) {
            InputStream inputStream = socket.getInputStream();//接收客户端发送的数据；
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));//把接收的数据进行转换
            String answer = bufferedReader.readLine();//用字符串来接收服务端发过来的内容
            System.out.println(answer);
            socket.shutdownInput();//关闭接收流

            OutputStream outputStream = socket.getOutputStream();//向客户端发送数据
            outputStream.write(answer.getBytes());
            socket.shutdownOutput();//关闭输出流
            socket.close();
        }

        //      serverSocket.close();//关闭服务器端
        }

}
