package com.fastdata.algorithm.utils;

import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: ArrayGenerator
 * @Description: TODO
 * @Create by: lucky
 * @Date: 4/14/21 1:13 PM
 */

public class ArrayGenerator {
    public static Map<Integer, Comparable[]> generateAllArrays(int numberOfExperiments, int initialArraySize, int multiplier) {
        Map<Integer, Comparable[]> allArrays = new HashMap<>();
        int arraySize = initialArraySize;

        for (int i = 0; i < numberOfExperiments; i ++) {
            Comparable[] arr = generateRandomArray(arraySize);
            allArrays.put(i, arr);
            arraySize *= multiplier;
        }
        return allArrays;

    }

    public static Comparable[] generateRandomArray(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = StdRandom.uniform();
        }
        return arr;
    }

    public static int[] generateRandomIntegerArray(int length, int lowerBoundInclusive, int upperBoundExclusive) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = StdRandom.uniform(lowerBoundInclusive, upperBoundExclusive);
        }
        return arr;
    }

    public static int[] generateRandomIntegerArray(int length, int upperBoundExclusive) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = StdRandom.uniform(upperBoundExclusive);
        }
        return arr;
    }

    public static String[] generateRandomStringArray(int length, int minStringLength, int maxStringLength) {
        String[] arr = new String[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = generateRandomString(minStringLength, maxStringLength);
        }
        return arr;
    }

    public static String generateRandomString(int minStringLength, int maxStringLength) {
        StringBuilder sb = new StringBuilder();
        int stringSize = StdRandom.uniform(minStringLength, maxStringLength + 1);
        for (int i = 0; i < stringSize; i ++) {
            char randomChar = (char) StdRandom.uniform(Constants.ASC_II_UPPERCASE_LETTERS_INITIAL_INDEX, Constants.ASC_II_UPPERCASE_LETTERS_FINAL_INDEX + 1);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String generateRandomStringOfSpecifiedLength(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            char randomChar = (char) StdRandom.uniform(Constants.ASC_II_UPPERCASE_LETTERS_INITIAL_INDEX, Constants.ASC_II_LOWERCASE_LETTERS_FINAL_INDEX + 1);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static String generateRandomStringOfSpecifiedLengthAllCharacters(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i ++) {
            char randomChar = (char) StdRandom.uniform(256);
            sb.append(randomChar);
        }
        return sb.toString();
    }

    public static char[] generateRandomUniqueUppercaseChars(int numberOfChars) {
        char[] chars = new char[numberOfChars];
        int charsIndex = 0;
        Set<Character> generatedChars = new HashSet<>();

        while(charsIndex < chars.length) {
            int randomUppercaseCharIntValue = StdRandom.uniform(Constants.ASC_II_UPPERCASE_LETTERS_INITIAL_INDEX, Constants.ASC_II_UPPERCASE_LETTERS_FINAL_INDEX);
            char generateChar = (char) randomUppercaseCharIntValue;
            if (generatedChars.contains(generateChar)) {
                chars[charsIndex ++] = generateChar;
                generatedChars.add(generateChar);
            }
        }
        return chars;
    }

    public static Comparable[] generatedOrderedArray(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generatedIntOrderedArray(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Comparable[] generatedReverseOrderedArray(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = length - 1 - i;
        }
        return arr;
    }

    public static Comparable[] generateArrayWithAllKeysEqual(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = 0;
        }
        return arr;
    }

    public static Comparable[] generateDistinctValuesShuffledArray(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = i;
        }
        StdRandom.shuffle(arr);
        return arr;
    }

    public static Comparable[] generateRandomArrayWith2Values(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = StdRandom.uniform(2);
        }
        return arr;
    }

    public static Comparable[] generateRandomArrayWith3Values(int length) {
        Comparable[] arr = new Comparable[length];
        for (int i = 0; i < length; i ++) {
            arr[i] = StdRandom.uniform(3);
        }
        return arr;
    }
}
