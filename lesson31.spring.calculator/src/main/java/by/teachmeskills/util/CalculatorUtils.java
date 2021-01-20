package by.teachmeskills.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.springframework.stereotype.Component;

@Component
public class CalculatorUtils {

    public int readIntValue(String message) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, expecting number");
            }
        }
    }

    public String readStringValue(String message) {
        String result = null;
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            result = scanner.nextLine();
            break;
        }
        return result;
    }

    public boolean readBooleanValue(String message) {
        while (true) {
            final Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            try {
                return scanner.nextBoolean();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input, expecting boolean");
            }
        }
    }

}
