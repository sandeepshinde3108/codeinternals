import java.util.function.Supplier;

public class SupplierExamples {
    public static void main(String[] args) {
        //class implementation
        Supplier<String> supplier = new SupplierImpl();
        System.out.println(supplier.get());

        //anonymous class
        Supplier<String> anonymousSupplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Anonymous Supplier returned";
            }
        };
        System.out.println(anonymousSupplier.get());

        //lambda expression
        Supplier<String> lambdaSupplier = () -> "Lambda Supplier returned";
        System.out.println(lambdaSupplier.get());
    }
}
