public class CalculatorDemo {
    public static void main(String[] args) {
        int num1 = 30, num2 = 20;

        System.out.println("PI = " + Calculator.PI);
        System.out.println(num1 + " + " + num2 + " = " + Calculator.add(num1, num2));
        System.out.println(num1 + " - " + num2 + " = " + Calculator.sub(num1, num2));
        System.out.println(num1 + " * " + num2 + " = " + Calculator.mul(num1, num2));
        System.out.println(num1 + " / " + num2 + " = " + Calculator.div(num1, num2));
    }
}