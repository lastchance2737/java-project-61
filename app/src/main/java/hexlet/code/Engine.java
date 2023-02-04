package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static final int OPERATORS_COUNT = 3;
    public static final String CALC_RULE = "What is the result of the expression?";
    public static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final String NOD_RULE = "Find the greatest common divisor of given numbers.";
    public static String playerName;
    public static int choice;
    public static int index = 0;

    public static void startGame() {
        Engine.welcome();
        Engine.setUsername();
        Engine.gameRule();
    }

    public static void menu() {
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
                4 - NOD
                0 - Exit
                Your choice:\s""");
        Scanner scanner = new Scanner(System.in);
        Engine.choice = scanner.nextInt();
    }

    public static void gameRule() {
        var ruleString = "";
        switch (choice) {
            case 2 -> {
                ruleString = EVEN_RULE;
            }
            case 3 -> {
                ruleString = CALC_RULE;
            }
            case 4 -> {
                ruleString = NOD_RULE;
            }
            default -> {
            }
        }
        System.out.println(ruleString);
    }

    public static void wrongAnswer(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
    }

    public static void wrongAnswer(int userAnswer, int correctAnswer) {
        wrongAnswer(Integer.toString(userAnswer), Integer.toString(correctAnswer));
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static void welcome() {
        System.out.println("Welcome to the Brain Games!");
    }

    public static void setUsername() {
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
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

    public static void correctAnswer() {
        System.out.println("Correct!");
        if (Engine.index == Engine.ROUNDS) {
            Engine.congratulations();
        }
    }

    public static int lowCommonMultiple(int a, int b) {
        return (a % b == 0) ? Math.abs(b) : lowCommonMultiple(b, a % b);
    }
}
