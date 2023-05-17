
import java.util.Arrays;
import java.lang.Enum;
import java.util.Scanner;
public class Main {
    public static void main () {
        System.out.println("Введите выражение");
        Scanner sc = new Scanner(System.in);
        System.out.println(calc(sc.nextLine()));

    }
    public static String calc (String input) {
        int a = 0;
        int b = 0;
        String op = "";
        String rs = "";
        String[] legsymb = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "+", "-", "/", "*", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] strings = input.split("[+-/*]");
        String[] operator = input.split("\\w");
        if ((Arrays.asList(legsymb).contains(strings[0])) & (Arrays.asList(legsymb).contains(strings[1]))) {
            if (strings.length < 3) {
                op = operator[operator.length - 1];
                try {
                    a = Integer.parseInt(strings[0]);
                    b = Integer.parseInt(strings[1]);
                } catch (Exception e) {
                    int r1 = (RomeNumb.valueOf(strings[0]).getAnumb());
                    int r2 = (RomeNumb.valueOf(strings[1]).getAnumb());
                    int res = (operation(r1, r2, op));
                    if (res < 0) {
                        throw new RuntimeException("В римских нет отрицательных чисел");
                    } else {
                        rs=(RomeNumb.getByValue(res));
                    }
                }
                if ((a < 11) & (a >= 0) & (b < 11) & (b >= 0)) {
                    rs=(operation(a, b, op));
                } else {
                    throw new RuntimeException("Не разрешенные числа");

                }
            } else {
                throw new RuntimeException("Более 1 знака операции");
            }
        } else {
            throw new RuntimeException("Выражение содержит не разрешенные символы");
        }
        return rs;
    }
    public static int operation(int a, int b, String op) {
        switch (op) {
            case "*":
                return a * b;
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "/":
                return a / b;
            default:
                throw  new IllegalArgumentException("Не верный знак операции");
        }

    }






    }




