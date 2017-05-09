/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/strstr-ii
@Language: Java
@Datetime: 17-03-13 02:40
*/

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    public int strStr2(String source, String target) {
        int hashBase = 31;
        int hashMode = 1000000;
        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        if (target.length() == 0) {
            return 0;
        }
        int power = 1;
        for (int i = 0; i < target.length(); i++) {
            power = (power * hashBase) % hashMode;
        }
        int targetCode = 0;
        for (int i = 0; i < target.length(); i++) {
            targetCode = (targetCode * hashBase + target.charAt(i)) % hashMode;
        }
        int curCode = 0;
        for (int j = 0; j < source.length(); j++) {
            curCode = (curCode * hashBase + source.charAt(j)) % hashMode;
            if (j >= target.length()) {
                curCode = curCode - (source.charAt(j - target.length()) * power) % hashMode;
                if (curCode < 0) {
                    curCode = curCode + hashMode;
                }
                if (curCode == targetCode) {
                    if (source.substring(j - target.length() + 1, j + 1).equals(target)) {
                        return j - target.length() + 1;
                    }
                }
            }
            
        }
        return -1;
    }
}