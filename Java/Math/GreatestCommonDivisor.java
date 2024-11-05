import java.util.Scanner;
import java.util.*
public class GreatestCommonDivisor {
// Explanation:
// The method calculateGCD implements the Euclidean algorithm, which repeatedly replaces the larger number with the remainder of the division until one number becomes zero. The other number is the GCD.
// The main method reads two numbers from the user and calculates their GCD using the calculateGCD method.
// This is the simplest and efficient way to compute the GCD.

    public static int calculateGCD(int a, int b) {
        // Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();

        int gcd = calculateGCD(num1, num2);
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + gcd);
    }
}

