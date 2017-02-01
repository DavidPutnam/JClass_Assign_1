package Assignment_1;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

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
 * @version 1.0
 * @since 2017-01-30
 *
 */
public class AuctionCostEstimator {

    private static final double COMMISSION_PCT = 0.10;
    private static final double SALES_TAX_PCT = 0.05;

    /**
     * The main program does not utilize any arguments.
     * 
     * @param args
     *            None used The program will prompt for a number (bid) and will
     *            calculate commission and sales tax based on that bid
     */
    public static void main(String[] args) {
        final AuctionCostEstimator auctionCostEstimater = new AuctionCostEstimator();
        final Scanner scanner = new Scanner(System.in);

        try {
            // enter the bid
            final double bid = promptForAndReadBid(scanner);
            // calculate all costs
            final double[] costs = auctionCostEstimater.calculateCosts(bid);
            // print the total cost report
            printTotalCostReport(bid, costs);
        } catch (InputMismatchException e) {
            System.out.println("You must enter a valid number. ");
        }

        scanner.close();
        System.exit(0);
    }

    /**
     * Print a report with all the information calculated.
     * 
     * @param bid
     *            The amount bid without any extras
     * @param costs
     *            The extra costs associated with the bid
     */
    private static void printTotalCostReport(double bid, double[] costs) {
        final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.getDefault());
        System.out.println("Your bid was " + currencyFormatter.format(bid));
        System.out.println("The commission was " + currencyFormatter.format(costs[0]));
        System.out.println("The sales tax was " + currencyFormatter.format(costs[1]));
        System.out.println("Your total is " + currencyFormatter.format(bid + costs[0] + costs[1]));
    }

    /**
     * Print the prompt on the line and read the entered bid as a floating point
     * number
     * 
     * @param scanner
     *            The scanner to use to get input from
     * @return the entered bid
     */
    private static double promptForAndReadBid(Scanner scanner) {
        System.out.print("How much did you bid: ");
        double bid = scanner.nextDouble();
        return bid;
    }

    /**
     * For the given bid calculate the commission and sales tax.
     * 
     * @param bid
     *            The amount bid without any extras
     * @return The extra costs associated with that bid
     */
    public double[] calculateCosts(double bid) {
        double[] costs = new double[2];
        costs[0] = bid * COMMISSION_PCT;
        costs[1] = (bid + costs[0]) * SALES_TAX_PCT;
        return costs;
    }
}
