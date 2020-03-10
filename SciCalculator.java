import java.util.Scanner;
public class SciCalculator {
    // Declaring the instance variables
    static double result;
    static double totalCalculations = 0;
    static int numCalculations = 0;

    public static void main(String[] args) {
        // Initializing the variables
        String sOperand1;
        String sOperand2;
        double operand1;
        double operand2;
        int choice;
        Scanner input = new Scanner(System.in);

        // Run the program
        System.out.println("Current Result: 0.0");
        System.out.println();
        do {
            // The initial input by the user
            choice = prompt(input);

            while ((choice < 0) || (choice > 7)) {
                System.out.println("Error: Invalid selection!");
                System.out.print("Enter Menu Selection: ");
                choice = input.nextInt();
            }

            // Check if the user wants to exit
            if (choice == 0) {
                System.out.println("Thanks for using this calculator. Goodbye!");
                break;
            }

            // Check if the user entered 7
            while (choice == 7) {
                System.out.println();
                // Check if this is the first run
                if (numCalculations == 0) {
                    System.out.println("Error: No calculations yet to average!");
                    System.out.println();

                    System.out.print("Enter Menu Selection: ");
                    choice = input.nextInt();

                    while ((choice < 0) || (choice > 7)) {
                        System.out.println("Error: Invalid selection!");
                        System.out.print("Enter Menu Selection: ");
                        choice = input.nextInt();
                    }

                    // Check if the user wants to exit
                    if (choice == 0) {
                        System.out.println("Thanks for using this calculator. Goodbye!");
                        break;
                    }
                }
                // Run if this is not the first time
                else {
                    System.out.println("Sum of calculations: " + totalCalculations);
                    System.out.println("Number of calculations: " + numCalculations);
                    System.out.println("Average of calculations: " + (Math.round((100 * totalCalculations / numCalculations)) / 100.0));
                    System.out.println();

                    System.out.print("Enter Menu Selection: ");
                    choice = input.nextInt();

                    while ((choice < 0) || (choice > 7)) {
                        System.out.println("Error: Invalid selection!");
                        System.out.print("Enter Menu Selection: ");
                        choice = input.nextInt();
                    }

                    // Check if the user wants to exit
                    if (choice == 0) {
                        System.out.println("Thanks for using this calculator. Goodbye!");
                        break;
                    }
                }
            }

            if (choice != 0) {
                // Prompt the user for the operands if the choice is not 7
                System.out.print("Enter first operand: ");
                sOperand1 = input.next();
                System.out.print("Enter second operand: ");
                sOperand2 = input.next();
                System.out.println();

                // Check if a number or the result were entered for operand 1
                if (sOperand1.indexOf("RESULT") > -1) {
                    operand1 = result;
                } else {
                    operand1 = Double.parseDouble(sOperand1);
                }

                // Check if a number or the result were entered for operand 2
                if (sOperand2.indexOf("RESULT") > -1) {
                    operand2 = result;
                } else {
                    operand2 = Double.parseDouble(sOperand2);
                }

                // Perform the calculations
                calculations(operand1, operand2, choice);
            }
        } while(choice != 0);
    }

    private static int prompt(Scanner input) {
        int choice;
        // Prompt the user to choose an operation
        System.out.println("Calculator Menu");
        System.out.println("---------------");
        System.out.println("0. Exit Program");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exponentiation");
        System.out.println("6. Logarithm");
        System.out.println("7. Display Average");
        System.out.println();
        System.out.print("Enter Menu Selection: ");
        choice = input.nextInt();

        return choice;
    }

    private static void calculations(double operand1, double operand2, int choice) {
        // Process which choice it is
        switch(choice) {
            // If it is addition
            case 1:
                System.out.println("Current Result: " + (operand1 + operand2));
                System.out.println();

                result = operand1 + operand2;
                totalCalculations += result;
                numCalculations++;
                break;
            // If it is subtraction
            case 2:
                System.out.println("Current Result: " + (operand1 - operand2));
                System.out.println();

                result = operand1 - operand2;
                totalCalculations += result;
                numCalculations++;
                break;
            // If it is multiplication
            case 3:
                System.out.println("Current Result: " + (operand1 * operand2));
                System.out.println();

                result = operand1 * operand2;
                totalCalculations += result;
                numCalculations++;
                break;
            // If it is division
            case 4:
                System.out.println("Current Result: " + (operand1 / operand2));
                System.out.println();

                result = operand1 / operand2;
                totalCalculations += result;
                numCalculations++;
                break;
            // If it is exponentiation
            case 5:
                System.out.println("Current Result: " + Math.pow(operand1, operand2));
                System.out.println();

                result = Math.pow(operand1, operand2);
                totalCalculations += result;
                numCalculations++;
                break;
            // If it is logarithms
            case 6:
                System.out.println("Current Result: " + (Math.log(operand2) / Math.log(operand1)));
                System.out.println();

                result = (Math.log(operand2) / Math.log(operand1));
                totalCalculations += result;
                numCalculations++;
                break;
        }
    }
}
