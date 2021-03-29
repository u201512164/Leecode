package main.GreedyAlgorithm;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Exec13RomanToNum {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int prenum = map.get(s.charAt(0));
        for (int i=1; i<s.length(); i++) {
            int num = map.get(s.charAt(i));
            if (prenum < num) {
                result -= prenum;
            } else {
                result += prenum;
            }
            prenum = num;
        }
        result += prenum;
        return result;
    }

    @Test
    public void test() {
        String[] tests = new String[]{"III","IV","IX","LVIII","MCMXCIV"};
        for (String test : tests) {
            System.out.println(romanToInt(test));
        }
    }
}
