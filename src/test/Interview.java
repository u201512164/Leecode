package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/*
* 哥德巴赫猜想中任意一个大于3的数都可以由多个素数组成。找出4到100中可以由两个素数组成的数，如 4=2+2, 5=2+3, 6=3+3， 7=2+5。
 * */
public class Interview {
    @Test
    public void test() {
        List<Integer> result = getNums();
        System.out.println(result);
    }

    public List<Integer> getNums() {
        List<Integer> result = new ArrayList<>();
        for (int x=4; x<=100; x++) {
            for (int i = 2; i <= x / 2; i++) {
                if (isValid(i) && isValid(x - i)) {
                    result.add(x);
                    break;
                }
            }
        }
        return result;
    }

    private boolean isValid(int n) {
        boolean flag = true;
        for (int j=2; j<=Math.sqrt(n); j++) {
            if (n%j == 0) {
                flag = false;
            }
        }
        return flag;
    }
}
