package code.Thread;


public class TestProCust {
    public static void main(String [] args){
        Clerk c  = new Clerk();

               //������
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (c){
                    while(true) {
                        if (c.productNumber == 0) {
                            System.out.println("����ѿգ���ʼ����");
                            while(c.productNumber < 4){
                                c.productNumber++;
                                System.out.println("��棺 "+c.productNumber);
                            }
                            System.out.println("�����������������");
                            c.notify();//�����������߳�
                        }else{
                            try {
                                c.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"������").start();
          //������
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (c){
                    while(true) {
                        if (c.productNumber == 4) {
                            System.out.println("�����������ʼ����");
                            while(c.productNumber > 0){
                                c.productNumber--;
                                System.out.println("��棺 "+c.productNumber);
                            }
                            System.out.println("����ѿգ���������");
                            c.notify();//�����������߳�
                        }else{
                            try {
                                c.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        },"������").start();
    }
}

class Clerk{
    public static int productNumber;
}
