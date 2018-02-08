package thread;

import java.util.concurrent.atomic.AtomicInteger;

class SaleTicketThread implements Runnable{

    private Integer count;

    SaleTicketThread(Integer count){
        this.count = count;
    }

    @Override
    public void run() {
        System.out.println(count--);
    }
}

public class AtomicIntegerTest {
    private static int count = 5;

    private static AtomicInteger acount = new AtomicInteger(5);

    public static void main(String[] args) {

        for (int i = 0; i < 6;i++){
            new Thread(()->{
                while(acount.get() > 0){
                    System.out.println(acount.getAndDecrement());
                }
            },"Thread-" + i).start();
        }

        /*for (int i = 0; i < 6;i++){
            new Thread(()->{
                while(count > 0){
                    System.out.println(count--);
                }
            },"Thread-" + i).start();
        }*/
    }



}
