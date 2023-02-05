package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    public static void game() {
        Engine.startGame();

        while (Engine.index++ < Engine.ROUNDS) {
            var startNumber = Engine.getRand();
            var step = Engine.getRand(Engine.PROGRESSION_STEP_FROM, Engine.PROGRESSION_STEP_TO);
            var progressionLength = Engine.getRand(Engine.PROGRESSION_LENGTH_FROM, Engine.PROGRESSION_LENGTH_TO);
            var hiddenNumber = Engine.getRand(progressionLength);
            var answer = startNumber + step * hiddenNumber;
            var answerToString = "" + answer;

            StringBuilder progression = new StringBuilder();
            for (int i = 0; i < progressionLength; i++) {
                if (startNumber == answer) {
                    progression.append(" ..");
                    startNumber = startNumber + step;
                    continue;
                }
                progression.append(" ").append(startNumber);
                startNumber = startNumber + step;
            }

            System.out.println("Question:" + progression);
            var userAnswer = Engine.getAnswer();
            if (answerToString.equalsIgnoreCase(userAnswer)) {
                Engine.correctAnswer();
                continue;
            }
            Engine.wrongAnswer(userAnswer, answer);
            break;
        }
    }
}
