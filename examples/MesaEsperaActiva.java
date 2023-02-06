import java.util.Optional;

public class MesaEsperaActiva {

    private int elementos[];
    private int nElementos;
    private int poner;
    private int sacar;

    public MesaEsperaActiva(int capacidad) {
        this.elementos = new int[capacidad];
        this.poner = this.sacar = this.nElementos = 0;
    }

    public synchronized boolean poner(int valor) {

        while (nElementos == elementos.length) {
            return false;
        }
        elementos[poner] = valor;
        nElementos++;
        poner = (poner + 1) % elementos.length;
        notify();
        return true;
    }

    public synchronized Optional<Integer> obtener() {
        int valRet = 0;
        while (nElementos == 0) {
            return Optional.empty();
        }
        valRet = elementos[sacar];
        nElementos--;
        sacar = (sacar + 1) % elementos.length;
        notify();
        return Optional.of(valRet);
    }
}
