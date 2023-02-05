package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static void game() {
        Engine.startGame();
        while (Engine.index++ < Engine.ROUNDS) {
            var number = Engine.getRand();
            var answer = Engine.isPrimeNumber(number) ? "yes" : "no";

            System.out.println("Question: " + number);
            var userAnswer = Engine.getAnswer();

            if (answer.equalsIgnoreCase(userAnswer)) {
                Engine.correctAnswer();
                continue;
            }
            Engine.wrongAnswer(userAnswer, answer);
            break;
        }
    }
}
