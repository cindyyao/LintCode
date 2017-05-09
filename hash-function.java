/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 17-03-25 03:31
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        int base = 33;
        long code = 0;
        for (int i = 0; i < key.length; i++) {
            code = (code * base + key[i]) % HASH_SIZE;
        }
        return (int)code;
    }
};