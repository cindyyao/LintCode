/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/strstr
@Language: Java
@Datetime: 17-03-02 03:35
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    
    public static void main(String[] args){
        String source = "abcdabcdefg";
        String target = "bcd";
        int idx = strStr(source, target);
        System.out.println(Integer.toString(idx));
    }

    public static int strStr(String source, String target) {
        // write your code here
        if (source == null || target == null){
            return -1;
        }
        int SourceLength = source.length();
        int TargetLength = target.length();

        if (SourceLength < TargetLength){
            return -1;
        }
        else {
            int i = 0;
            while (i <= SourceLength - TargetLength){
                String SourcePart = source.substring(i, i+TargetLength);
                if (SourcePart.equals(target)){
                    return i;
                }
                else {
                    i++;
                }
            }
            return -1;
        }
    }
}