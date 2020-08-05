package code.FileIO;

import java.io.*;         //字符流

public class TestFileReadWrite {
    public static void main(String [] args){

        TestFileReadWrite.TestFileReader("src\\TestFile\\File00");
        TestFileReadWrite.TestFileWriter("1234AVC","src\\TestFile\\File01");
        TestFileReadWrite.copyFile("src\\TestFile\\File01","src\\TestFile\\File02");
    }
    public static void TestFileReader(String inPath){
        try {
            FileReader fileReader = new FileReader(inPath);

            char [] b = new char[100];
            int len = 0;
            while((len = fileReader.read(b))!= -1){
                System.out.println(new String(b,0,len));
                System.out.println(len);
            }

            System.out.println(len);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void TestFileWriter(String text, String outPath){
        try {
            FileWriter fileWriter = new FileWriter(outPath);//如果该文件不存在将会创建一个文件
                                                      //如果该文件存在注入的数据将会覆盖之前的数

            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void copyFile(String inPath, String outPath){
        try {
            FileReader fileReader = new FileReader(inPath);

            FileWriter fileWriter = new FileWriter(outPath);

            char []b = new char[100];
            int len = 0;

            while((len = fileReader.read(b))!= -1){
                fileWriter.write(b,0, len);
            }
            fileWriter.flush();

            fileWriter.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
