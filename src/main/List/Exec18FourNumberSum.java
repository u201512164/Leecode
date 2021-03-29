package main.List;

import org.junit.Test;

import java.util.*;

public class Exec18FourNumberSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0; i<len; i++) {
            for (int j=i+1; j<len; j++) {
                int left = j+1;
                int right = len-1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        set.add(temp);
                        right--;
                        left++;
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(set);
        return result;
    }

    @Test
    public void test() {
        int[] test1 = new int[]{1,0,-1,0,-2,2};
        int target1 = 0;
        System.out.println(fourSum(test1,target1));
    }
}
