package com.fastdata.algorithm.solutions.ch02.section03;



import com.fastdata.algorithm.solutions.ch02.section01.InsertionSort;
import com.fastdata.algorithm.utils.ArrayGenerator;
import com.fastdata.algorithm.utils.ArrayUtil;
import com.fastdata.algorithm.utils.StatsUtils;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lucky
 * @License: (C) Copyright
 * @Contact: lucky_soft@163.com
 * @Date: 5/14/21 11:36 AM
 * @Version: 1.0
 * @Description:
 **/

public class Solution_2_3_26 {

    private final static int NUMBER_OF_BUCKETS = 10;
    private final static int RANGE_OF_SIZES_PER_BUCKET = 5;
    private static final String SUBARRAY_SIZES = "SubArray sizes";
    private static final String FREQUENCY = "Frequency";

    public static void main(String[] args) {
        int arraySize = 100000;

        Comparable[] array = ArrayGenerator.generateRandomArray(arraySize);
        new Solution_2_3_26().doExperiment(array);
    }

    private void doExperiment(Comparable[] originalArray) {

        int[] cutoffSizes = {10, 20, 50};

        List<double[]> allSubArraySizes = new ArrayList<>();

        for(int cutoffSize : cutoffSizes) {

            Comparable[] array = new Comparable[originalArray.length];
            System.arraycopy(originalArray, 0, array, 0, originalArray.length);

            double[] subArraySizesHistogram = new double[NUMBER_OF_BUCKETS];
            quickSortWithCutoff(array, cutoffSize, subArraySizesHistogram);

            allSubArraySizes.add(subArraySizesHistogram);
        }

        for(int i = 0; i < cutoffSizes.length; i++) {
            histogram(allSubArraySizes.get(i), cutoffSizes[i]);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i != cutoffSizes.length - 1) {
                StdDraw.clear();
            }
        }
    }

    private void quickSortWithCutoff(Comparable[] array, int cutoffSize, double[] subArraySizesHistogram) {
        StdRandom.shuffle(array);
        quickSort(array, 0, array.length - 1, cutoffSize, subArraySizesHistogram);
    }

    private void quickSort(Comparable[] array, int low, int high, int cutoffSize, double[] subArraySizesHistogram) {
        if (low >= high) {
            return;
        }
        int subArraySize = high - low + 1;

        if (subArraySize < cutoffSize) {
            int bucketId = getBucketId(subArraySize);
            subArraySizesHistogram[bucketId] ++;
            InsertionSort.insertionSort(array, low, high);
            return;
        }
    }

    private int partition(Comparable[] array, int low, int high) {
        Comparable pivot = array[low];

        int i = low;
        int j = high + 1;

        while (true) {
            while (ArrayUtil.less(array[++ i], pivot)) {
                if (i == high) {
                    break;
                }
            }
            while (ArrayUtil.less(pivot, array[-- j])) {
                if (j == low) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            ArrayUtil.exchange(array, i, j);
        }

        // place pivot in the right place
        ArrayUtil.exchange(array, low, j);
        return j;
    }

    private int getBucketId(int value) {
        return value / RANGE_OF_SIZES_PER_BUCKET;
    }

    private void histogram(double[] subArraySizesHistogram, int cutoff) {
        double maxCount = 0;
        for (int i = 0; i < subArraySizesHistogram.length; i ++) {
            if (subArraySizesHistogram[i] > maxCount) {
                maxCount = subArraySizesHistogram[i];
            }
        }

        StdDraw.setCanvasSize(1024, 512);

        double minX = -1.5;
        double maxX = 10;
        double midX = minX + (maxX - minX) / 2;
        double minY = -700;
        double maxY = maxCount + 200;
        double midY = minY + (maxY - minY) / 2;
        String fontName = "Verdana";

        StdDraw.setXscale(minX, maxX);
        StdDraw.setYscale(minY, maxY);

        int buckets = 10;
        String[] subarraySizeDescriptions = getBucketDescription(buckets);

        // Labels
        Font titlesFont = new Font(fontName, Font.PLAIN, 14);
        StdDraw.setFont(titlesFont);

        double yPositionForXLabels = 0;

        if (cutoff != 50) {
            if (cutoff == 10) {
                StdDraw.text(midX, -500, SUBARRAY_SIZES);
                yPositionForXLabels = -180;
            } else if (cutoff == 20) {
                StdDraw.text(midX, -250, SUBARRAY_SIZES);
                yPositionForXLabels = -80;
            }
            StdDraw.text(minX + 0.5, midY, FREQUENCY, 90);
            StdDraw.text(midX, maxCount, "Cutoff: " + cutoff);
        } else {
            StdDraw.text(minX + 0.5, maxY - 400, FREQUENCY, 90);
            StdDraw.text(midX, -120, SUBARRAY_SIZES);
            StdDraw.text(midX, maxCount + 100, "Cutoff: " + cutoff);
            yPositionForXLabels = -50;
        }

        Font graphLabelsFont = new Font(fontName, Font.PLAIN, 10);
        StdDraw.setFont(graphLabelsFont);

        // Y labels
        if (cutoff == 10) {
            for (int y = 0; y <= maxCount; y += 250) {
                StdDraw.text(-0.5, y, String.valueOf(y));
            }
        } else {
            for (int y = 0; y <= maxCount; y += 100) {
                StdDraw.text(-0.5, y, String.valueOf(y));
            }
        }

        // X labels
        for (int x = 0; x < subArraySizesHistogram.length; x ++) {
            StdDraw.text(x, yPositionForXLabels, subarraySizeDescriptions[x]);
        }

        StatsUtils.plotBars(subArraySizesHistogram, 0.25);
    }

    private String[] getBucketDescription(int buckets) {
        String[] bucketDescriptions = new String[buckets];

        for (int i = 0; i < buckets; i ++) {
            int minSize = RANGE_OF_SIZES_PER_BUCKET * i;
            int maxSize = minSize + RANGE_OF_SIZES_PER_BUCKET - 1;
            bucketDescriptions[i] = String.format("[%2d - %2d]", minSize, maxSize);
        }
        return bucketDescriptions;
    }
}
