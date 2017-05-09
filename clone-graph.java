/*
@Copyright:LintCode
@Author:   cindyyao
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 17-03-15 23:48
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return null;
        }
        // get nodes
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        HashSet<UndirectedGraphNode> set = new HashSet<>();
        set.add(node);
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            UndirectedGraphNode currNode = queue.poll();
            nodes.add(currNode);
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                if (!set.contains(neighbor)){
                    set.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        
        // copy nodes into hashmap
        HashMap<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode currNode : nodes) {
            mapping.put(currNode, new UndirectedGraphNode(currNode.label));
        }
        
        // copy neighbor
        for (UndirectedGraphNode currNode : nodes) {
            UndirectedGraphNode nodeCopy = mapping.get(currNode);
            for (UndirectedGraphNode neighbor : currNode.neighbors) {
                nodeCopy.neighbors.add(mapping.get(neighbor));
            }
        }
        
        return mapping.get(node);
    }
}