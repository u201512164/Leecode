package main.List;

import org.junit.Test;

import java.util.*;

public class Exec15ThreeNumberSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        Set<List<Integer>> list = new HashSet<>();
        for (int i=0; i<len; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i>0 && nums[i] == nums[i-1]) {
                continue;
            }
            int left = i+1;
            int right = len-1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if ( sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    list.add(temp);
                    right--;
                    left++;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.addAll(list);
        return result;
    }

    @Test
    public void test() {
        int[] test1 = new int[]{-1,0,1,2,-1,-4};
        System.out.println(threeSum(test1));
    }
}
