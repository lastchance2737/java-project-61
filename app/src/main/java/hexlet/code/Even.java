package hexlet.code;

import java.util.Scanner;

public class Even {
    public static void game() {
        var username = Cli.greeting();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var index = 0;
        while (index < 3) {
            var number = (int) (Math.random() * 100);
            var isNoResidue = number % 2 == 0;
            var correctAnswer = isNoResidue ? "yes" : "no";

            System.out.println("Question: " + number);
            System.out.print("Your answer: ");
            var userAnswer = scanner.next();

            if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("no")) {
                var flagAnswer = userAnswer.equalsIgnoreCase("yes");

                if (isNoResidue == flagAnswer) {
                    System.out.println("Correct!");
                    index++;
                    if (index == 3) {
                        System.out.println("Congratulations, " + username + "!");
                    }
                    continue;
                }
                wrongAnswer(userAnswer, correctAnswer, username);
                break;

            } else {
                wrongAnswer(userAnswer, correctAnswer, username);
                break;
            }
        }
    }

    private static void wrongAnswer(String userAnswer, String correctAnswer, String username) {
        System.out.println("'" + userAnswer + "' " + "is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + username + "!");
    }
}
