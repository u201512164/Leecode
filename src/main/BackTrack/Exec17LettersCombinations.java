package main.BackTrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exec17LettersCombinations {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(),result,digits,phoneMap,0);
        return result;
    }

    private void backtrack(StringBuilder sb, List<String> result, String digits, Map<Character, String> phoneMap, int index) {
        if (index == digits.length()) {
            result.add(sb.toString());
        } else {
            char c = digits.charAt(index);
            String s = phoneMap.get(c);
            for (int i=0; i<s.length(); i++) {
                sb.append(s.charAt(i));
                backtrack(sb,result,digits,phoneMap,index+1);
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}
