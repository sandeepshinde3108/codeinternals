import java.util.function.Function;

public class FunctionImpl implements Function<Integer, String> {
    @Override
    public String apply(Integer integer) {
        return integer % 2 == 0 ? "Even" : "Odd";
    }
}
