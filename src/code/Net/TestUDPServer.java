package code.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {
    public static void main(String [] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(8888);//创建一个UDP服务端接口

        byte []binput = new byte[1024];//用来暂时存放客户端发来的数据

        DatagramPacket inputdatagramPacket =  new DatagramPacket(binput,0,binput.length);//设置一个数据报用来接收客户端发来的数据

        datagramSocket.receive(inputdatagramPacket);//接收数据

        System.out.println(new String(inputdatagramPacket.getData(),0,inputdatagramPacket.getLength()));//输出客户端发送来的数据

        byte []bout = "你好!客户端！".getBytes();//发送给客户端的数据

        DatagramPacket outputdatagramPacket = new DatagramPacket(bout,0,bout.length,inputdatagramPacket.getAddress(),inputdatagramPacket.getPort());//设置一个数据报来保存发送客户端的数据
        datagramSocket.send(outputdatagramPacket);//发送数据报

        datagramSocket.close();//关闭端口



    }
}
