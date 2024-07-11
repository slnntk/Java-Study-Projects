import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedCollections {

    private static List<String> list = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {

        MyRunnable myRunnable = new MyRunnable();
        Thread t0 = new Thread(myRunnable);
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(list);

    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            list.add("Hello");
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " added an element to the list");
        }
    }
}

