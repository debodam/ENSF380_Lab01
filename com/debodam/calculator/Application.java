package com.debodam.calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Check if arguments were passed from command line
        if (args.length > 0) {
            String operation = args[0].toLowerCase();
            System.out.println("Selected Operation: " + operation);
            handleOperation(operation, scanner);
        } else {
            // Prompt user to enter operation if no arguments provided
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next().toLowerCase();
            handleOperation(operation, scanner);
        }
        
        scanner.close();
    }
    
    /**
     * Handles different calculator operations based on user input.
     * @param operation The operation to perform (add, subtract, multiply, divide, factorial)
     * @param scanner Scanner object to read user input
     */
    public static void handleOperation(String operation, Scanner scanner) {
        switch (operation) {
            case "add":
                System.out.println("Enter the first number:");
                double num1 = scanner.nextDouble();
                System.out.println("Enter the second number:");
                double num2 = scanner.nextDouble();
                System.out.println("Result: " + add(num1, num2));
                break;
            case "subtract":
                System.out.println("Enter the first number:");
                double num3 = scanner.nextDouble();
                System.out.println("Enter the second number:");
                double num4 = scanner.nextDouble();
                System.out.println("Result: " + subtract(num3, num4));
                break;
            case "multiply":
                System.out.println("Enter the first number:");
                double num5 = scanner.nextDouble();
                System.out.println("Enter the second number:");
                double num6 = scanner.nextDouble();
                System.out.println("Result: " + multiply(num5, num6));
                break;
            case "divide":
                System.out.println("Enter the dividend:");
                double dividend = scanner.nextDouble();
                System.out.println("Enter the divisor (non-zero):");
                double divisor = scanner.nextDouble();
                try {
                    System.out.println("Result: " + divide(dividend, divisor));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case "factorial":
                System.out.println("Enter a number:");
                double number = scanner.nextDouble();
                System.out.println("Result: " + factorial(number));
                break;
            default:
                System.out.println("Invalid operation: " + operation);
        }
    }

    /**
     * Adds two numbers.
     * @param a First number
     * @param b Second number
     * @return Sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Calculates the factorial of a number.
     * @param n Number to calculate factorial for
     * @return Factorial of n
     */
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    
    /**
     * Subtracts two numbers.
     * @param a First number
     * @param b Second number
     * @return Result of subtracting b from a
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers.
     * @param a First number
     * @param b Second number
     * @return Product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Divides two numbers.
     * @param a Dividend
     * @param b Divisor (non-zero)
     * @return Result of dividing a by b
     * @throws IllegalArgumentException if b is zero
     */
    public static double divide(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Division by zero is undefined.");
        }
    }
}
