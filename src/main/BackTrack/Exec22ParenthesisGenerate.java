package main.BackTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Exec22ParenthesisGenerate {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, int left, int right, int n) {
        if (sb.length() == n*2) {
            result.add(sb.toString());
        }

        if (left < n) {
            sb.append('(');
            backtrack(result, sb, left + 1, right, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            sb.append(')');
            backtrack(result, sb, left, right +1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    @Test
    public void test() {
        int test1 = 3;
        int test2 = 5;
        System.out.println(generateParenthesis(test1));
        System.out.println(generateParenthesis(test2));
    }
}
