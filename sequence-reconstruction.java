/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/sequence-reconstruction
@Language: Java
@Datetime: 17-03-26 02:33
*/

public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        if (org == null) {
            return false;
        }
        if (org.length == 0) {
            for (int[] sequence : seqs) {
                if (!Arrays.equals(sequence, org)) {
                    return false;
                }
            }
            return true;
        }
        if (org.length == 1) {
            for (int[] sequence : seqs) {
                if (Arrays.equals(sequence, org)) {
                    return true;
                } 
            }
            return false;
        }
        HashMap<Integer, HashSet<Integer>> preMapping = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> postMapping = new HashMap<>();
        int n = org.length;
        for (int i = 1; i <= n; i++) {
            preMapping.put(i, new HashSet<Integer>());
            postMapping.put(i, new HashSet<Integer>());
        }
        for (int[] sequence : seqs) {
            for (int i = 0; i < sequence.length; i++) {
                if (sequence[i] > n) {
                    return false;
                }
                if (i < sequence.length - 1) {
                    if (sequence[i + 1] > n) {
                        return false;
                    }
                    if (!preMapping.get(sequence[i + 1]).contains(sequence[i])) {
                        preMapping.get(sequence[i + 1]).add(sequence[i]);
                    }
                    if (!postMapping.get(sequence[i]).contains(sequence[i + 1])) {
                        postMapping.get(sequence[i]).add(sequence[i + 1]);
                    }
                }
            }
        }
        int[] indegree = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            indegree[i] = preMapping.get(i + 1).size();
            if (indegree[i] == 0) {
                queue.offer(i + 1);
            }
        }
        //System.out.println(printArray(indegree));
        if (queue.isEmpty()) {
            return false;
        }
        int index = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                return false;
            }
            int currNum = queue.poll();
            if (currNum != org[index]) {
                //System.out.println(currNum + " " + index);
                return false;
            }
            index++;
            HashSet<Integer> unlock = postMapping.get(currNum);
            Iterator iterator = unlock.iterator();
            while (iterator.hasNext()) {
                int next = (int)iterator.next();
                indegree[next - 1]--;
                if (indegree[next - 1] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;
    }
    private String printArray(int[] array) {
        String str = "";
        for (int i : array) {
            str = str + i + " ";
        }
        return str;
    }
}