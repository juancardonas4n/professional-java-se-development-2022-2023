import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class Mesa implements IMesa {

    private int elementos[];
    private int nElementos;
    private int poner;
    private int sacar;
    private Lock lock;
    private Condition lleno;
    private Condition vacio;

    public Mesa(int capacidad) {
        this.elementos = new int[capacidad];
        this.poner = this.sacar = this.nElementos = 0;
    }

    public synchronized void poner(int valor) {

        while (nElementos == elementos.length) {
            try {
                wait();
            } catch (InterruptedException ie) { }
        }
        elementos[poner] = valor;
        nElementos++;
        poner = (poner + 1) % elementos.length;
        notify();
    }

    public synchronized int obtener() {
        int valRet = 0;
        while (nElementos == 0) {
            try {
                wait();
            } catch (InterruptedException ie) { }
        }
        valRet = elementos[sacar];
        nElementos--;
        sacar = (sacar + 1) % elementos.length;
        notify();
        return valRet;
    }
}
