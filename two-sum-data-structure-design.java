/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/two-sum-data-structure-design
@Language: Java
@Datetime: 17-03-23 03:21
*/

public class TwoSum {

    // Add the number to an internal data structure.
    ArrayList<Integer> elements = new ArrayList<>();
    HashMap<Integer, Integer> mapping = new HashMap<>();
    public void add(int number) {
        // Write your code here
        if (mapping.containsKey(number)) {
            mapping.put(number, 2);
        } else {
            mapping.put(number, 1);
        }
        insert(elements, number);
        return;
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        // Write your code here
    for (int i = 0; i < elements.size() && elements.get(i) < value / 2 + 1; i++) {
            if (elements.get(i) * 2 == value && mapping.get(elements.get(i)) == 2) {
                return true;
            }
            if (elements.get(i) * 2 != value && mapping.containsKey(value - elements.get(i))) {
                return true;
            }
        }
        return false;
    }
    public void insert(ArrayList<Integer> elements, int number) {
        if (elements.size() == 0) {
            elements.add(number);
        }
        int low = 0;
        int high = elements.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (elements.get(mid) < number) {
                low = mid;
            } else if (elements.get(mid) > number) {
                high = mid;
            } else {
                return;
            }
        }
        if (elements.get(low) > number) {
            elements.add(low, number);
        } else {
            elements.add(high, number);
        }
        return;
    }
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);