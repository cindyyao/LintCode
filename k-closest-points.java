/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/k-closest-points
@Language: Java
@Datetime: 17-03-25 05:43
*/

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points a list of points
     * @param origin a point
     * @param k an integer
     * @return the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // Write your code here
        HashMap<Integer, ArrayList<Point>> mapping = new HashMap<>();
        ArrayList<Integer> distanceAll = new ArrayList<>();
        for (Point point : points) {
            int distance = (int)Math.pow(point.x - origin.x, 2) + (int)Math.pow(point.y - origin.y, 2);
            if (!mapping.containsKey(distance)) {
                mapping.put(distance, new ArrayList<Point>());
            }
            insertDistanceMap(mapping.get(distance), point);
            insertDistanceArray(distanceAll, distance);
        }
        Point[] result = new Point[k];
        int index = 0;
        for (int distance : distanceAll) {
            ArrayList<Point> temp = mapping.get(distance);
            for (Point pointTemp : temp) {
                result[index] = pointTemp;
                index++;
                if (index >= k) {
                    break;
                }
            }
            if (index >= k) {
                break;
            }
        }
        return result;
    }
    private void insertDistanceMap(ArrayList<Point> points, Point point) {
        if (points.size() == 0) {
            points.add(point);
            return;
        }
        int xLow = 0;
        int xHigh = 0;
        int low = 0;
        int high = points.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (points.get(mid).x < point.x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (points.get(low).x > point.x) {
            points.add(0, point);
            return;
        } else if (points.get(high).x < point.x) {
            points.add(point);
            return;
        } else if (points.get(low).x == point.x) {
            xLow = low;
        } else if (points.get(high).x == point.x) {
            xLow = high;
        } else {
            points.add(high, point);
            return;
        }
        
        low = xLow;
        high = points.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (points.get(mid).x <= point.x) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (points.get(low).x == point.x) {
            xHigh = low;
        } else if (points.get(high).x == point.x) {
            xHigh = high;
        }
        low = xLow;
        high = xHigh;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (points.get(mid).y < point.y) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (points.get(low).y > point.y) {
            points.add(low, point);
        } else if (points.get(high).y < point.y) {
            points.add(high + 1, point);
        } else {
            points.add(high, point);
        }
        return;
    }
    private void insertDistanceArray(ArrayList<Integer> distanceAll, int distance) {
        if (distanceAll.size() == 0) {
            distanceAll.add(distance);
            return;
        }
        int low = 0;
        int high = distanceAll.size() - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (distanceAll.get(mid) == distance) {
                return;
            } else if (distanceAll.get(mid) < distance) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (distanceAll.get(low) > distance) {
            distanceAll.add(low, distance);
        } else if (distanceAll.get(high) < distance) {
            distanceAll.add(high + 1, distance);
        } else if (distanceAll.get(low) < distance && distance < distanceAll.get(high)) {
            distanceAll.add(high, distance);
        }
        return;
    }
}