package code.FileIO;

import java.io.*;         //»º³åÁ÷

public class TestFileBuffered {

    public static void main(String [] args){

        TestFileBuffered.fileBufferedInputStream("src\\TestFile\\File02");

        TestFileBuffered.fileBufferedOutputStream("1112312321313131","src\\TestFile\\File03");

        TestFileBuffered.copyBufferedFile("src\\TestFile\\File03","src\\TestFile\\File04");
    }

    public static void fileBufferedInputStream(String inPath){
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inPath));

            byte [] b = new byte[100];
            int len = 0;

            while((len = bufferedInputStream.read(b)) != -1){
                System.out.println(new String(b, 0, len));
            }

            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void fileBufferedOutputStream(String text, String outPath){

        try {

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(outPath));

            bufferedOutputStream.write(text.getBytes());
            bufferedOutputStream.flush();

            bufferedOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copyBufferedFile(String inPath, String outPath){

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(inPath));
            BufferedOutputStream bufferedOutputStream =new BufferedOutputStream(new FileOutputStream(outPath));

            byte [] b = new byte[1024];
            int len = 0;

            while ((len = bufferedInputStream.read(b)) != -1){

                bufferedOutputStream.write(b, 0, len);
            }
            bufferedOutputStream.flush();

            bufferedOutputStream.close();
            bufferedInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
