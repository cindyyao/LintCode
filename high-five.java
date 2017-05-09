/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/high-five
@Language: Java
@Datetime: 17-03-25 04:33
*/

/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> allScore = new HashMap<>();
        HashSet<Integer> students = new HashSet<>();
        for (int i = 0; i < results.length; i++) {
            if (!allScore.containsKey(results[i].id)) {
                allScore.put(results[i].id, new ArrayList<Integer>());
            }
            insertScore(allScore.get(results[i].id), results[i].score);
            if (!students.contains(results[i].id)) {
                students.add(results[i].id);
            }
        }
        Map<Integer, Double> meanScore = new HashMap<>();
        Iterator iterator = students.iterator();
        while (iterator.hasNext()) {
            int student = (int)iterator.next();
            ArrayList<Integer> score = allScore.get(student);
            double scoreMean = 0;
            for (int i = 0; i < 5; i++) {
                scoreMean += score.get(i) * 0.2;
            }
            meanScore.put(student, scoreMean);
        }
        return meanScore;
    }
    private void insertScore(ArrayList<Integer> array, int score) {
        if (array.size() == 0) {
            array.add(score);
            return;
        }
        int low = 0;
        int high = array.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (array.get(mid) <= score) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (array.get(low) < score) {
            array.add(low, score);
        } else if (array.get(high) > score) {
            array.add(high + 1, score);
        } else {
            array.add(high, score);
        }
        return;
    }
} 