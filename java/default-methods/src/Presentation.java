public interface Presentation extends Information {
    void displayText(String str);
    default void displayNumber(int num){
        System.out.println(num);
    }
}
