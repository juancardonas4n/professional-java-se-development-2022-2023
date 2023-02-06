public class Counter {
    // 1. Atributos privado
    private int value;

    // 2. Constructor no debe exponer el estado interno
    public Counter(int value) {
        this.value = value;
    }

    // public synchronized void incr() {
    //     value++;
    // }

    // Todos los métodos deben ser sincronizados (sychronized).
    public void incr() {
        synchronized(this) {
            value++;
        }
        // ...
        
    }
    public synchronized void decr() {
        value--;
    }

    public synchronized int getValue() {
        return value;
    }
}
