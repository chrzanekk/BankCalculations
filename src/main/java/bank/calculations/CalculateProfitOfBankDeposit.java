package bank.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateProfitOfBankDeposit {

    public static final int PERCENT = 100;
    public static final int NUMBER_OF_DAYS_IN_MONTH = 30;
    public static final int NUMBER_OF_DAY_IN_YEAR = 365;

    public BigDecimal returnOnInvestment(String interestRate, String numberOfMonths, String deposit) {
        BigDecimal percentOfInterestRate = percentOfMonthlyInterestRate(interestRate);
        BigDecimal cashDeposit = BigDecimal.valueOf(Double.parseDouble(deposit));
        BigDecimal DepositTime =
                depositTimeInDays(numberOfMonths).divide(BigDecimal.valueOf(NUMBER_OF_DAY_IN_YEAR),4,
                        RoundingMode.CEILING);
        return cashDeposit.multiply(percentOfInterestRate).multiply(DepositTime).setScale(4,RoundingMode.CEILING);
    }

    public BigDecimal profitOfInvestmentWithDeposit (BigDecimal returnOnInvestment, String deposit) {
        return returnOnInvestment.add(BigDecimal.valueOf(Long.parseLong(deposit)));
    }

    private BigDecimal percentOfMonthlyInterestRate(String interestRate) {
        BigDecimal interRate = BigDecimal.valueOf(Double.parseDouble(interestRate));
        return interRate.divide(BigDecimal.valueOf(PERCENT),4, RoundingMode.CEILING);
    }

    private BigDecimal depositTimeInDays(String numberOfMonths) {
        BigDecimal numberOfDays =
                BigDecimal.valueOf(Long.parseLong(numberOfMonths)).multiply(BigDecimal.valueOf(NUMBER_OF_DAYS_IN_MONTH));
        return numberOfDays;
    }
}
