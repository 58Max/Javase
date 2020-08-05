package code.FileIO;

import java.io.*;          //ת����

public class TestFileStreamTranslate {
    public static void main(String [] args){

        TestFileStreamTranslate.testInputStreamReader("src\\TestFile\\File04");
        TestFileStreamTranslate.testOutputStreamWriter("������58max","D:\\java\\Javaѧϰ\\src\\TestFile\\File05");
    }

    public static void testInputStreamReader(String inPath){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(inPath),"GBK");

            char c[] =new char[100];
            int len = 0;

            while((len = inputStreamReader.read(c)) != -1) {
                System.out.println(new String(c, 0, len));
            }

            inputStreamReader.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testOutputStreamWriter(String text, String outPath){

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(outPath),"GBK");

            outputStreamWriter.write(text);
            outputStreamWriter.flush();

            outputStreamWriter.close();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
