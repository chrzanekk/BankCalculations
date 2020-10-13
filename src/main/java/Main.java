import java.math.BigDecimal;
import java.util.Scanner;
import bank.calculations.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalculateProfitOfBankDeposit calculateProfitOfBankDeposit = new CalculateProfitOfBankDeposit();

        System.out.println("Year interest rate: ");
        String interestRate = getPlayerInput(scanner);

        System.out.println("Investment time (in years): ");
        String numberOfYears = getPlayerInput(scanner);


        System.out.println("Number of capitalisation per year(1=year, 2=half year, 4=quarter of year, 12=monthly): ");
        String capitalisationCount = getPlayerInput(scanner);

        System.out.println("Deposit: ");
        String deposit = getPlayerInput(scanner);

        System.out.println(calculateProfitOfBankDeposit.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit));
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
