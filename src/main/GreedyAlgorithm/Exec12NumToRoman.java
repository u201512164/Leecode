package main.GreedyAlgorithm;

import org.junit.Test;

public class Exec12NumToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<13; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        int[] tests = new int[]{3,4,9,58,1994};
        for (int test: tests) {
            System.out.println(intToRoman(test));
        }
    }
}
