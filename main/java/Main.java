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
            if (!checkCorrect(mode)) printStream.println("error.");
            if (mode.equals("C")) {
                result = convertCToF();
                break;
            } else if (mode.equals("F")) {
                result = convertFtoC();
                break;
            }
        }
        printStream.println((result * 10.0) / 10.0);

    }

    public static boolean checkCorrect(String mode) {
        return mode.equals("C") || mode.equals("F");
    }

    public double convertCToF() {
        double temperature = getTemperature(scanner, printStream);
        return temperatureCtoF(temperature);
    }

    public static double temperatureCtoF(double temperature) {
        return temperature * 9.0 / 5.0 + 32.0;
    }

    public double convertFtoC() {
        double temperature = getTemperature(scanner, printStream);
        return temperatureFtoC(temperature);
    }

    public static double temperatureFtoC(double temperature) {
        return (temperature - 32.0) * 5.0 / 9.0;
    }

    public double getTemperature(Scanner scanner, PrintStream printStream) {
        double temperature;
        while (true) {
            printStream.println("Print:");
            String value = scanner.nextLine();
            if (!checkCorr(value)) {
                printStream.println("Wrong input value");
                continue;
            }
            try {
                if (value.contains(".")) {
                    temperature = Double.parseDouble(value);
                } else {
                    temperature = Integer.parseInt(value);
                }
                break;
            } catch (Exception e) {
                printStream.println("Wrong input value");
            }
        }
        return temperature;
    }

    public static boolean checkCorr(String value) {
        return value.matches("-?\\d+(\\.\\d+)?");
    }

}
