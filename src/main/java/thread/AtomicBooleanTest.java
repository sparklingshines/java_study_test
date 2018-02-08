package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;


class AtomicBooleanRunnable1 implements Runnable {
    private static AtomicBoolean exist = new AtomicBoolean(false);

    private String name;

    public AtomicBooleanRunnable1(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (exist.compareAndSet(false, true)) {

            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exist.set(false);
        } else {
            System.out.println(name + " give up");
        }
    }
}

class AtomicBooleanRunnable2 implements Runnable {
    private static boolean exist = false;

    private String name;

    public AtomicBooleanRunnable2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        if (!exist) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                // do nothing
            }
            exist = true;
            System.out.println(name + " enter");
            try {
                System.out.println(name + " working");
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                // do nothing
            }
            System.out.println(name + " leave");
            exist = false;
        } else {
            System.out.println(name + " give up");
        }
    }
}

class AtomicBooleanRunnable3 implements Runnable {
    private static boolean exist = false;

    private String name;

    public AtomicBooleanRunnable3(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (AtomicBooleanTest.class) {
            if (!exist) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e1) {
                    // do nothing
                }
                exist = true;
                System.out.println(name + " enter");
                try {
                    System.out.println(name + " working");
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    // do nothing
                }
                System.out.println(name + " leave");
                exist = false;
            } else {
                System.out.println(name + " give up");
            }
        }
    }
}

public class AtomicBooleanTest {

    public static void main(String[] args) {

        // 会出现线程安全的问题
        AtomicBooleanRunnable2 bar1 = new AtomicBooleanRunnable2("bar1");
        AtomicBooleanRunnable2 bar2 = new AtomicBooleanRunnable2("bar2");
        new Thread(bar1).start();
        new Thread(bar2).start();

        AtomicBooleanRunnable3 bar5 = new AtomicBooleanRunnable3("bar5");
        AtomicBooleanRunnable3 bar6 = new AtomicBooleanRunnable3("bar6");
        new Thread(bar5).start();
        new Thread(bar6).start();

        AtomicBooleanRunnable1 bar3 = new AtomicBooleanRunnable1("bar3");
        AtomicBooleanRunnable1 bar4 = new AtomicBooleanRunnable1("bar4");
        new Thread(bar3).start();
        new Thread(bar4).start();
    }

}
