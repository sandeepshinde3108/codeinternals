import java.util.function.Consumer;

public class ConsumerExamples {
    public static void main(String[] args) {
        //class implementation
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Hello");

        //anonymous class
        Consumer<String> anonymousConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("Hello " + s);
            }
        };
        anonymousConsumer.accept("Sandeep");

        //lambda expression
        Consumer<String> lambdaConsumer = s -> System.out.println("Hi " + s);
        lambdaConsumer.accept("Sandeep");
    }
}
