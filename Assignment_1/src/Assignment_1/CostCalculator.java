package Assignment_1;

/**
 * CostCalculator provides the mathematics behind the estimation process
 * 
 * @author dputnam3 "David Putnam"
 * @version 1.0
 *
 */
public class CostCalculator {
    private static final double COMMISSION_PCT = 0.10;
    private static final double SALES_TAX_PCT = 0.05;

    private final double commission;
    private final double salesTax;

    @SuppressWarnings("unused")
    private CostCalculator() {
        this.commission = 0;
        this.salesTax = 0;
    }

    /**
     * CostCalculation
     * 
     * @param bid
     *            The amount bid
     */
    public CostCalculator(double bid) {
        this.commission = bid * COMMISSION_PCT;
        this.salesTax = (bid + this.commission) * SALES_TAX_PCT;
    }

    /**
     * getCommission
     * 
     * @return double - commission expected for the bid
     */
    public double getCommission() {
        return commission;
    }

    /**
     * getSalesTax
     * 
     * @return double - sales tax expected for the bid
     */
    public double getSalesTax() {
        return salesTax;
    }
}
