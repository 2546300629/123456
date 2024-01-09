package org.example;

import org.apache.commons.collections4.MapUtils;
import org.junit.Test;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = {-1,-2,-3,-4,-5};
        main.twoSum(nums, -8);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (target>0? nums[i] <= target:nums[i] >= target) {
                for (int j = nums.length-1; j >= 0; j--) {
                    if (nums[i] + nums[j] == target && i != j) {
                        arr[0] = i;
                        arr[1] = j;
                        break;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
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