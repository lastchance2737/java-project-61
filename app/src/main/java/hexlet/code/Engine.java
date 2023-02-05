package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    private static final String CALC_RULE = "What is the result of the expression?";
    private static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String GCD_RULE = "Find the greatest common divisor of given numbers.";
    private static final String PROGRESSION_RULE = "What number is missing in the progression?";
    private static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final String WELCOME = "Welcome to the Brain Games!";
    private static final int RAND_STANDARD = 50;
    private static final int RAND_FROM = 1;
    public static final int ROUNDS = 3;
    public static final int OPERATORS_COUNT = 3;
    public static final int PROGRESSION_STEP_FROM = 2;
    public static final int PROGRESSION_STEP_TO = 10;
    public static final int PROGRESSION_LENGTH_FROM = 5;
    public static final int PROGRESSION_LENGTH_TO = 10;
    public static final int[] PRIME_NUMBERS = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
    private static String playerName;
    private static int choice;
    public static final int START_INDEX = 0;
    private static final int START_GREET = 1;
    private static final int START_EVEN = 2;
    private static final int START_CALC = 3;
    private static final int START_GCD = 4;
    private static final int START_PROGRESSION = 5;
    private static final int START_PRIME = 6;
    private static final int START_EXIT = 0;

    public static void startGame() {
        Engine.welcome();
        Engine.setUsername();
        Engine.gameRule();
    }

    private static void welcome() {
        System.out.println(WELCOME);
    }

    private static void setUsername() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    private static void gameRule() {
        var ruleString = switch (choice) {
            case START_EVEN -> EVEN_RULE;
            case START_CALC -> CALC_RULE;
            case START_GCD -> GCD_RULE;
            case START_PROGRESSION -> PROGRESSION_RULE;
            case START_PRIME -> PRIME_RULE;
            default -> "";
        };
        System.out.println(ruleString);
    }

    public static void menu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(START_GREET + " - Greet");
        System.out.println(START_EVEN + " - Even");
        System.out.println(START_CALC + " - Calc");
        System.out.println(START_GCD + " - GCD");
        System.out.println(START_PROGRESSION + " - Progression");
        System.out.println(START_PRIME + " - Prime");
        System.out.println(START_EXIT + " - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        Engine.choice = scanner.nextInt();

        switch (Engine.choice) {
            case START_GREET -> Cli.greeting();
            case START_EVEN -> Even.game();
            case START_CALC -> Calc.game();
            case START_GCD -> Gcd.game();
            case START_PROGRESSION -> Progression.game();
            case START_PRIME -> Prime.game();
            default -> {
            }
        }
    }

    public static void wrongAnswer(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static void wrongAnswer(String userAnswer, int correctAnswer) {
        wrongAnswer(userAnswer, Integer.toString(correctAnswer));
    }

    public static void correctAnswer(int index) {
        System.out.println("Correct!");
        if (index == Engine.ROUNDS) {
            Engine.congratulations();
        }
    }

    private static void congratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        return scanner.nextLine();
    }

    public static int getRand(int from, int to) {
        return (int) (from + Math.random() * to);
    }

    public static int getRand(int range) {
        return getRand(RAND_FROM, range);
    }

    public static int getRand() {
        return getRand(RAND_FROM, RAND_STANDARD);
    }

    public static int lowCommonMultiple(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : lowCommonMultiple(b, a % b);
    }

    public static boolean isPrimeNumber(int number) {
        for (int primeNumber : PRIME_NUMBERS) {
            if (number == primeNumber) {
                return true;
            }
        }
        return false;
    }

}
