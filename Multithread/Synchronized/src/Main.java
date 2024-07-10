public class Main {

    private static int i = 0;

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();


        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

    public static class MyRunnable implements Runnable{
        @Override
        public void run() {
            int j;
            synchronized (Main.class){
                i++;
                j = i * 2;
            }
            System.out.println(i + " " + j);
            double jE100 = Math.pow(j, 100);
            double sqrt = Math.sqrt(jE100);
            System.out.println(sqrt);
        }
    }
}
