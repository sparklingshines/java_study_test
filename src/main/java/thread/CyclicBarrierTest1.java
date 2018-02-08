package thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier，让一组线程到达一个同步点后再一起继续运行，在其中任意一个线程未达到同步点，其他到达的线程均会被阻塞。
 */
public class CyclicBarrierTest1 {

    private static int LATCH_SIZE = 5;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("main await begin.");

        Thread thread1 = new Thread(new InnerThread(),"innerThread1");
        Thread thread2 = new Thread(new InnerThread(),"innerThread2");
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(LATCH_SIZE,thread1);
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(LATCH_SIZE,thread2);

        // 新建5个任务
        for (int i = 0; i < LATCH_SIZE; i++){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+ ": waiting");
                    cyclicBarrier1.await();
                    cyclicBarrier2.await();
                    System.out.println(Thread.currentThread().getName()+ ": working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "thread - " + i).start();
        }

        System.out.println("main await finished.");
    }

    static class InnerThread implements Runnable {
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
