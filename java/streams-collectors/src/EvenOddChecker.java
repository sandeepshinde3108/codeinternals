import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class EvenOddChecker implements Collector<Integer, List<Integer>, Boolean> {

    @Override
    public Supplier<List<Integer>> supplier() {
        //creating accumulating container
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        //adding new element to the container
        return Collection::add;
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        //combining 2 result containers
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<Integer>, Boolean> finisher() {
        //final transformation and return the result
        return list -> {
            int sum = list.stream().mapToInt(Integer::intValue).sum();
            return sum % 2 == 0 ? true : false;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<Characteristics>(){
            {
                add(Characteristics.UNORDERED);
            }
        };
    }
}
