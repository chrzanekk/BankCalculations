import java.math.BigDecimal;
import java.util.Scanner;

import pl.com.konrad.calculations.ProfitBankDepositCalculator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProfitBankDepositCalculator profitBankDepositCalculator = new ProfitBankDepositCalculator();

        System.out.println("Year interest rate: ");
        BigDecimal interestRate = getUserInputAsBigDecimal(scanner);

        System.out.println("Investment time (in years): ");
        Integer numberOfYears = getUserInputAsInteger(scanner);

        System.out.println("Number of capitalisation per year(1=year, 2=half year, 4=quarter of year, 12=monthly): ");
        Integer capitalisationCount = getUserInputAsInteger(scanner);

        System.out.println("Deposit: ");
        BigDecimal deposit = getUserInputAsBigDecimal(scanner);

        System.out.println(profitBankDepositCalculator.returnOnInvestment(interestRate, capitalisationCount, numberOfYears, deposit));
    }


    private static String getUserInput(Scanner scanner) {
        String userInput;
        System.out.println("input value: ");
        while (!scanner.hasNext()) {
            System.out.println("Wrong input. Try again.");
        }
        userInput = scanner.next();
        return userInput;
    }

    private static Integer getUserInputAsInteger(Scanner scanner) {
        return Integer.valueOf(getUserInput(scanner));
    }

    private static BigDecimal getUserInputAsBigDecimal(Scanner scanner) {
        return new BigDecimal(getUserInput(scanner));
    }
}
