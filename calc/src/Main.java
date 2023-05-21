import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        System.out.println(Calc(sc.nextLine()));
    }
    public static String Calc (String input) {
        int a = 0;
        int b = 0;
        String op;
        String rs;
        String[] legsymb = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "+", "-", "/", "*", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] strings = input.split("[+-/*]");
        String[] operator = input.split("\\w");
        if (!(Arrays.asList(legsymb).contains(strings[0]) & Arrays.asList(legsymb).contains(strings[1]))) {
            throw new RuntimeException("Выражение содержит не разрешенные символы");
        } else if (strings.length < 3) {
            op = operator[operator.length - 1];

            try {
                a = Integer.parseInt(strings[0]);
                b = Integer.parseInt(strings[1]);
            } catch (Exception e)  {
                int r1 = RomeNumb.valueOf(strings[0]).getAnumb();
                int r2 = RomeNumb.valueOf(strings[1]).getAnumb();
                int res = operation(r1, r2, op);

                if (res < 0) {
                    throw new RuntimeException("В римских нет отрицательных чисел");
                }

                rs = String.valueOf((((RomeNumb.getByValue(res)))));
                return rs;
            }

            if (a < 11 & a >= 0 & b < 11 & b >= 0) {
                rs = String.valueOf(operation(a, b, op));
            } else {
                throw new RuntimeException("Не разрешенные числа");
            }
        } else {
            throw new RuntimeException("Более 1 знака операции");
        }
        return rs;
    }

    public static int operation(int a, int b, String op) {
        return switch (op) {
            case "*" -> a * b;
            case "+" -> a + b;
            case "-" -> a - b;
            case "/" -> a / b;
            default -> throw new IllegalArgumentException("Не верный знак операции");
        };
    }
}