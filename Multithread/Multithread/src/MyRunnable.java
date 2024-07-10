public class MyRunnable implements Runnable{
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " is running");
    }
}
