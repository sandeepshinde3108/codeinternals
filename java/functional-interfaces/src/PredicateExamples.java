import java.util.function.Predicate;

public class PredicateExamples {
    public static void main(String[] args) {
        //class implementation
        Predicate<Integer> evenNum = new PredicateImpl();
        System.out.println(evenNum.test(20));

        //anonymous class
        Predicate<Integer> anonEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return (integer % 2) == 0;
            }
        };
        System.out.println(anonEven.test(20));

        //lambda expression
        Predicate<Integer> lambdaEven = num -> (num % 2) == 0;
        System.out.println(lambdaEven.test(20));

        //passing lambda expression (function) as argument to the function
        checkNumberIsOdd(13, num -> (num % 2) != 0);
    }

    private static void checkNumberIsOdd(int num, Predicate<Integer> predicate){
        if(predicate.test(num))
            System.out.println("Number is odd");
        else
            System.out.println("Number is even");
    }
}
