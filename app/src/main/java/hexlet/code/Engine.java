package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    private static final String CALC_RULE = "What is the result of the expression?";
    private static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String GCD_RULE = "Find the greatest common divisor of given numbers.";
    private static final String PROGRESSION_RULE = "What number is missing in the progression?";
    public static final int ROUNDS = 3;
    public static final int OPERATORS_COUNT = 3;
    public static final int PROGRESSION_STEP_FROM = 2;
    public static final int PROGRESSION_STEP_TO = 10;
    public static final int PROGRESSION_LENGTH_FROM = 5;
    public static final int PROGRESSION_LENGTH_TO = 10;
    private static String playerName;
    public static int choice;
    public static int index = 0;

    public static void startGame() {
        Engine.welcome();
        Engine.setUsername();
        Engine.gameRule();
    }

    private static void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    private static void setUsername() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    private static void gameRule() {
        var ruleString = "";
        switch (choice) {
            case 2 -> {
                ruleString = EVEN_RULE;
            }
            case 3 -> {
                ruleString = CALC_RULE;
            }
            case 4 -> {
                ruleString = GCD_RULE;
            }
            case 5 -> {
                ruleString = PROGRESSION_RULE;
            }
            default -> {
            }
        }
        System.out.println(ruleString);
    }

    public static void menu() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        Engine.choice = scanner.nextInt();

        switch (Engine.choice) {
            case 1 -> {
                Cli.greeting();
            }
            case 2 -> {
                Even.game();
            }
            case 3 -> {
                Calc.game();
            }
            case 4 -> {
                Gcd.game();
            }
            case 5 -> {
                Progression.game();
            }
            default -> {
            }
        }
    }

    public static void wrongAnswer(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static void wrongAnswer(int userAnswer, int correctAnswer) {
        wrongAnswer(Integer.toString(userAnswer), Integer.toString(correctAnswer));
    }

    public static void wrongAnswer(String userAnswer, int correctAnswer) {
        wrongAnswer(userAnswer, Integer.toString(correctAnswer));
    }

    public static void correctAnswer() {
        System.out.println("Correct!");
        if (Engine.index == Engine.ROUNDS) {
            Engine.congratulations();
        }
    }

    public static boolean isCorrectAnswer(int answer, int userAnswer) {
        return answer == userAnswer;
    }

    public static boolean isCorrectAnswer(String answer, String userAnswer) {
        return answer.equalsIgnoreCase(userAnswer);
    }

    public static boolean isCorrectAnswer(int answer, String userAnswer) {
        return answer == Integer.parseInt(userAnswer);
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
        return getRand(0, range);
    }

    public static int getRand() {
        return getRand(0, 100);
    }

    public static boolean isNumeric(String string) {
        return string != null && string.matches("-?[0-9.]+");
    }


    public static int lowCommonMultiple(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : lowCommonMultiple(b, a % b);
    }
}
