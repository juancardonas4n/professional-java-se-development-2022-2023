public class MainPC {

    public static void main(String[] args) {
        // IMesa mesa = new Mesa(3);
        IMesa mesa = new MesaLock(3);
        Runnable prod = () -> {
            int value = 100;
            while (true) {
                mesa.poner(value);
                value += 5;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ie) { }
            }
        };

        Runnable cons = () -> {
            while (true) {
                int value = mesa.obtener();
                System.out.println(value);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ie) { }
            }
        };

        Thread t1 = new Thread(prod, "Prod");
        Thread t2 = new Thread(cons, "Cons");
        t1.start(); t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ie) { }
    }
}
