package code.FileIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
                                        //字节流
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
            FileOutputStream fileOutputStream = new FileOutputStream("src\\TestFile\\File00");//如果该文件不存在将会创建一个新文件

            String str = "DEFG4321";
            //如果该文件存在注入的数据将会覆盖之前的数据
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
