package code.Thread;


public class TestProCust {
    public static void main(String [] args){
        Clerk c  = new Clerk();

               //生产者
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (c){
                    while(true) {
                        if (c.productNumber == 0) {
                            System.out.println("库存已空，开始生产");
                            while(c.productNumber < 4){
                                c.productNumber++;
                                System.out.println("库存： "+c.productNumber);
                            }
                            System.out.println("库存已满，结束生产");
                            c.notify();//唤醒消费者线程
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
        },"生产者").start();
          //消费者
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (c){
                    while(true) {
                        if (c.productNumber == 4) {
                            System.out.println("库存已满，开始消费");
                            while(c.productNumber > 0){
                                c.productNumber--;
                                System.out.println("库存： "+c.productNumber);
                            }
                            System.out.println("库存已空，结束消费");
                            c.notify();//唤醒生产者线程
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
        },"消费者").start();
    }
}

class Clerk{
    public static int productNumber;
}
