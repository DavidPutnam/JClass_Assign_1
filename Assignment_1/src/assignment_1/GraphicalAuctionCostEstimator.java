package assignment_1;

import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

/**
 * <h1>Assignment 1 - Auction Cost Estimator</h1>
 * 
 * <p>
 * This is the first one for this class. The material is based on Chapter 2,
 * which we will be discussing in class for the next few sessions. Here's what I
 * want done: This program will use keyboard input, and console output, using
 * the scanner class for input, and println for output. The purpose of the
 * program is to help me figure out the actual cost of an item if I bid at a
 * local auction. When I bid on an item, and win it, the auction house promptly
 * adds 10% to my winning bid as their commission. Then, after that, they add
 * another 5% for sales tax. I then want it to print out my original bid, the
 * amount of commission, and the amount of sales tax. Then print out the total.
 * An example would look like: (I underlined the part I entered)
 * 
 * <pre>
 * 	How much did you bid: <span style="text-decoration: underline;">100</span>
 * 	Your bid was $100.00
 * 	The commission was $10.00
 * 	The sales tax was $5.50
 * 	Your total is $115.50
 * </pre>
 * 
 * When you enter your program, make sure you put comments in there to show your
 * name, the assignment number, the date, and a brief summary of the program.
 * <p>
 * When you have it working, all you need to do is to copy the source file into
 * a text file, and submit it to Blackboard. Due date is Thursday, February 9th,
 * by the end of the day (midnight).
 * 
 * @author dputnam3 "David Putnam"
 * @version 2.0
 *
 */
public class GraphicalAuctionCostEstimator {

    /**
     * The main program does not utilize any arguments.
     * 
     * @param args
     *            None used The program will prompt for a number (bid) and will
     *            calculate commission and sales tax based on that bid
     */
    public static void main(String[] args) {

        try {
            // enter the bid
            final double bid = promptForAndReadBid();
            // create the cost calculator
            final CostCalculator costCalculator = new CostCalculator(bid);
            // print the cost report
            printTotalCostReport(bid, costCalculator.getCommission(), costCalculator.getSalesTax());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a valid number.");
        }

        System.exit(0);
    }

    /**
     * Print the prompt on the line and read the entered bid as a floating point
     * number to be returned
     * 
     * @return the entered bid
     */
    private static double promptForAndReadBid() {
        final String bidString = JOptionPane.showInputDialog(null, "How much did you bid:");
        double bid = Double.parseDouble(bidString);
        return bid;
    }

    /**
     * Print a report with all the information calculated.
     * 
     * @param bid
     * @param commission
     * @param salesTax
     * @param total
     */
    private static void printTotalCostReport(double bid, double commission, double salesTax) {
        final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());

        String report = "Your bid was " + currencyFormatter.format(bid) + "\n" + "The commission was "
                + currencyFormatter.format(commission) + "\n" + "The sales tax was "
                + currencyFormatter.format(salesTax) + "\n" + "Your total is "
                + currencyFormatter.format(bid + commission + salesTax) + "\n";

        JOptionPane.showMessageDialog(null, report);
    }
}
