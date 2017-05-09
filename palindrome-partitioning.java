/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 17-03-19 01:02
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> result = new ArrayList<>();
    public List<String> currArray = new ArrayList<>(); 
    public List<List<String>> partition(String s) {
        // write your code here
        if (s.length() == 0) {
            return result;
        }
        Helper(s);
        return result;
    }
    private void Helper(String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<String>(currArray));
            if (currArray.size() != 0) {
                currArray.remove(currArray.size() - 1);
            }
            return;
        }
        for (int i = 1; i <= s.length(); i++) {
            if (isPalindrome(s.substring(0, i))) {
                currArray.add(s.substring(0, i));
                Helper(s.substring(i, s.length()));
            }
        }
        if (currArray.size() != 0) {
            currArray.remove(currArray.size() - 1);
        }
        return;
    }
    
    private boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}