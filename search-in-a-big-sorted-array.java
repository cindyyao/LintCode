/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-in-a-big-sorted-array
@Language: Java
@Datetime: 17-03-28 03:18
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if index is less than zero.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        int pos = -1;
        int low = 0;
        int high = 1;
        while (target > reader.get(high)){
            low = high + 1;
            high = high * 2;
        }
        while (low + 1 < high){
            int mid = (low + high) / 2;
            if (target > reader.get(mid)){
                low = mid;
            } else {
                high = mid;
            }
        }
        if (reader.get(low) == target) {
            return low;
        } else if (reader.get(high) == target) {
            return high;
        } else {
            return -1;
        }
    }
}