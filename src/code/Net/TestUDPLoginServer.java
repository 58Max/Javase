package code.Net;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPLoginServer {
    public static void main(String [] argss) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(4444);//创建一个服务器端口

        byte []input = new byte[1024];//创建一个暂时储存数据的数组

        DatagramPacket indatagramPacket  = new DatagramPacket(input,0,input.length);//设置一个数据报来保存接收到的数据

        datagramSocket.receive(indatagramPacket);
        System.out.println("已接收");

        String text = new String(indatagramPacket.getData(),0,indatagramPacket.getLength());//将数据付给字符串

        TestFileOutputStream("src\\TestFile\\File09",text);//调用TestFileOutputStream()方法将接收到的数据写入到想要写道的地方

        byte []out = "这里是58max".getBytes();//创建一个数组来暂时储存将要发送的数据
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length,indatagramPacket.getAddress(),indatagramPacket.getPort());//设置一个数据报来储存将要发送的数据

        datagramSocket.send(outdatagramPacket);//发送数据
        System.out.println("已发送");

        datagramSocket.close();//关闭服务端

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
