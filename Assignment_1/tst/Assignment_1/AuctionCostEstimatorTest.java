package Assignment_1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * These are the test cases for the AuctionCostEstimator
 * 
 * @author dputnam3
 * @see AuctionCostEstimator
 */
public class AuctionCostEstimatorTest {

	@Test
	public void testPositiveBid() {
		AuctionCostEstimator ace = new AuctionCostEstimator();
		double[] actual = ace.calculateCosts(100.0);
		double[] expected = new double[] { 10.0, 5.5 }; 
		assertArrayEquals("testBid", expected, actual, 0.001);
	}

	@Test
	public void testNegativeBid() {
		AuctionCostEstimator ace = new AuctionCostEstimator();
		double[] actual = ace.calculateCosts(-100.0);
		double[] expected = new double[] { -10.0, -5.5 }; 
		assertArrayEquals("testBid", expected, actual, 0.001);
	}

	@Test
	public void testBigBid() {
		AuctionCostEstimator ace = new AuctionCostEstimator();
		double[] actual = ace.calculateCosts(10000000000.0);
		double[] expected = new double[] { 1000000000.0, 550000000.0 }; 
		assertArrayEquals("testBid", expected, actual, 100);
	}

	@Test
	public void testZeroBid() {
		AuctionCostEstimator ace = new AuctionCostEstimator();
		double[] actual = ace.calculateCosts(0.0);
		double[] expected = new double[] { 0.0, 0.0 }; 
		assertArrayEquals("testBid", expected, actual, 0.001);
	}

}
