package code.FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
                                        //�ֽ���
public class TestFileStream {
    public static void main(String [] args){
        TestFileStream.TestFileInputStream();

        TestFileStream.TestFileOutputStream();

        TestFileStream.copyFile("src\\TestFile\\File00","src\\TestFile\\File01");
    }
    public static void TestFileInputStream(){
        try {
            FileInputStream fileInputStream = new FileInputStream("src\\TestFile\\File00");

            byte [] b = new byte[2];
            int len = 0;
            System.out.println(fileInputStream.read(b));
            System.out.println(fileInputStream.read(b));
            while((len = fileInputStream.read(b))!= -1){
                System.out.println(new String(b,0,len));
                System.out.println(len);
            }
            System.out.println(len);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void TestFileOutputStream(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("src\\TestFile\\File00");//������ļ������ڽ��ᴴ��һ�����ļ�

            String str = "DEFG4321";
            //������ļ�����ע������ݽ��Ḳ��֮ǰ������
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void copyFile(String inPath, String outPath){
        try {
            FileInputStream fileInputStream = new FileInputStream(inPath);

            FileOutputStream fileOutputStream = new FileOutputStream(outPath);

            byte []b = new byte[100];
            int len = 0;

            while((len = fileInputStream.read(b))!= -1){
                fileOutputStream.write(b,0, len);
            }
            fileOutputStream.flush();

            fileOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
