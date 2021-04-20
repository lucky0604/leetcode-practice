package com.fastdata.algorithm.solutions.ch02.section02;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucky
 * @Description
 * @Filename Solution_2_2_21_Test
 * @create 2021-04-20 上午11:41
 */

public class Solution_2_2_21_Test {

    @Test
    public void test() {
        List<List<String>> names1 = generateNames1();
        String name1 = Solution_2_2_21.checkIfThereAreCommonNames(names1);
        assertEquals("Zord", name1);

        List<List<String>> names2 = generateNames2();
        String name2 = Solution_2_2_21.checkIfThereAreCommonNames(names2);
        assertEquals(null, name2);
    }

    private static List<List<String>> generateNames1() {
        List<String> namesList1 = new ArrayList<>();
        namesList1.add("Sedgewick");
        namesList1.add("Zord");
        namesList1.add("Bill");
        namesList1.add("Rene");

        List<String> namesList2 = new ArrayList<>();
        namesList2.add("Zord");
        namesList2.add("Wayne");
        namesList2.add("Rene");
        namesList2.add("Larry");

        List<String> namesList3 = new ArrayList<>();
        namesList3.add("Rene");
        namesList3.add("Sergey");
        namesList3.add("Zord");
        namesList3.add("Elon");

        List<List<String>> names = new ArrayList<>();
        names.add(namesList1);
        names.add(namesList2);
        names.add(namesList3);

        return names;
    }

    private static List<List<String>> generateNames2() {
        List<String> namesList1 = new ArrayList<>();
        namesList1.add("Name1");
        namesList1.add("Name4");
        namesList1.add("Name3");
        namesList1.add("Name2");

        List<String> namesList2 = new ArrayList<>();
        namesList2.add("Name5");
        namesList2.add("Name8");
        namesList2.add("Name6");
        namesList2.add("Name7");

        List<String> namesList3 = new ArrayList<>();
        namesList3.add("Name1");
        namesList3.add("Name5");
        namesList3.add("Name2");
        namesList3.add("Name9");

        List<List<String>> names = new ArrayList<>();
        names.add(namesList1);
        names.add(namesList2);
        names.add(namesList3);

        return names;
    }
}
