package pl.com.konrad.calculations;

import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class ProfitBankDepositCalculatorTest {
private static ProfitBankDepositCalculator profitBankDepositCalculator;

//dopisać negatywne scenariusze (bledne dane, ujemne dane, zerowe procenty).

    @BeforeClass
    public static void initCalculateProfitOfBankDeposit(){
        profitBankDepositCalculator = new ProfitBankDepositCalculator();
    }

    @Test
    public void testCapitalisationInterestOfDepositWithTwoPositivesAfterComa(){

        BigDecimal interestRate = new BigDecimal("6");
        Integer numberOfYears = 1;
        Integer capitalisationCount = 12;
        BigDecimal deposit = new BigDecimal("1000");

        BigDecimal result = profitBankDepositCalculator.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(setScale(1061.68), result);
    }

    @Test
    public void testCapitalisationInterestOfDepositWithOnePositiveAfterComa(){

        BigDecimal interestRate = new BigDecimal("6");
        Integer numberOfYears = 1;
        Integer capitalisationCount = 2;
        BigDecimal deposit = new BigDecimal("1000");

        BigDecimal result = profitBankDepositCalculator.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(setScale(1060.90), result);
    }

    @Test
    public void testCapitalisationInterestOfDepositWithZeroesAfterComa(){

        BigDecimal interestRate = new BigDecimal("4");
        Integer numberOfYears = 1;
        Integer capitalisationCount = 1;
        BigDecimal deposit = new BigDecimal("1000");

        BigDecimal result = profitBankDepositCalculator.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(setScale(1040.00), result);
    }

    private BigDecimal setScale(double v) {
        return BigDecimal.valueOf(v).setScale(2, RoundingMode.CEILING);
    }
}
