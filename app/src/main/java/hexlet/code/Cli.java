package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greeting() {
        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        var name = scanner.nextLine();
        scanner.close();

        System.out.println("Hello, " + name + "!");
    }
}
