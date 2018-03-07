package atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {
    private static AtomicIntegerArray array = new AtomicIntegerArray(10);
    public static class ArrayThread implements Runnable{
        @Override
        public void run() {
            for(int i=0;i<10000;i++){
                array.getAndIncrement(i%array.length());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Thread[] threads = new Thread[10];
        for (int i=0;i<10;i++){
            threads[i] = new Thread(new ArrayThread());
        }
        for (int i=0;i<10;i++){
            threads[i].start();
        }
        // 去掉线程非安全，不能得到想要得结果
        for (int i=0;i<10;i++){
            threads[i].join();
        }
        System.out.println(array);
    }

}
