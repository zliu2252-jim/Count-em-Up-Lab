package org.example;

import java.text.NumberFormat;

/**
 * A simple 4-digit grocery counter that tracks dollars and cents
 * in the range 0000–9999 (¢), wraps on overflow,
 * and counts how many times it wrapped.
 */
public class GroceryCounter {
    // current count in cents
    int cents;
    // Number of times the counter has wrapped
    int overflowCount;

    //Initialize to 0000
    public GroceryCounter() {
        this.cents = 0;
        this.overflowCount = 0;
    }

    /**
     * Increment the tens digit.
     * Wrap and count overflow if exceeding 9999.
     */
    public void tens() {
        int newTotal = cents + 1000;
        if (newTotal > 9999) {
            overflowCount++;
            cents = newTotal - 10000;
        } else {
            cents = newTotal;
        }
    }

    /**
     * Increment the “ones” digit.
     * Wrap and count overflow.
     */
    public void ones() {
        int newTotal = cents + 100;
        if (newTotal > 9999) {
            overflowCount++;
            cents = newTotal - 10000;
        } else {
            cents = newTotal;
        }
    }

    /**
     * Increment the “tenths” digit.
     * Wrap and record overflow.
     */
    public void tenths() {
        int newTotal = cents + 10;
        if (newTotal > 9999) {
            overflowCount++;
            cents = newTotal - 10000;
        } else {
            cents = newTotal;
        }
    }

    /**
     * Increment the “hundredths” digit.
     * Wrap and count overflow when exceeding maximum.
     */
    public void hundreths() {
        int newTotal = cents + 1;
        if (newTotal > 9999) {
            overflowCount++;
            cents = newTotal - 10000;
        } else {
            cents = newTotal;
        }
    }

    /**
     * Returns the current amount formatted as dollars, cents.
     *
     * @return formatted dollar string
     */
    public String total() {
        double dollarAmount = cents / 100.0;
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        return currencyFormatter.format(dollarAmount);
    }

    /**
     * How many times the counter has wrapped past 9999.
     *
     * @return overflow count
     */
    public int overflows() {
        return overflowCount;
    }

    /**
     * Reset to $0.00 and clear the overflow.
     */
    public void clear() {
        cents = 0;
        overflowCount = 0;
    }
}
