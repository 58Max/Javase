package code.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDPClient {
    public static void main(String [] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(7777);

        byte []out = "你好！服务端！".getBytes();//发送个服务端的数据
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length, InetAddress.getByName("127.0.0.1"),8888);//设置一个数据报保存发送给服务端的数据

        datagramSocket.send(outdatagramPacket);//把数据发送个服务端

        byte []in = new byte[1024]; //设置一个数组暂时存放服务端发送来的数据
        DatagramPacket inDatagramPacket = new DatagramPacket(in,0,in.length);//用数据报接收服务端发送来的数据

        datagramSocket.receive(inDatagramPacket);//接收数据

        System.out.println(new String(inDatagramPacket.getData(),0,inDatagramPacket.getLength()));//输出客户端发送来的数据

        datagramSocket.close();//关闭客户端
    }

}
