import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        int attempts = 0;
        boolean hasWon = false;

        System.out.println("Добро пожаловать в игру 'Угадай число'!");
        System.out.println("Я загадал число от 1 до 100.");

        Scanner scanner = new Scanner(System.in);

        while (attempts < 10) {
            System.out.print("Введите число: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                hasWon = true;
                break;
            } else if (guess < numberToGuess) {
                System.out.println("Загаданное число больше.");
            } else {
                System.out.println("Загаданное число меньше.");
            }
        }

        if (hasWon) {
            System.out.println("Поздравляю! Вы угадали число за " + attempts + " попыток.");
        } else {
            System.out.println("Вы проиграли. Загаданное число было: " + numberToGuess);
        }
    }
}