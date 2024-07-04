package com.debodam.calculator;

import java.util.Scanner;

/**
 * A simple command-line calculator application that supports basic arithmetic operations,
 * scientific calculations, factorial computation, and permutations.
 */
public class Application {

    /**
     * Main method to run the calculator application.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, perm) or 'exit' to quit:");
            String operation = scanner.next().toLowerCase();
            
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }
            
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") &&
                !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") &&
                !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial") && !operation.equalsIgnoreCase("perm")) {
                
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
                        try {
                            System.out.println("Result: " + divide(num1, num2));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (operation.equalsIgnoreCase("sqrt") || operation.equalsIgnoreCase("log") ||
                       operation.equalsIgnoreCase("log10") || operation.equalsIgnoreCase("sin") ||
                       operation.equalsIgnoreCase("cos") || operation.equalsIgnoreCase("tan") ||
                       operation.equalsIgnoreCase("factorial")) {
                
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();
                
                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        try {
                            System.out.println("Result: " + log(num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "log10":
                        try {
                            System.out.println("Result: " + log10(num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        try {
                            System.out.println("Result: " + tan(num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case "factorial":
                        try {
                            System.out.println("Result: " + factorial((int) num));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else if (operation.equalsIgnoreCase("perm")) {
                try {
                    System.out.print("Enter total number of elements: ");
                    int totalElements = scanner.nextInt();
                    System.out.print("Enter number of items to select: ");
                    int selectedItems = scanner.nextInt();
                    
                    long result = permutations(totalElements, selectedItems);
                    System.out.println("Result: " + result);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid operation.");
            }
        }
        
        scanner.close();
    }
    
    /**
     * Adds two numbers.
     * @param a First number.
     * @param b Second number.
     * @return Sum of the two numbers.
     */
    public static double add(double a, double b) {
        return a + b;
    }
    
    /**
     * Subtracts one number from another.
     * @param a First number (minuend).
     * @param b Second number (subtrahend).
     * @return Result of the subtraction.
     */
    public static double subtract(double a, double b) {
        return a - b;
    }
    
    /**
     * Multiplies two numbers.
     * @param a First number.
     * @param b Second number.
     * @return Product of the two numbers.
     */
    public static double multiply(double a, double b) {
        return a * b;
    }
    
    /**
     * Divides one number by another.
     * @param a Numerator.
     * @param b Denominator.
     * @return Result of the division.
     * @throws IllegalArgumentException if the denominator is zero.
     */
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is undefined.");
        }
        return a / b;
    }
    
    /**
     * Raises a number to the power of another number.
     * @param base Base number.
     * @param exponent Exponent.
     * @return Result of raising base to the exponent power.
     */
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }
    
    /**
     * Computes the square root of a number.
     * @param number Number to compute square root of.
     * @return Square root of the number.
     * @throws IllegalArgumentException if the number is negative.
     */
    public static double sqrt(double number) {
        if (number < 0) {
            throw new IllegalArgumentException("Square root of negative number is undefined.");
        }
        return Math.sqrt(number);
    }
    
    /**
     * Computes the natural logarithm (base e) of a number.
     * @param number Number to compute natural logarithm of.
     * @return Natural logarithm of the number.
     * @throws IllegalArgumentException if the number is non-positive.
     */
    public static double log(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm of non-positive number is undefined.");
        }
        return Math.log(number);
    }
    
    /**
     * Computes the base 10 logarithm of a number.
     * @param number Number to compute base 10 logarithm of.
     * @return Base 10 logarithm of the number.
     * @throws IllegalArgumentException if the number is non-positive.
     */
    public static double log10(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm base 10 of non-positive number is undefined.");
        }
        return Math.log10(number);
    }
    
    /**
     * Computes the sine of an angle (in radians).
     * @param angleRadians Angle in radians.
     * @return Sine of the angle.
     */
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }
    
    /**
     * Computes the cosine of an angle (in radians).
     * @param angleRadians Angle in radians.
     * @return Cosine of the angle.
     */
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }
    
    /**
     * Computes the tangent of an angle (in radians).
     * @param angleRadians Angle in radians.
     * @return Tangent of the angle.
     * @throws IllegalArgumentException if the angle is a multiple of pi/2.
     */
    public static double tan(double angleRadians) {
        if (Math.abs(Math.cos(angleRadians)) < 1e-6) {
            throw new IllegalArgumentException("Tangent undefined for angle that is a multiple of pi/2.");
        }
        return Math.tan(angleRadians);
    }
    
    /**
     * Computes the factorial of a non-negative integer.
     * @param num Non-negative integer.
     * @return Factorial of the number.
     * @throws IllegalArgumentException if the number is negative.
     */
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
    
    /**
     * Question:
     * It seems that in the above code (i.e., int progress = (int) (((originalNum - num) / (double)
     * originalNum) * 100); ), the progress bar does not cover the number 1. Can you identify why
     * this might be happening and suggest a way to ensure that the number 1 is included in the progress
     * calculation?
     *
     * Answer:
     * In Java, when calculating a progress bar percentage using floating-point arithmetic like ((originalNum - num) / (double) originalNum) * 100,
     * precision issues can sometimes cause the number 1 to be excluded from the progress calculation. To ensure inclusivity of the number 1,
     * it's advisable to use integer arithmetic or adjust the calculation logic by ensuring the result is appropriately rounded up.
     * For instance, using Math.ceil(((originalNum - num) * 100.0) / originalNum) ensures that all values, including 1, are covered
     * in the progress bar calculation.
     */
    
    /**
     * Computes the number of permutations of selecting a number of items from a set of elements.
     * @param totalElements Total number of elements in the set.
     * @param selectedItems Number of items to select.
     * @return Number of permutations.
     * @throws IllegalArgumentException if selectedItems is negative, greater than totalElements,
     *         or exceeds 100 (maximum supported items).
     */
    public static long permutations(int totalElements, int selectedItems) {
        // Error checking
        if (selectedItems < 0 || selectedItems > totalElements || selectedItems > 100) {
            throw new IllegalArgumentException("Invalid number of selected items.");
        }

        // Base case: If no items are selected, there is exactly 1 permutation
        if (selectedItems == 0) {
            return 1;
        }

        // Recursive case: Calculate permutations
        return totalElements * permutations(totalElements - 1, selectedItems - 1);
    }
}
