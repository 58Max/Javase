package code.Net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDPClient {
    public static void main(String [] args) throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket(7777);

        byte []out = "��ã�����ˣ�".getBytes();//���͸�����˵�����
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length, InetAddress.getByName("127.0.0.1"),8888);//����һ�����ݱ����淢�͸�����˵�����

        datagramSocket.send(outdatagramPacket);//�����ݷ��͸������

        byte []in = new byte[1024]; //����һ��������ʱ��ŷ���˷�����������
        DatagramPacket inDatagramPacket = new DatagramPacket(in,0,in.length);//�����ݱ����շ���˷�����������

        datagramSocket.receive(inDatagramPacket);//��������

        System.out.println(new String(inDatagramPacket.getData(),0,inDatagramPacket.getLength()));//����ͻ��˷�����������

        datagramSocket.close();//�رտͻ���
    }

}
