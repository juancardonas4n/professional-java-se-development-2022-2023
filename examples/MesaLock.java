import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class MesaLock implements IMesa {

    private int elementos[];
    private int nElementos;
    private int poner;
    private int sacar;
    private Lock lock;
    private Condition lleno;
    private Condition vacio;

    public MesaLock(int capacidad) {
        this.elementos = new int[capacidad];
        this.poner = this.sacar = this.nElementos = 0;
        this.lock = new ReentrantLock();
        this.lleno = lock.newCondition();
        this.vacio = lock.newCondition();
    } 

    @Override
    public void poner(int valor) {

        lock.lock();
        try {

            while (nElementos == elementos.length) {
                try {
                    lleno.await();
                } catch (InterruptedException ie) { }
            }
            elementos[poner] = valor;
            nElementos++;
            poner = (poner + 1) % elementos.length;
            vacio.signal();
        }
        finally {
            lock.unlock();
        }
    }

    @Override
    public int obtener() {
        int valRet = 0;
        lock.lock();
        try {
            while (nElementos == 0) {
                try {
                    vacio.await();
                } catch (InterruptedException ie) { }
            }
            valRet = elementos[sacar];
            nElementos--;
            sacar = (sacar + 1) % elementos.length;
            lleno.signal();
        }
        finally {
            lock.unlock();
        }
        return valRet;
    }
}
