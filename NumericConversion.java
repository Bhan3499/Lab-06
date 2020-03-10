// This is a comment for github
import java.util.Scanner;
public class NumericConversion {
    public static void main(String[] args) {
        String option;
        Scanner input = new Scanner(System.in);

        // Loop until the user wants it to end
        do {
            option = menu(input);
            if (!option.equals("4")) {
                process(option, input);
            }
        }   while (!option.equals("4"));
        System.out.println("Goodbye!");
    }

    // This method will display the menu and take an input
    public static String menu(Scanner input) {
        String option;
        System.out.println("Decoding Menu");
        System.out.println("-------------");
        System.out.println("1. Decode hexadecimal");
        System.out.println("2. Decode binary");
        System.out.println("3. Convert binary to hexadecimal");
        System.out.println("4. Quit");
        System.out.println();
        System.out.print("Please enter an option: ");
        option = input.next();
        return option;
    }

    // This method will perform an operation based on which option the user inputs
    public static void process(String option, Scanner input) {
        String sInput;

        System.out.print("Please enter the numeric string to convert: ");
        sInput = input.next();
        sInput = sInput.toUpperCase();

        // See which option the user choose
        switch (option) {
            // If the user wants to convert hexadecimals to decimal
            case "1":
                long output1 = hexStringDecode(sInput);
                System.out.println("Result: " + output1);
                System.out.println();
                break;
            // If the user wants to convert binary to decimal
            case "2":
                short output3 = binaryStringDecode(sInput);
                System.out.println("Result: " + output3);
                System.out.println();
                break;
            // If the user wants to convert binary to hexadecimal
            case "3":
                String output4 = binaryToHex(sInput);
                System.out.println("Result: " + output4);
                System.out.println();
                break;
        }
    }

    // This will convert hexademicals to decimals
    public static long hexStringDecode(String hex) {
        String hexInput = hex.toLowerCase();
        char token;
        long total = 0;

        // Take out the first two characters if needed
        if (hexInput.indexOf("0x") != -1) {
            hexInput = hexInput.substring(2);
        }

        hexInput = hexInput.toUpperCase();
        // Look over each individual character in the string
        for (int i = 0; i < hexInput.length(); i++) {
            token = hexInput.charAt(hexInput.length() - 1 - i);

            if ((int)token > 57) {
                total += (Math.pow(16, i) * ((long)token - 55));
            }
            else {
                total += (Math.pow(16, i) * ((long)token - 48));
            }
        }

        return total;
    }

    // This will convert a single digit of a hexdecimal number to a decimal number
    public static short hexCharDecode(char digit) {
        String input = "";
        input += digit;
        input = input.toUpperCase();
        char token = input.charAt(0);
        int total = 0;

        // See if it is a integer digit or a letter
        if ((short)token > 57) {
            total += ((int)token - 55);
        }
        else {
            total += ((int)token - 48);
        }

        short output2 = (short)total;

        return output2;
    }

    // This will convert a binary number into a decimal number
    public static short binaryStringDecode(String binary) {
        String binaryInput = binary.toLowerCase();
        char token;
        int total = 0;
        short output3;

        // Take out the first two characters if needed
        if (binaryInput.indexOf("0b") != -1) {
            binaryInput = binaryInput.substring(2);
        }

        binaryInput = binaryInput.toUpperCase();
        // Iterate over each of the characters in the string
        for (int i = 0; i < binaryInput.length(); i++) {
            token = binaryInput.charAt(binaryInput.length() - 1 - i);

            if (((int)token - 48) == 1) {
                total += Math.pow(2, i);
            }
        }

        output3 = (short)total;
        return output3;
    }

    // This will convert binary numbers into hexadecimals
    public static String binaryToHex(String binary) {
        String binaryInput = binary.toLowerCase();
        char token;
        int total = 0;
        int remainder;
        int counter = 0;
        String output4 = "";

        // Take out the first two characters if needed
        if (binaryInput.indexOf("0b") != -1) {
            binaryInput = binaryInput.substring(2);
        }

        binaryInput = binaryInput.toUpperCase();
        // Iterate over each of the characters in the string
        for (int i = 0; i < binaryInput.length(); i++) {
            token = binaryInput.charAt(binaryInput.length() - 1 - i);

            if (((int)token - 48) == 1) {
                total += Math.pow(2, i);
            }
        }

        // Converting decimals into hexadecimals
        while (total != 0) {
            remainder = total % 16;
            total = (total / 16);

            String chunk = getCharacter(remainder);
            output4 = chunk + output4;
        }

        return output4.toUpperCase();
    }

    // This will assign the appropriate decimal value to the character based on what it is
    public static String getCharacter(int remainder) {
        String result = "";

        // If the digit is a number
        if (remainder < 10) {
            result += remainder;
        }
        // If the digit is a letter
        else {
            // The remainder will be between 10 and 15 inclusive
            switch(remainder) {
                // If the digit is an a
                case 10:
                    result += "a";
                    break;
                // If the digit is an b
                case 11:
                    result += "b";
                    break;
                // If the digit is an c
                case 12:
                    result += "c";
                    break;
                // If the digit is an d
                case 13:
                    result += "d";
                    break;
                // If the digit is an e
                case 14:
                    result += "e";
                    break;
                // If the digit is an f
                case 15:
                    result += "f";
                    break;
            }
        }

        // Assign the remainder a decimal value
        return result;
    }
}
