package hexlet.code.games;

import hexlet.code.Engine;


public class Even {
    public static void game() {
        Engine.startGame();

        while (Engine.index++ < Engine.ROUNDS) {
            var number = Engine.getRand();
            var isNoResidue = number % 2 == 0;
            var answer = isNoResidue ? "yes" : "no";

            System.out.println("Question: " + number);

            var userAnswer = Engine.getAnswer();

            if (userAnswer.equalsIgnoreCase("yes")
                    || userAnswer.equalsIgnoreCase("no")) {

                var flagAnswer = userAnswer.equalsIgnoreCase("yes");
                if (isNoResidue == flagAnswer) {
                    Engine.correctAnswer();
                    continue;
                }
            }
            Engine.wrongAnswer(userAnswer, answer);
            break;
        }
    }
}
