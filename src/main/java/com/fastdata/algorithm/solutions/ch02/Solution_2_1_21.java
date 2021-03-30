package com.fastdata.algorithm.solutions.ch02;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.Transaction;

/**
 * @Author: Lucky
 * @Description: Comparable transactions
 * Using our code for Date (page 247) as a model, expand your implementation of Transaction (Exercise 1.2.13) so that it implements
 * Comparable, such that transactions are kept in order by amount.
 * @Date: create in 3/30/21 - 12:20 PM
 */
public class Solution_2_1_21 implements Comparable<Transaction> {

    private final String who;
    private final Date when;
    private final double amount;

    public Solution_2_1_21(String who, Date when, double amount) {
        this.who = who;
        this.when = when;
        this.amount = amount;
    }

    public String who() {
        return who;
    }

    public Date when() {
        return when;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Solution_2_1_21{" +
                "who='" + who + '\'' +
                ", when=" + when +
                ", amount=" + amount +
                '}';
    }

    @Override
    public int compareTo(Transaction o) {
        if (this.amount > o.amount()) {
            return 1;
        } else if (this.amount < o.amount()) {
            return -1;
        } else {
            return 0;
        }
    }
}
