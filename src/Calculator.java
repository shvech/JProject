import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение: ");
        String input = scanner.nextLine();

        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }

        int a = parseNumber(parts[0]);
        int b = parseNumber(parts[2]);

        int result;
        switch (parts[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Деление на ноль");
                }
                result = a / b;
                break;
            default:
                throw new IllegalArgumentException("Неверная операция");
        }

        System.out.println("Результат: " + result);
    }

    private static int parseNumber(String str) {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверное число");
        }
        if (number < 1 || number > 10) {
            throw new IllegalArgumentException("Число должно быть от 1 до 10");
        }
        return number;
    }
}
