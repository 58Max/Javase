package code.Net;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDPLoginClient {
    public static void main(String [] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(3333);//创建一个端口为 6666 的客户端

        byte []out = "你好，58max".getBytes();//创建一个临时存储数据的数组
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length, InetAddress.getByName("127.0.0.1"),4444);//发送的数据报

        datagramSocket.send(outdatagramPacket);//发送数据报
        System.out.println("已发送");

        byte []in = new byte[1024];//创建一个数组用来临时存储数据
        DatagramPacket indatagramPacket = new DatagramPacket(in,0,in.length);//设置一个数据报用来接收数据

        datagramSocket.receive(indatagramPacket);//接收数据
        System.out.println("已接收");

        String text = new String(indatagramPacket.getData(),0,indatagramPacket.getLength());

        TestFileOutputStream("src\\TestFile\\File10",text);//将接收到的数据写入目的文件

        datagramSocket.close();//关闭客户端
    }
    //把数据写入文件
    public static void TestFileOutputStream(String inpath,String text){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(inpath);//如果该文件不存在将会创建一个新文件

            //如果该文件存在注入的数据将会覆盖之前的数据
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
