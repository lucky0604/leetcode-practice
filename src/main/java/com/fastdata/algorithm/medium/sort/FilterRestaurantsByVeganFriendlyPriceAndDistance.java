package com.fastdata.algorithm.medium.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Lucky
 * @Description: https://leetcode.com/problems/filter-restaurants-by-vegan-friendly-price-and-distance/
 * @Date: create in 3/25/21 - 11:49 AM
 */
// TODO: to be understand
public class FilterRestaurantsByVeganFriendlyPriceAndDistance {

    class RestaurantNode {
        int[] val;
        RestaurantNode next = null;
        public RestaurantNode(int[] val) {
            this.val = val;
        }
    }

    RestaurantNode head = new RestaurantNode(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE});

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        List<Integer> res = new ArrayList<>();
        for (int[] restaurant: restaurants) {
            if (veganFriendly == 1) {
                if (restaurant[2] == 1 && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    RestaurantNode tmp = new RestaurantNode(restaurant);
                    insertNode(tmp);
                }
            } else {
                if (restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                    RestaurantNode tmp = new RestaurantNode(restaurant);
                    insertNode(tmp);
                }
            }
        }
        while (head.next != null) {
            head = head.next;
            res.add(head.val[0]);
        }
        return res;
    }

    private void insertNode(RestaurantNode node) {
        RestaurantNode pH = head;
        while (pH.next != null) {
            if (pH.next.val[1] <= node.val[1]) {
                if (pH.next.val[1] == node.val[1] && pH.next.val[0] > node.val[0]) {
                    pH = pH.next;
                    break;
                }
                break;
            }
            pH = pH.next;
        }
        RestaurantNode tmp = pH.next;
        pH.next = node;
        node.next = tmp;
    }
}
