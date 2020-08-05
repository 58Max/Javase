package code.FileIO;

import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    public static void main(String [] args){

        try {
            TestRandomAccessFile.TestRandomAcess("src\\TestFile\\File08");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void TestRandomAcess(String path) throws Exception{

        RandomAccessFile randomAccessFile = new RandomAccessFile(path,"rw");

        byte []b =new byte[1024];
        int len = 0;
        while((len = randomAccessFile.read(b)) != -1){
            System.out.println(new String(b,0,len));
        }

        randomAccessFile.seek(randomAccessFile.length());
        randomAccessFile.writeChars("’‚¿Ô «58max");


        randomAccessFile.close();
    }
}
