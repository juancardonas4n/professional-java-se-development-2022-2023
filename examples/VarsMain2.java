import java.util.Arrays;

public class VarsMain2 {
    public static void function(String msg, int ... a) {
        System.out.printf("%s %d\n", msg, 
                          Arrays.stream(a).sum());
    }

    public static void main(String[] args) {

        Arrays.stream(args).forEach(arg -> VarsMain2.function(arg, 1, 2, 3));
    }
}
