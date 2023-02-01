import java.util.List;
import java.util.Arrays;

public class CollectorMain {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        String str = list
            .stream()
            .map(i -> i * 2)
            .collect(new CollectorExample());

        System.out.println(str);
    }
}
