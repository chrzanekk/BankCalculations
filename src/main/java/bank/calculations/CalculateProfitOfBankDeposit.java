package bank.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateProfitOfBankDeposit {

    public static final int PERCENT = 100;
    public static final int ONE = 1;


    public BigDecimal returnOnInvestment(String interestRate, String capitalisationCount, String numberOfYears, String deposit) {
        int numberOfYearsByInt = (int)(Double.parseDouble(numberOfYears));
        int capitalisationCountByInt = (int)(Double.parseDouble(capitalisationCount));
        BigDecimal cashDeposit = BigDecimal.valueOf(Double.parseDouble(deposit));
        BigDecimal percentOfInterestRate = percentOfInterestRate(interestRate);

        BigDecimal compoundInterest = BigDecimal.valueOf(ONE)
                .add((percentOfInterestRate)
                        .divide(BigDecimal.valueOf(capitalisationCountByInt),4,RoundingMode.CEILING))
                .pow(numberOfYearsByInt*capitalisationCountByInt);
        return cashDeposit.multiply(compoundInterest).setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal percentOfInterestRate(String interestRate) {
        BigDecimal interRate = BigDecimal.valueOf(Double.parseDouble(interestRate));
        return interRate.divide(BigDecimal.valueOf(PERCENT), 4, RoundingMode.CEILING);
    }

}
