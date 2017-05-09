/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/rotate-string
@Language: Java
@Datetime: 17-03-28 04:49
*/

public class Solution {
    /**
     * @param str: an array of char
     * @param offset: an integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        if (offset == 0 || str == null || str.length == 0) {
            return;
        }
        offset = offset % str.length;
        swap(str, 0, str.length - 1);
        swap(str, 0, offset - 1);
        swap(str, offset, str.length - 1);
        return;
    }
    private void swap(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return;
    }
}