import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLock {
    // 1. Atributos privado
    private int value;
    private Lock lock;
    // 2. Constructor no debe exponer el estado interno
    public Counter(int value) {
        this.value = value;
        this.lock = new ReentrantLock();
    }

    // Todos los métodos deben ser sincronizados (sychronized.)2
    public void incr() {
        lock.lock();
        try {
            value++;
        }
        finally {
            lock.unlock();
        }
    }
    public synchronized void decr() {
        lock.lock();
        try {
            value--;
        }
        finally {
            lock.unlock();
        }
    }

    public int getValue() {
        int retValue = 0;
        lock.lock();
        try {
            retValue = value;
        }
        finally {
            lock.unlock();
        }
        return retValue;
    }
}
