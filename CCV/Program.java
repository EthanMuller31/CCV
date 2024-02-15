import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        introAndGreeting(userInput);
        userInput.close();
    }

    private static void introAndGreeting(Scanner userInput) {
        System.out.println("Welcome to my Credit Card Validator. \nPlease enter your credit card number as four groups of four digits, separated by spaces.");
        System.out.print("For example: 5424 1801 2345 6789 \n\nEnter your credit card number: ");

        // Read the entire credit card number as one string
        String cardNumber = userInput.nextLine().replaceAll("\\s", ""); // Remove spaces if any
        //if statement to display valid or invalid based off the isValidCreditCardNumber method
        if (isValidCreditCardNumber(cardNumber)) {
            System.out.println("The credit card number is valid.");
        } else {
            System.out.println("The credit card number is invalid.");
        }
    }
    //Takes one parameter, cardNumber which is the string CC Number
    private static boolean isValidCreditCardNumber(String cardNumber) {
    	//init sum as 0
        int sum = 0;
        //Initialize as false, first digit not doubled, but added to the sum
        boolean alternate = false;
        //for loop goes through string from right to left one at a time
        //use of substring and parseInt too single out singular numeric character to be converted to int value
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            //When alternate is true it will double the number and asses it
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            //switches alternate each time through so that every other number is doubled
            alternate = !alternate;
        }
        //returns true if the final sum is able to be divided by 10 deeming the CC Number Valid
        return (sum % 10 == 0);
    }
}

