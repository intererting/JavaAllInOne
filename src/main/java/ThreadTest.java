import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
    public static void main(String[] args) {
        AccountingSync instance = new AccountingSync();
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        Thread t3 = new Thread(instance);
        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(instance.getI());
    }
}

class AccountingSync implements Runnable {
    //共享资源(临界资源)
    private AtomicInteger i = new AtomicInteger();

    /**
     * synchronized 修饰实例方法
     */
    private void increase() {
        i.incrementAndGet();
    }

    public int getI() {
        return i.get();
    }

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            increase();
        }
    }
}