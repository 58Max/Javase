package code.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPServer {
    public static void main(String [] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(8888);//����һ��UDP����˽ӿ�

        byte []binput = new byte[1024];//������ʱ��ſͻ��˷���������

        DatagramPacket inputdatagramPacket =  new DatagramPacket(binput,0,binput.length);//����һ�����ݱ��������տͻ��˷���������

        datagramSocket.receive(inputdatagramPacket);//��������

        System.out.println(new String(inputdatagramPacket.getData(),0,inputdatagramPacket.getLength()));//����ͻ��˷�����������

        byte []bout = "���!�ͻ��ˣ�".getBytes();//���͸��ͻ��˵�����

        DatagramPacket outputdatagramPacket = new DatagramPacket(bout,0,bout.length,inputdatagramPacket.getAddress(),inputdatagramPacket.getPort());//����һ�����ݱ������淢�Ϳͻ��˵�����
        datagramSocket.send(outputdatagramPacket);//�������ݱ�

        datagramSocket.close();//�رն˿�



    }
}
