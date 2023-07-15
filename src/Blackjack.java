import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в игру BlackJack!");

        while (true) {
            List<String> deck = initializeDeck();
            List<String> playerHand = new ArrayList<>();
            List<String> dealerHand = new ArrayList<>();

            // Раздача карт игроку и дилеру
            for (int i = 0; i < 2; i++) {
                playerHand.add(drawCard(deck));
                dealerHand.add(drawCard(deck));
            }

            // Игрок играет
            boolean playerWon = playGame(playerHand, dealerHand, deck, scanner);

            // Дилер играет только если игрок не перебрался
            if (!playerWon) {
                playDealerTurn(playerHand, dealerHand, deck);
            }

            // Вывод результатов
            String playerResult = getHandValue(playerHand) <= 21 ? "Победа!" : "Перебор!";
            String dealerResult = getHandValue(dealerHand) <= 21 ? "Победа!" : "Перебор!";

            System.out.println("\nИгрок: " + playerResult);
            System.out.println("Карты игрока: " + playerHand);
            System.out.println("Очки игрока: " + getHandValue(playerHand));

            System.out.println("\nДилер: " + dealerResult);
            System.out.println("Карты дилера: " + dealerHand);
            System.out.println("Очки дилера: " + getHandValue(dealerHand));

            System.out.println("\nХотите сыграть еще раз? (y/n)");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("y")) {
                break;
            }
        }

        System.out.println("\nСпасибо за игру! До свидания!");
        scanner.close();
    }

    private static List<String> initializeDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"♠️", "♣️", "♥️", "♦️"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        return deck;
    }

    private static String drawCard(List<String> deck) {
        Random random = new Random();
        int index = random.nextInt(deck.size());
        return deck.remove(index);
    }

    private static int getHandValue(List<String> hand) {
        int value = 0;
        int aces = 0;

        for (String card : hand) {
            String rank = card.substring(0, card.length() - 1);

            if (rank.equals("A")) {
                value += 11;
                aces++;
            } else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
                value += 10;
            } else {
                value += Integer.parseInt(rank);
            }
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }

        return value;
    }

    private static boolean playGame(List<String> playerHand, List<String> dealerHand, List<String> deck, Scanner scanner) {
        while (true) {
            System.out.println("\nКарты игрока: " + playerHand);
            System.out.println("Очки игрока: " + getHandValue(playerHand));
            System.out.println("\nКарта дилера: " + dealerHand.get(1));

            System.out.println("\nХотите взять карту или стоп? (h/s)");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("h")) {
                playerHand.add(drawCard(deck));

                if (getHandValue(playerHand) > 21) {
                    return false;
                }
            } else if (choice.equals("s")) {
                break;
            }
        }

        return true;
    }

    private static void playDealerTurn(List<String> playerHand, List<String> dealerHand, List<String> deck) {
        while (getHandValue(dealerHand) < 17) {
            dealerHand.add(drawCard(deck));
        }
    }
}