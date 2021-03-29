package main.List;

import org.junit.Test;

import java.util.*;

public class Exec16NearestThreeNumberSum {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int x=0; x<len; x++) {
            for (int y=x+1; y<len; y++) {
                for (int z=y+1; z<len; z++) {
                    list.add(nums[x] + nums[y] + nums[z]);
                }
            }
        }
        System.out.println(list);
        Collections.sort(list);
        int min = list.get(0);
        if (min > target) {
            return min;
        }
        int max = list.get(list.size()-1);
        if (max < target) {
            return max;
        }
        for (int i=1; i<list.size(); i++) {
            int sum = list.get(i);
            System.out.println(sum);
            if (sum == target) {
                return sum;
            } else if (target < sum) {
                min = Math.min(sum,list.get(i-1));
                break;
            }
        }
        return min;
    }

    @Test
    public void test() {
        int[] test1 = new int[]{2,39,66,69,-5,54,-51,47,-20,82,41,-96,38,-87,-18,21,59,70,100,37,-25,8,-38,-27,75,24,69,-43,92,-55,87,-96,-34,-2,70,3,29,2,-32,58,3,56,33,-11,61,0,-40,25,-27,-73,-67,-23,-53,-62,20,-25,33,-27,-45,57,3,86,-18,-84,-4,-74,-99,67,-54,-70,-14,29,-41,-80,28,24,59,75,-52,-21,-48,27,-24,-30,-88,51,60,-15,2,86,63,-28,-51,-97,-60,92,-79,-20,-44,12,83,100,9,-76,-7,-75,36,23,3,-55,-3,-37,-64,16,40,6,-24,-30,-53,-78,-32,63,-53,54,38,19,55,-90,80,-93,-68,-7,71,-92,-9,15,53,-76,-30,27,72,76,36,-77,-4,68,34,29,-45,-60,-55,29,53,-45,0,84,52,30,57,1,9,-99,77,14,14,-75,15,-9,8,-84,-94,47,59,-31,-83,9,68,-1,-68,64,55,18,42};
        System.out.println(threeSumClosest(test1,-230));
    }
}
