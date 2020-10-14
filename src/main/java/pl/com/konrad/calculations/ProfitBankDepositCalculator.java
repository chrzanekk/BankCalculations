package pl.com.konrad.calculations;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ProfitBankDepositCalculator {

    public static final int PERCENT = 100;
    public static final int ONE = 1;


    public BigDecimal returnOnInvestment(BigDecimal interestRate, Integer capitalisationCount, Integer numberOfYears,
                                         BigDecimal deposit) {
        BigDecimal percentOfInterestRate = percentOfInterestRate(interestRate);

        BigDecimal compoundInterest = BigDecimal.valueOf(ONE)
                .add((percentOfInterestRate)
                        .divide(BigDecimal.valueOf(capitalisationCount), 4, RoundingMode.CEILING))
                .pow(numberOfYears * capitalisationCount);
        return deposit.multiply(compoundInterest).setScale(2, RoundingMode.CEILING);
    }

    private BigDecimal percentOfInterestRate(BigDecimal interestRate) {
        return interestRate.divide(BigDecimal.valueOf(PERCENT), 4, RoundingMode.CEILING);
    }

}
