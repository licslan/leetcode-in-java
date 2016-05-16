/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    // BFS
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        UndirectedGraphNode origin = new UndirectedGraphNode(node.label);// new node for return
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();// store visited nodes

        map.put(origin.label, origin);// add first node to HashMap
        Queue<UndirectedGraphNode> queue = new LinkedList<>();// to store nodes need to be visited
        queue.add(node);// add first origin node to queue,not first new node

        while (!queue.isEmpty()) {// if more nodes need to be visited
            UndirectedGraphNode n = queue.poll();// search first node in the queue
            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.label)) {// add to map and queue if this node hasn't been searched before
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.add(neighbor);
                }
                map.get(n.label).neighbors.add(map.get(neighbor.label));// add neighbor to new created nodes
            }
        }
        return origin;
    }
}