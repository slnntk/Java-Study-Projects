public class Threads_1 {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();
        System.out.println(t.getName());

        MyRunnable myRunnable = new MyRunnable();

        Thread newThread = createThread(myRunnable);
        Thread newThread2 = createThread(
                () -> System.out.println(Thread.currentThread().getName() + " is running"));
        Thread newThread3 = createThread(myRunnable);

        newThread.start();
        newThread2.start();
        newThread3.start();

    }

    public static Thread createThread(Runnable runnable) {
        return new Thread(runnable);
    }
}

/** newThread.start(); Instruindo minha JVM para que ele chame o
                    método run() da minha classe MyRunnable
                    assim que possivel (Executando uma nova thread).

 newThread.run();   Apenas executando na mesma thread.
 **/