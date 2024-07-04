package com.debodam.calculator;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
            String operation = scanner.next().toLowerCase();
            
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }
            
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") &&
                !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") &&
                !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial")) {
                
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();
                
                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + subtract(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + multiply(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else {
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                
                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    case "factorial":
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }
        
        scanner.close();
    }
    
    // Utility methods for basic operations
    public static double add(double a, double b) {
        return a + b;
    }
    
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is undefined.");
        }
        return a / b;
    }
    
    // Utility methods for scientific operations
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }
    
    public static double log(double number) {
        return Math.log(number);
    }
    
    public static double log10(double number) {
        return Math.log10(number);
    }
    
    // Trigonometric functions with radians
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }
    
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }
    
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }
    
    // Factorial calculation
    public static long factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Factorial of negative number is undefined.");
        }
        long result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
