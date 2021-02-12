package com.fastdata.algorithm.easy.hashtable;

import java.util.*;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/employee-importance/
 * @Date: created in 2021/2/12 - 12:52
 */
public class EmployeeImportance {

    public static void main(String[] args) {
        int[] arr = new int[]{};
        System.out.println(String.valueOf(arr).toString());
    }

    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        LinkedList<Employee> queue = new LinkedList<>();
        ArrayList<Integer> employeeVisited = new ArrayList<>();

        // mapping the employees infor mation to their ID
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
            map.put(e.id, e);
        }

        // pushing the employee with the given id
        queue.addLast(map.get(id));
        // marking the employee visited
        employeeVisited.add(id);

        while (queue.size() != 0) {
            int size = queue.size();
            // for every level
            while (size -- > 0) {
                Employee e = queue.removeFirst();
                // summing up the importance for the employees
                sum += e.importance;
                for (Integer i: e.subordinates) {
                    Employee ie = map.get(i);
                    // add subordiates only if they are not already visited
                    if (employeeVisited.contains(i) == false) {
                        queue.addLast(ie);
                        employeeVisited.add(i);
                    }
                }
            }
        }
        return sum;
    }
}


class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}