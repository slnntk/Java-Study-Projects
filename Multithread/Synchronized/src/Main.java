public class Main {

    private static int i = -1;

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
        static Object Lock1 = new Object();
        static Object Lock2 = new Object();

        @Override
        public void run() {  // Implementamos o synchronized dentro de um bloco de código, para que ele seja sincronizado.
            synchronized (Lock2){ // só podemos executar um método sincronizado por vez (tiramos o paralelismo )
                i++; // como cada thread vai esperar o método anterior terminar, tiramos a concorrencia.
                Thread thread = Thread.currentThread();
                System.out.println("Thread name: " + thread.getName() + " i: " + i);
            }
            synchronized (Lock2){ // só podemos executar um método sincronizado por vez (tiramos o paralelismo )
                i++; // como cada thread vai esperar o método anterior terminar, tiramos a concorrencia.
                Thread thread = Thread.currentThread();
                System.out.println("Thread name: " + thread.getName() + " i: " + i);
            }
        }
    }
}