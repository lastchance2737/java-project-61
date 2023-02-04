package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    public static void game() {
        Engine.welcome();
        var username = Engine.getUsername();
        System.out.println("What is the result of the expression?");

        var index = 0;
        while (index++ < Engine.ROUNDS) {
            var firstNumber = Engine.getRand();
            var secondNumber = Engine.getRand();
            var answer = 0;

            System.out.print("Question: " + firstNumber);
            switch (Engine.getRand(Engine.OPERATORS_COUNT)) {
                case 0 -> { // plus
                    answer = firstNumber + secondNumber;
                    System.out.print(" + ");
                }
                case 1 -> { // minus
                    answer = firstNumber - secondNumber;
                    System.out.print(" - ");
                }
                case 2 -> { // multiplication
                    answer = firstNumber * secondNumber;
                    System.out.print(" * ");
                }
            }
            System.out.println(secondNumber);

            var userAnswer = Engine.getAnswer();

            if (!Engine.isNumeric(userAnswer)) {
                Engine.wrongAnswer(userAnswer, Integer.toString(answer), username);
                break;
            }
            if (answer == Integer.parseInt(userAnswer)) {
                Engine.correctAnswer(index, username);
            } else {
                Engine.wrongAnswer(userAnswer, Integer.toString(answer), username);
                break;
            }
        }
    }
}
