package queue;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Producer implements Runnable {
    private final BlockingQueue queue;

    Producer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                System.out.println(Thread.currentThread().getName() + ":produce");
                queue.put(Math.random());
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}

class Consumer implements Runnable {
    private final BlockingQueue queue;

    Consumer(BlockingQueue q) {
        queue = q;
    }

    public void run() {
        try {
            while (true) {
                Thread.sleep(2000);
                Object x = queue.take();
                System.out.println(Thread.currentThread().getName() + ":consume");
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

}

public class BlockingQueueExample {

    public static void main(String[] args) throws Exception {

        BlockingQueue queue = new ArrayBlockingQueue(4);

        Producer p1 = new Producer(queue);
        Producer p2 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);
        new Thread(p1,"produce-1").start();
        new Thread(p2,"produce-2").start();
        new Thread(c1,"consume-1").start();
        new Thread(c2,"consume-2").start();
        Thread.sleep(4000);
    }

}
