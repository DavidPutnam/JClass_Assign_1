package assignment_1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import assignment_1.CommandAuctionCostEstimator;
import assignment_1.CostCalculator;

/**
 * These are the test cases for the CostCalculation
 * 
 * @author dputnam3
 * @see CommandAuctionCostEstimator
 */
public class CostCalculatorTest {

    @Test
    public void testPositiveBid() {
        CostCalculator cc = new CostCalculator(100.0);
        assertEquals("Commission", 10.0, cc.getCommission(), 0.001);
        assertEquals("Sales Tax", 5.5, cc.getSalesTax(), 0.001);
    }

    @Test
    public void testNegativeBid() {
        CostCalculator cc = new CostCalculator(-100.0);
        assertEquals("Commission", -10.0, cc.getCommission(), 0.001);
        assertEquals("Sales Tax", -5.5, cc.getSalesTax(), 0.001);
    }

    @Test
    public void testBigBid() {
        CostCalculator cc = new CostCalculator(1E10);
        assertEquals("Commission", 1E9, cc.getCommission(), 0.001);
        assertEquals("Sales Tax", 5.5E8, cc.getSalesTax(), 0.001);
    }

    @Test
    public void testZeroBid() {
        CostCalculator cc = new CostCalculator(0.0);
        assertEquals("Commission", 0.0, cc.getCommission(), 0.001);
        assertEquals("Sales Tax", 0.0, cc.getSalesTax(), 0.001);
    }
}
