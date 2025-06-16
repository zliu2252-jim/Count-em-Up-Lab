package org.example;

/**
 * GroceryCounterApp demonstrates usage of the GroceryCounter class by performing
 * a series of counter operations and printing the resulting total and overflow counts.
 */
public class GroceryCounterApp {

    /**
     * Performs manual tests on GroceryCounter methods, printing the counter's total
     * and overflow counts after each set of operations.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        //Create the new GroceryCounter
        GroceryCounter counter = new GroceryCounter();

        // Initial state
        System.out.println(counter.total());

        // Increment tens digit twice and hundredths once
        counter.tens();
        counter.tens();
        counter.hundreths();
        System.out.println(counter.total());
        System.out.println(counter.overflows());

        // +$1.00 thirty-five times using ones()
        for (int i = 0; i < 35; i++) {
            counter.ones();
        }
        System.out.println(counter.total());
        System.out.println(counter.overflows());

        // Add $1.00 one hundred times to trigger an overflow
        for (int i = 0; i < 100; i++) {
            counter.ones();
        }
        System.out.println(counter.total());
        System.out.println(counter.overflows());

        // Reset the counter back to zero and clear overflow count
        counter.clear();
        System.out.println(counter.total());
        System.out.println(counter.overflows());

        //Demonstrate tenths()
        counter.clear();
        counter.tenths();
        System.out.println(counter.total());
        System.out.println(counter.overflows());
    }
}