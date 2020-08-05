package code.Invok;

import java.io.*;

public class TestObjectStream {
    public static void main(String [] args ){

        try {
            TestObjectStream.TestObjectOutputStream("src\\TestFile\\File07");
            TestObjectStream.TestObjectInputStream("src\\TestFile\\File07");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void TestObjectInputStream(String inPath) throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(inPath));

        Object object = objectInputStream.readObject();

        Bape bape =(Bape) object;
        System.out.println(bape.name);
        System.out.println(bape.price);

        objectInputStream.close();
    }

    public static void TestObjectOutputStream(String outPath) throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outPath));

        Bape bape = new Bape("killerwhales",3499.3);
        objectOutputStream.writeObject(bape);

        objectOutputStream.close();
    }
}
class Bape{
    String name;
    double price;
    public Bape(String name,double price){
        this.name = name;
        this.price = price;
    }
}
