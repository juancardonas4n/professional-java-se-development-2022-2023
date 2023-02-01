import java.util.Arrays;

public class VarsMain {
    public static void function(String msg, int ... a) {
        System.out.printf("%s %d\n", msg, 
                          Arrays.stream(a).sum());
    }

    public static void main(String[] args) {

        VarsMain.function(args[0], 1, 2, 3);
        Arrays.stream(args).forEach(VarsMain::function);
    }
}
