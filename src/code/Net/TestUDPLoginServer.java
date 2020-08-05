package code.Net;

import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestUDPLoginServer {
    public static void main(String [] argss) throws Exception{
        DatagramSocket datagramSocket = new DatagramSocket(4444);//����һ���������˿�

        byte []input = new byte[1024];//����һ����ʱ�������ݵ�����

        DatagramPacket indatagramPacket  = new DatagramPacket(input,0,input.length);//����һ�����ݱ���������յ�������

        datagramSocket.receive(indatagramPacket);
        System.out.println("�ѽ���");

        String text = new String(indatagramPacket.getData(),0,indatagramPacket.getLength());//�����ݸ����ַ���

        TestFileOutputStream("src\\TestFile\\File09",text);//����TestFileOutputStream()���������յ�������д�뵽��Ҫд���ĵط�

        byte []out = "������58max".getBytes();//����һ����������ʱ���潫Ҫ���͵�����
        DatagramPacket outdatagramPacket = new DatagramPacket(out,0,out.length,indatagramPacket.getAddress(),indatagramPacket.getPort());//����һ�����ݱ������潫Ҫ���͵�����

        datagramSocket.send(outdatagramPacket);//��������
        System.out.println("�ѷ���");

        datagramSocket.close();//�رշ����

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
