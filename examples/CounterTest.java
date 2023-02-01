import java.util.List;
import java.util.ArrayList;
public class CounterTest extends Thread {

    private Counter counter;
    private Counter counter2;
    private Runnable run;
    
    public CounterTest(Counter counter, Counter counter2, Runnable run) {
        this.counter = counter;
        this.counter2 = counter2;
        this.run = run;
    }

    // Wrapper
    public void run() {
        Throwable cause = null;
        try {
            // 
            this.run.run();
        } catch (Throwable tr) {
            cause = tr;
        }
        // list.add(new Result(Thread.currentThread())));
        counter2.incr();
        System.out.println(counter2.getValue());
        if (cause != null) System.out.println(""+cause);
    }
    
    public static void main(String[] args) {

        Counter c = new Counter(0);
        Counter c2 = new Counter(0);
        Thread t1 = new CounterTest(c, c2, () -> { System.out.println("Hilo 1");
                throw new RuntimeException();
        });
        Thread t2 = new CounterTest(c, c2, () -> System.out.println("Hilo 2"));

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException ie) {
        }
    }
}
