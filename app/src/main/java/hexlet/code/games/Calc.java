package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void game() {
        Engine.startGame();

        while (Engine.index++ < Engine.ROUNDS) {
            var firstNumber = Engine.getRand();
            var secondNumber = Engine.getRand();
            int answer;

            System.out.print("Question: " + firstNumber);
            switch (Engine.getRand(Engine.OPERATORS_COUNT)) {
                case 1 -> { // minus
                    answer = firstNumber - secondNumber;
                    System.out.print(" - ");
                }
                case 2 -> { // multiplication
                    answer = firstNumber * secondNumber;
                    System.out.print(" * ");
                }
                default -> { //plus
                    answer = firstNumber + secondNumber;
                    System.out.print(" + ");
                }
            }
            System.out.println(secondNumber);

            var userAnswer = Engine.getAnswer();
            if (!Engine.isNumeric(userAnswer)
                    || !Engine.isCorrectAnswer(answer, userAnswer)) {
                Engine.wrongAnswer(userAnswer, answer);
                break;
            }
            Engine.correctAnswer();
        }
    }
}
