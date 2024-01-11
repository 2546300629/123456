package org.example;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {-1, -2, -3, -4, -5};
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        ListNode listNode = main.addTwoNumbers(l1, l2);
    }

    public ListNode loop(ListNode l) {
        while (true) {
            if (l.next == null) {
                return l;
            }
            l = l.next;
        }

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int b = 0;
        while (true) {
            int i = l1.val + l2.val;
            if (head == null) { //  第一次循环
                head = new ListNode(i % 10);
                b = i / 10;
            } else {
                if (tail == null) {
                    tail = new ListNode(i % 10 + b);
                    head.next = tail;
                } else {
                    tail.next = new ListNode(i % 10 + b);
                    tail = tail.next;
                }
                b = i / 10;
            }
            if (l1.next == null && l2.next == null) break;
            if (l1.next != null) l1 = l1.next;
            if (l2.next != null) l2 = l2.next;
        }
        return head;
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int another = target - nums[i];
            if (map.containsKey(another)) {
                return new int[]{i, map.get(another)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    //    提供一个数组arr，和要删除的数字数量k,求arr删除k个元素之后数组中最好能剩几种数字？
    public void removeArray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i : arr) {
            Integer j = map.getOrDefault(i, 0) + 1;
            map.put(i, j);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o1.getValue() - o2.getValue()));
        int i = list.size();
        for (Map.Entry<String, Integer> m : list) {
            int occ = m.getValue();
            if (k >= occ) {
                --i;
                k -= occ;
            } else {
                break;
            }
        }

    }
}