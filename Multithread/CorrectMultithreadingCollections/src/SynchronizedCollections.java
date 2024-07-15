import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * SynchronizedCollections demonstra o uso de coleções thread-safe em Java.
 */
public class SynchronizedCollections {

    /**
     * CopyOnWriteArrayList é uma implementação de lista thread-safe, onde todas as operações de escrita são feitas em uma cópia da lista original.
     * <p>
     * Vantagens:
     * - Extremamente eficiente para cenários com muitas leituras e poucas escritas.
     * - As operações de leitura são rápidas e sem bloqueios.
     * <p>
     * Desvantagens:
     * - Operações de escrita são muito custosas em termos de desempenho.
     * - Não é adequada para cenários com muitas operações de escrita.
     */
    private static List<String> list = new CopyOnWriteArrayList<>();

    /**
     * ConcurrentHashMap é uma implementação thread-safe de um mapa, que sincroniza operações conforme necessário para garantir a consistência.
     * <p>
     * Vantagens:
     * - Altamente eficiente para operações concorrentes de leitura e escrita.
     * - Evita bloqueios totais, usando uma abordagem de bloqueio segmentado.
     * <p>
     * Desvantagens:
     * - Um pouco mais complexo do que HashMap devido ao gerenciamento de threads.
     * - Pode ser menos eficiente que um HashMap simples em cenários de uso single-threaded.
     */
    private static Map<Integer, String> map = new ConcurrentHashMap<>();

    /**
     * LinkedBlockingDeque é uma implementação thread-safe de uma fila de dois extremos, adequada para cenários onde múltiplas threads estão inserindo e removendo elementos simultaneamente.
     * <p>
     * Vantagens:
     * - Suporta inserções e remoções de ambos os extremos, oferecendo flexibilidade.
     * - Thread-safe, permitindo operações concorrentes sem problemas de consistência.
     * <p>
     * Desvantagens:
     * - Pode ter overhead de sincronização, afetando o desempenho em operações intensivas.
     * - Pode ser mais complexa de gerenciar do que uma fila simples.
     */
    private static BlockingDeque<String> queue = new LinkedBlockingDeque<>();

    public static void main(String[] args) throws InterruptedException {

        MyRunnable myRunnable = new MyRunnable();
        Thread t0 = new Thread(myRunnable);
        Thread t1 = new Thread(myRunnable);
        Thread t2 = new Thread(myRunnable);

        t0.start();
        t1.start();
        t2.start();

        Thread.sleep(500);

        System.out.println(queue);
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            queue.add("Hello");
            String name = Thread.currentThread().getName();
            System.out.println("Thread " + name + " added an element to the queue");
        }
    }
}
