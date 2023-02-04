package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        var choice = scanner.nextLine();

        switch (choice) {
            case "1" -> {
                Cli.greeting();
            }
            case "2" -> {
                Even.game();
            }
            case "3" -> {
                Calc.game();
            }
            default -> {
            }
        }
    }
}
