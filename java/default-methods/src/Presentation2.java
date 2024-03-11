public interface Presentation2 extends Information {
    void displayDouble(double num);

    default void displayNumber(int num){
        System.out.println(num*2);
    }
}
