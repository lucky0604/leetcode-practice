package com.fastdata.algorithm.solutions.ch02.section04;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import javafx.scene.paint.Stop;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 6/8/21 1:11 PM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_4_28 {

    private class Point implements Comparable<Point> {
        double x, y, z;
        Point(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Point other) {
            // distance to 0, 0 (origin)
            double euclideanDistance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
            double otherPointEuclideanDistance = Math.sqrt(Math.pow(other.x, 2) + Math.pow(other.y, x) + Math.pow(other.z, 2));
            if (euclideanDistance < otherPointEuclideanDistance) {
                return -1;
            } else if (euclideanDistance > otherPointEuclideanDistance) {
                return 1;
            } else {
                return 0;
            }
        }

        @Override
        public String toString() {
            return "x = " + x + " y = " + y + " z = " + z;
        }
    }

    private static Stack<Point> reversePointsOrder(PriorityQueue<Point> priorityQueue) {
        Stack<Point> stack = new Stack<>();
        while (priorityQueue.size() > 0) {
            stack.push(priorityQueue.deleteTop());
        }
        return stack;
    }

    private static void printPoints(Stack<Point> pointsStack) {
        while (pointsStack.size() > 0) {
            StdOut.println(pointsStack.pop());
        }
    }

    private static void doExperimentToEstimateRunningTime(int arraySize, int numberOfExperiments) {
        int m = 10000;    // 10^4

        for (int i = 0; i < numberOfExperiments; i ++) {
            PriorityQueue<Point> priorityQueue = new PriorityQueue<>(m + 1, PriorityQueue.Orientation.MAX);
            Point[] pointArr = generateRandomPointsArray(arraySize);
            Stopwatch timer = new Stopwatch();

            for (Point point: pointArr) {
                priorityQueue.insert(point);
                if (priorityQueue.size() > m) {
                    priorityQueue.deleteTop();
                }
            }

            Stack<Point> pointsStack = reversePointsOrder(priorityQueue);
            printPoints(pointsStack);

            double runnintTime = timer.elapsedTime();
            StdOut.println("Running time for N = " + arraySize + " and M = " + m + ": " + runnintTime);
            arraySize *= 10;
        }
    }

    private static Point[] generateRandomPointsArray(int length) {
        Point[] array = new Point[length];

        for (int i = 0; i < length; i ++) {
            double x = StdRandom.uniform();
            double y = StdRandom.uniform();
            double z = StdRandom.uniform();

            Point point = new Solution_2_4_28().new Point(x, y, z);
            array[i] = point;
        }

        return array;
    }
}
