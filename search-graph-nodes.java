/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/search-graph-nodes
@Language: Java
@Datetime: 17-03-16 04:11
*/

/**
 * Definition for graph node.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x; neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        if (graph == null || graph.size() == 0) {
            return null;
        }
        Queue<UndirectedGraphNode> searchQueue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        searchQueue.offer(node);
        set.add(node);
        while (!searchQueue.isEmpty()) {
            UndirectedGraphNode currNode = searchQueue.poll();
            if (values.get(currNode) == target) {
                return currNode;
            }
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    searchQueue.offer(neighbor);
                }
            }
        }
        return null;
    }
}