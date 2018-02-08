package thread;

import java.util.concurrent.CountDownLatch;

/**
 * 在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
 */
public class CountDownLatchTest {

    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {
        System.out.println("main await begin.");

        try {
            doneSignal = new CountDownLatch(LATCH_SIZE);

            // 新建5个任务
            for (int i = 0; i < LATCH_SIZE; i++)
                new InnerThread().start();

            // "主线程"等待线程池中5个任务的完成
            doneSignal.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main await finished.");
    }

    static class InnerThread extends Thread {
        public void run() {
            try {
                System.out.println("count:"+doneSignal.getCount());
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1000ms.");
                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
