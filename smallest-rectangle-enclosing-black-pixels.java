/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/smallest-rectangle-enclosing-black-pixels
@Language: Java
@Datetime: 17-03-09 04:36
*/

public class Solution {
    /**
     * @param image a binary matrix with '0' and '1'
     * @param x, y the location of one of the black pixels
     * @return an integer
     */
    public int minArea(char[][] image, int x, int y) {
        // Write your code here
        if (image.length == 0 || image[0].length == 0){
            return 0;
        }
        int xMax = x;
        int low = x;
        int high = image.length - 1;
        while (low + 1 < high){
            int mid = low + (high - low) / 2;
            if (checkRow(image, mid)){
                low = mid;
            }
            else {
                high = mid;
            }
        }
        if (checkRow(image, high)){
            xMax = high;
        }
        else{
            xMax = low;
        }
        
        int xMin = x;
        low = 0;
        high = x;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if (checkRow(image, mid)){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        if (checkRow(image, low)){
            xMin = low;
        }
        else {
            xMin = high;
        }
        
        int yMax = y;
        low = y;
        high = image[0].length - 1;
        while (low + 1 < high){
            int mid = low + (high - low) / 2;
            if (checkColumn(image, mid)){
                low = mid;
            }
            else {
                high = mid;
            }
        }
        if (checkColumn(image, high)){
            yMax = high;
        }
        else{
            yMax = low;
        }
        
        int yMin = y;
        low = 0;
        high = y;
        while (low + 1 < high){
            int mid = low + (high - low) / 2;
            if (checkColumn(image, mid)){
                high = mid;
            }
            else{
                low = mid;
            }
        }
        if (checkColumn(image, low)){
            yMin = low;
        }
        else {
            yMin = high;
        }
        return (yMax - yMin + 1) * (xMax - xMin + 1);
    }
    
    private boolean checkRow(char[][] image, int idx){
        boolean result = false; 
        for (int i = 0; i < image[idx].length; i++){
            if (image[idx][i] == '1'){
                result = true;
                break;
            }
        }
        return result;
    }
    
    private boolean checkColumn(char[][] image, int idx){
        boolean result = false;
        for (int j = 0; j < image.length; j++){
            if (image[j][idx] == '1'){
                result = true;
            }
        }
        return result;
    }
}