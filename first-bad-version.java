/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 17-03-06 04:21
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        int low = 1;
        int high = n;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (SVNRepo.isBadVersion(mid)) {
                high = mid;
            }
            else {
                low = mid;
            }
        }
        if (SVNRepo.isBadVersion(low)){
            return low;
        }
        else {
            return high;
        }
    }
}
