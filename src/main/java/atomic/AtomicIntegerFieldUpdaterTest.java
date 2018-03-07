package atomic;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {

    public static class Candidate{
        int id;
        volatile int score;
    }

    // AtomicIntegerFieldUpdater只能修改可变范围内得变量，
    // 为了保证变量被正确得读取，需要将变量修饰为volatile，
    // 由于CAS操作会通过对象实例中得偏移量直接赋值，因此不支持static字段
    public final static AtomicIntegerFieldUpdater updater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");
    public static AtomicInteger allScore = new AtomicInteger(0);

    public static void main(String[] args) throws Exception {
        Candidate candidate = new Candidate();
        Thread[] threads = new Thread[10000];
        for (int i=0;i<10000;i++){
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    if(Math.random()>0.4){
                        updater.getAndIncrement(candidate);
                        allScore.getAndIncrement();
                    }
                }
            });
            threads[i].start();
        }

        for(int i=0;i<10000;i++){
            threads[i].join();
        }

        System.out.println(updater.get(candidate));
        System.out.println(allScore);

    }
}
