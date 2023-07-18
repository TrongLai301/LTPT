import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Number need Guess: ");
        int num = scanner.nextInt();

        GuessRandomNumber firstThread = new GuessRandomNumber(num);
        Thread thread1 = new Thread(firstThread);
        thread1.start();

        GuessRandomNumber secondThread = new GuessRandomNumber(num);
        Thread thread2 = new Thread(firstThread);
        thread2.start();
    }
}