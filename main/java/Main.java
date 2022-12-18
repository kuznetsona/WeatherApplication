import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;


public class Main {

    private static Scanner scanner;
    private static PrintStream printStream;

    public Main(InputStream inputStream, PrintStream printStream) {
        scanner = new Scanner(inputStream);
        Main.printStream = printStream;
    }

    public static void main(String[] args) {
        Main userInputExample = new Main(System.in, System.out);
        userInputExample.start();
    }

    public void start() {
        double result;
        while (true) {
            printStream.println("F or C ?");
            String mode = scanner.nextLine();

        }


    }


    public static double temperatureCtoF(double temperature) {
        return temperature * 9.0 / 5.0 + 32.0;
    }

}
