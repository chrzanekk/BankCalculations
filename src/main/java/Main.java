import java.math.BigDecimal;
import java.util.Scanner;
import bank.calculations.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateProfitOfBankDeposit calculateProfitOfBankDeposit = new CalculateProfitOfBankDeposit();
        System.out.println("Interest rate: ");
        String interestRate = getPlayerInput(scanner);
        System.out.println("Number of months: ");
        String numberOfMonths = getPlayerInput(scanner);
        System.out.println("Deposit: ");
        String deposit = getPlayerInput(scanner);

        System.out.println(calculateProfitOfBankDeposit.returnOnInvestment(interestRate,numberOfMonths,deposit));


    }



    private static String getPlayerInput(Scanner scanner) {
        Double userInput;
        System.out.println("input value: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Wrong input. Try again.");
            }

            userInput = scanner.nextDouble();
        return String.valueOf(userInput);
    }

}
