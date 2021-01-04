package leetcode.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);
        for (int[] ar : res) {
            System.out.println(ar[0]+" "+ar[1]);
        }
    }

    private static int[][] merge(int[][] intervals) {
        int i = 0;
        //Sort on start times
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        List<int[]> res = new ArrayList();
        int start = 0;
        while (i < intervals.length) {
            int[] cur = intervals[i];
            start = cur[0];
            int end = cur[1];


            while (i < intervals.length - 1 && end >= intervals[i + 1][0]) {
                end = end > intervals[i + 1][1] ? end : intervals[i + 1][1];
                i++;
            }
            res.add(new int[]{start, Math.max(end, intervals[i][1])});
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}
