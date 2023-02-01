import java.util.stream.Collector;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.Set;
import java.util.HashSet;

import static java.util.stream.Collectors.joining;

public class CollectorExample implements Collector<Integer, List<Integer>, String> {

    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    public BiConsumer<List<Integer>,Integer> accumulator() {
        return (list, elem) -> list.add(elem);
    }

    public BinaryOperator<List<Integer>> combiner() {
        return (leftList, rightList) -> {
            leftList.addAll(rightList);
            return leftList;
        };
    }

    // List<CourseResult, String>
    public Function<List<Integer>,String> finisher() {
        return (list) -> list
            .stream()
            .map(i -> i.toString())
            .collect(joining(", ", "[", "]"));
    }

    public Set<Collector.Characteristics> characteristics() {
        return new HashSet<>();
    }
}
