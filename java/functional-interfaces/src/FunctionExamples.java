import java.util.function.Function;

public class FunctionExamples {
    public static void main(String[] args) {
        //class implementation
        Function<Integer, String> function = new FunctionImpl();
        System.out.println(function.apply(2));

        //anonymous class
        Function<Integer, Boolean> anonymousFunction = new Function<Integer, Boolean>() {
            @Override
            public Boolean apply(Integer integer) {
                return integer % 2 == 0 ? true : false;
            }
        };
        System.out.println(anonymousFunction.apply(3));

        //lambda expressions
        Function<Integer, Integer> lambdaFunction = (num) -> num / 2;
        System.out.println(lambdaFunction.apply(10));
    }
}
