package com.fastdata.algorithm.solutions.ch02.section02;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * @ClassName: Solution_2_2_14
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/13/21 12:46 PM
 */

public class Solution_2_2_14 {

    public static void main(String[] args) {
        Queue<Comparable> q1 = new Queue<>();
        q1.enqueue(1);
        q1.enqueue(3);
        q1.enqueue(5);
        q1.enqueue(6);
        q1.enqueue(9);
        Queue<Comparable> q2 = new Queue<>();
        q2.enqueue(2);
        q2.enqueue(4);
        q2.enqueue(6);
        q2.enqueue(8);
        q2.enqueue(12);
        Queue<Comparable> ret = mergedQueue(q1, q2);
        for (Comparable item : ret) {
            StdOut.println(item);
        }

    }

    private static Queue<Comparable> mergedQueue(Queue<Comparable> q1, Queue<Comparable> q2) {
        Queue<Comparable> ret = new Queue<>();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.peek().compareTo(q2.peek()) <= 0) {
                ret.enqueue(q1.dequeue());
            } else {
                ret.enqueue(q2.dequeue());
            }
        }

        while (!q1.isEmpty()) {
            ret.enqueue(q1.dequeue());
        }
        while (!q2.isEmpty()) {
            ret.enqueue(q2.dequeue());
        }
        return ret;
    }
}
