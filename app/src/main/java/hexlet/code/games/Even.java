package hexlet.code.games;

import hexlet.code.Engine;


public class Even {
    public static void game() {
        Engine.startGame();

        int index = Engine.START_INDEX;
        while (index++ < Engine.ROUNDS) {
            var number = Engine.getRand();
            var answer = number % 2 == 0 ? "yes" : "no";

            System.out.println("Question: " + number);
            var userAnswer = Engine.getAnswer();
            if (answer.equalsIgnoreCase(userAnswer)) {
                Engine.correctAnswer(index);
                continue;
            }
            Engine.wrongAnswer(userAnswer, answer);
            break;
        }
    }
}
