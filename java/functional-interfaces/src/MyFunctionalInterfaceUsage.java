public class MyFunctionalInterfaceUsage {
    public static void main(String[] args) {
        //class implementation
        MyFunctionalInterface myfunc = new MyFunctionalInterfaceImpl();
        System.out.println(myfunc.calculate(1,2));

        //anonymous class
        MyFunctionalInterface anonymousFunc = new MyFunctionalInterface() {
            @Override
            public int calculate(int num1, int num2) {
                return num1-num2;
            }
        };
        System.out.println(anonymousFunc.calculate(10, 5));

        //lambda expression
        MyFunctionalInterface lambdaMyFunc = (num1, num2) -> num1 * num2;
        System.out.println(lambdaMyFunc.calculate(2,3));
    }
}
