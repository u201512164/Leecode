package main.String;

import org.junit.Test;

public class Exec43StringMultiply {

    @Test
    public void test() {
        String[] test1 = new String[]{"2074827430995917916475650555266","951781311226365593969711296674360758091336172621239102441"};
        System.out.println(multiply(test1[0],test1[1]));
    }

    public String multiply(String num1, String num2) {
        if (num1.charAt(0) == '0' || num2.charAt(0) == '0') {
            return "0";
        }
        int len1 = num1.length(),len2 = num2.length();
        int[] nums = new int[len1+len2];
        for (int i=len1-1; i>=0; i--) {
            int n1 = num1.charAt(i)-'0';
            for (int j=len2-1; j>=0; j--) {
                int n2 = num2.charAt(j)-'0';
                System.out.println(n1 + " " + n2);
                int pro = n1*n2 + nums[i+j+1];
                System.out.println(pro);
                nums[i+j+1] = pro%10;
                System.out.println(nums[i+j+1]);
                pro = pro/10;
                nums[i+j] += pro%10;
                System.out.println(nums[i+j]);
                for (int x : nums) {
                    System.out.print(x);
                }
                System.out.println();
            }
        }
        int index = 0;
        for (;index<len1+len2;index++) {

            if (nums[index] > 0) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n= index; n<nums.length; n++) {
            System.out.println(nums[n]);
            sb.append(nums[n]);
        }

        return sb.toString();
    }
}
