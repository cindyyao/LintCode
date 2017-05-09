/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/word-break
@Language: Java
@Datetime: 17-03-26 04:56
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here 
        if (s.length() == 0) {
            return true;
        }
        int max = maxLength(dict);
        boolean[] canSegment = new boolean[s.length() + 1];
        canSegment[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            canSegment[i] = false;
            for (int lastLength = 1; lastLength <= Math.min(i, max); lastLength++) {
                if (canSegment[i - lastLength] && dict.contains(s.substring(i - lastLength, i))) {
                    canSegment[i] = true;
                }
            }
        }
        return canSegment[s.length()];
    }
    private int maxLength(Set<String> dict) {
        int max = 0;
        for (String word : dict) {
            if (word.length() > max) {
                max = word.length();
            }
        }
        return max;
    }
}