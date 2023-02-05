package hexlet.code.games;

import hexlet.code.Engine;

public class Gcd {
    public static void game() {
        Engine.startGame();
        while (Engine.index++ < Engine.ROUNDS) {
            var firstNumber = Engine.getRand();
            var secondNumber = Engine.getRand();
            var answer = "" + Engine.lowCommonMultiple(firstNumber, secondNumber);

            System.out.println("Question: " + firstNumber + " " + secondNumber);
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
