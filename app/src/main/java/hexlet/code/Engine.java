package hexlet.code;

import java.util.Objects;
import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final int OPERATORS_COUNT = 3;


    public static void wrongAnswer(String userAnswer, String correctAnswer, String username) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + username + "!");
    }

    public static void congratulations(String username) {
        System.out.println("Congratulations, " + username + "!");
    }

    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static String getUsername() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        var username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        return username;
    }

    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static int getRand(int range) {
        return (int) (Math.random() * range);
    }

    public static int getRand() {
        return getRand(100);
    }

    public static boolean isNumeric(String string) {
        return string != null && string.matches("-?[0-9.]+");
    }

    public static void correctAnswer(int index, String username) {
            System.out.println("Correct!");
            if (index == Engine.ROUNDS) {
                Engine.congratulations(username);
            }
    }
}
