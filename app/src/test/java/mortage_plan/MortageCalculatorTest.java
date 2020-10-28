package mortage_plan;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MortageCalculatorTest {
    @Test
    public void TestPow() {
        double errorDelta = 0.0000001;
        assertEquals("10^5 should be 100 000", 100000.0, MortageCalculator.pow(10, 5), errorDelta);
        assertEquals("84^3 should be 592 704", 592704.0, MortageCalculator.pow(84, 3), errorDelta);
        assertEquals("34^7 should be 52 523 350 144", 52523350144.0, MortageCalculator.pow(34, 7), errorDelta);
    }
}
