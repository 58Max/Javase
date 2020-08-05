package code.Net;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUDPLoginClient {
    public static void main(String [] args) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(3333);//����һ���˿�Ϊ 6666 �Ŀͻ���

        byte []out = "��ã�58max".getBytes();//����һ����ʱ�洢���ݵ�����
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length, InetAddress.getByName("127.0.0.1"),4444);//���͵����ݱ�

        datagramSocket.send(outdatagramPacket);//�������ݱ�
        System.out.println("�ѷ���");

        byte []in = new byte[1024];//����һ������������ʱ�洢����
        DatagramPacket indatagramPacket = new DatagramPacket(in,0,in.length);//����һ�����ݱ�������������

        datagramSocket.receive(indatagramPacket);//��������
        System.out.println("�ѽ���");

        String text = new String(indatagramPacket.getData(),0,indatagramPacket.getLength());

        TestFileOutputStream("src\\TestFile\\File10",text);//�����յ�������д��Ŀ���ļ�

        datagramSocket.close();//�رտͻ���
    }
    //������д���ļ�
    public static void TestFileOutputStream(String inpath,String text){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(inpath);//������ļ������ڽ��ᴴ��һ�����ļ�

            //������ļ�����ע������ݽ��Ḳ��֮ǰ������
            fileOutputStream.write(text.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
