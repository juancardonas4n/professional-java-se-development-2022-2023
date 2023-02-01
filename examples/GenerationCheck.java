import java.util.function.Function;
import java.util.List;
import java.util.Arrays;

public class GenerationCheck {

    private static class Pair<A,B> {
        A left;
        B right;
        Pair(A left, B right) {
            this.left = left;
            this.right = right;
        }
    }

    public static String generationCheck(int year) {
        List<Pair<Function<Integer, Boolean>,String>> list =
            Arrays.asList(new Pair<>(y -> y > 2010, "No generation problems yet!"),
                          new Pair<>(y -> y > 1994 && y <= 2010, "Generation Z"),
                          new Pair<>(y -> true, "Boomer"));
       return list
           .stream()
           .filter(p -> p.left.apply(year))
           .map(p -> p.right)
           .findFirst()
           .orElse("God knows");
    }

    public static void main(String[] args) {
        System.out.println(generationCheck(2011));
        System.out.println(generationCheck(1996));
        System.out.println(generationCheck(1968));
    }

}
