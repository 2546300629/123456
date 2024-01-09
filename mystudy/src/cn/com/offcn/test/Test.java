package cn.com.offcn.test;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        String[] matrix = {">>v",">>v","^<<"};
        int[] start = {0, 0}, end = {1, 1};
        conveyorBelt(matrix, start, end);
    }

    public static int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int count = 0;
        while (start[0] != end[0] || start[1] != end[1]) {
            String startRow = matrix[start[0]]; //  获取起点行
            String way = startRow.substring(start[1], start[1] + 1);
            switch (way) {
                case ">":
                    start[1] = ++start[1];
                    break;
                case "<":
                    start[1] = --start[1];
                    break;
                case "v":
                    if (end[0] > start[0]) {
                        start[0] = ++start[0];
                    } else if (end[1] < start[1]) {
                        count++;
                        start[1] = --start[1];
                    } else if (end[1] > start[1]) {
                        count++;
                        start[1] = ++start[1];
                    } else if (end[0] < start[0]) {
                        count++;
                        start[0] = --start[0];
                    }
                    break;
                case "^":
                    if (end[0] < start[0]) {
                        start[0] = --start[0];
                    } else if (end[1] < start[1]) {
                        count++;
                        start[1] = --start[1];
                    } else if (end[1] > start[1]) {
                        count++;
                        start[1] = ++start[1];
                    } else if (end[0] > start[0]) {
                        count++;
                        start[0] = --start[0];
                    }
                    break;
            }
        }
        System.out.println(count);
        return 0;
    }
}
