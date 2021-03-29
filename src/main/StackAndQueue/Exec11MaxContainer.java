package main.StackAndQueue;

import org.junit.Test;

public class Exec11MaxContainer {
    public int maxArea(int[] height) {
        int left=0, right = height.length-1;
        int area = 0;
        while (left < right) {
            int tempArea = (right-left)*Math.min(height[left],height[right]);
            if (tempArea > area) {
                area = tempArea;
            }
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

    @Test
    public void test() {
        int[] test1 = new int[]{1,8,6,2,5,4,8,3,7};
        int[] test2 = new int[]{1,1};
        System.out.println(maxArea(test1));
    }
}
