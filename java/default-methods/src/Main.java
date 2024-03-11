public class Main implements Presentation, Presentation2 {

    public static void main(String[] args) {
        Main instance1 = new Main();
        instance1.displayText("Hello");
        instance1.displayNumber(10);
        instance1.displayDouble(11.23);
        instance1.displayBoolean(true);
    }

    @Override
    public void displayText(String str) {
        System.out.println(str);
    }

    @Override
    public void displayDouble(double num) {
        System.out.println(num);
    }

    @Override
    public void displayNumber(int num) {
        Presentation2.super.displayNumber(num);
    }
}
