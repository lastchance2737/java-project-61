package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.Nod;

public class App {
    public static void main(String[] args) {
        Engine.menu();
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
                Nod.game();
            }
            default -> {
            }
        }
    }
}
