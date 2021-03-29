package main.Sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Exec56MergeInterVals {

    @Test
    public void test() {
        int[][] test1 = new int[][]{{3,4},{2,6},{8,10},{15,18}};
        System.out.println(merge(test1));
    }

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        int left = 0, right = 1;
        int start = intervals[0][0], end = intervals[0][1];
        List<int[]> merge = new ArrayList<>();
        while (left < right && right < len) {
            if (end >= intervals[right][0]) {
                end = Math.max(end,intervals[right][1]);
            } else {
                merge.add(new int[]{start,end});
                left = right;
                start = intervals[left][0];
                end = intervals[left][1];
            }
            right++;
        }
        merge.add(new int[]{start,end});
        return merge.toArray(new int[merge.size()][2]);
    }
}
