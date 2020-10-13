package bank.calculations;

import org.junit.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.Assert.*;

public class CalculateProfitOfBankDepositTest {
private static CalculateProfitOfBankDeposit calculateProfitOfBankDeposit;

    @BeforeClass
    public static void initCalculateProfitOfBankDeposit(){
        calculateProfitOfBankDeposit = new CalculateProfitOfBankDeposit();
        System.out.println("Object init.");
    }
    @Test
    public void testCapitalisationInterestOfDepositWithTwoPositivesAfterComa(){

        String interestRate = "6";
        String numberOfYears = "1";
        String capitalisationCount = "12";
        String deposit = "1000";

        BigDecimal result = calculateProfitOfBankDeposit.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(BigDecimal.valueOf(1061.68).setScale(2,RoundingMode.CEILING), result);
    }



    @Test
    public void testCapitalisationInterestOfDepositWithOnePositiveAfterComa(){

        String interestRate = "6";
        String numberOfYears = "1";
        String capitalisationCount = "2";
        String deposit = "1000";

        BigDecimal result = calculateProfitOfBankDeposit.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(BigDecimal.valueOf(1060.90).setScale(2,RoundingMode.CEILING), result);
    }

    @Test
    public void testCapitalisationInterestOfDepositWithZeroesAfterComa(){

        String interestRate = "4";
        String numberOfYears = "1";
        String capitalisationCount = "1";
        String deposit = "1000";

        BigDecimal result = calculateProfitOfBankDeposit.returnOnInvestment(interestRate,capitalisationCount,numberOfYears,deposit);

        assertEquals(BigDecimal.valueOf(1040.00).setScale(2,RoundingMode.CEILING), result);
    }
}
