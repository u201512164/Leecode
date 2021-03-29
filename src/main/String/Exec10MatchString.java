package main.String;

import org.junit.Test;

public class Exec10MatchString {
    public boolean isMatch(String s, String p) {
        if (p.length() < s.length()) {
            return false;
        }
        boolean result = true;
        int sIndex = 0, pIndex=0;
        while (sIndex < s.length() && pIndex < p.length()) {
            System.out.println("sindex:" + sIndex);
            System.out.println("pindex:" + pIndex);

            if (s.charAt(sIndex) == p.charAt(pIndex)) {
                result = true;
                sIndex++;
                pIndex++;
            } else {
                char temp = p.charAt(pIndex);
                if (temp == '*') {
                    if (!result) {
                        pIndex++;
                        continue;
                    }
                    sIndex++;
                    pIndex++;
                } else if (temp == '.') {
                    result = true;
                    sIndex++;
                    pIndex++;
                } else {
                    result = false;
                    pIndex++;
                }
            }
            System.out.println(result);
        }
        if (pIndex != p.length() || sIndex != s.length()) {
            result = false;
        }
        return result;
    }

    @Test
    public void test() {
        String tests1 = "aa";
        String testp1 = "a";
        String tests2 = "aa";
        String testp2 = "a*";
        String tests3 = "ab";
        String testp3 = ".*";
        String tests4 = "aab";
        String testp4 = "c*a*b";
        String tests5 = "mississippi";
        String testp5 = "mis*is*p*.";
        String tests6 = "aaa";
        String testp6 = "ab*a";
//        System.out.println(isMatch(tests1,testp1));
//        System.out.println(isMatch(tests2,testp2));
//        System.out.println(isMatch(tests3,testp3));
//        System.out.println(isMatch(tests4,testp4));
//        System.out.println(isMatch(tests5,testp5));
        System.out.println(isMatch(tests6,testp6));
    }
}
