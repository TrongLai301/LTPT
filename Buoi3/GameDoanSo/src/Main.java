import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number need Guess: ");
        int num = scanner.nextInt();

        GuessRandomNumber firstThread = new GuessRandomNumber(num);
        firstThread.start();

        GuessRandomNumber secondThread = new GuessRandomNumber(num);
        secondThread.start();
    }
}