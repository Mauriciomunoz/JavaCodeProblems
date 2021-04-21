package CCI_Problems;


import EasyProblems.Trees.GraphNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * CCI: 4.1 Route between nodes
 *
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 *
 *     2 -> 3 -> 4
 *   ^  \       ^  \
 *  1 <- \ --- / --- 5
 *        \  /     /
 *    8 <-- 7    6
 *
 * Hints: #127
 *
 */

public class RouteBetweenNodes_4_1 {

    public static void main(String[] args) {

        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        GraphNode node5 = new GraphNode(5);
        GraphNode node6 = new GraphNode(6);
        GraphNode node7 = new GraphNode(7);
        GraphNode node8 = new GraphNode(8);

        node1.links.add(node2);
        node2.links.add(node3);
        node2.links.add(node7);
        node3.links.add(node4);
        node4.links.add(node5);
        node5.links.add(node6);
        node5.links.add(node1);
        node7.links.add(node8);


        boolean result = isThereRoute(node1, node6);

        System.out.println(result);

    }

    //TC: O(N^2)
    //SC: O(N)
    private static boolean isThereRoute(GraphNode node1, GraphNode node2) {

        if(node1 == null || node1.links.isEmpty())
            return false;

        ArrayList<GraphNode> nodesVisited = new ArrayList<>();
        Queue<GraphNode> nodes = new LinkedList<>();

        nodes.add(node1);
        nodesVisited.add(node1);

        while (!nodes.isEmpty()){
            GraphNode nodeAux = nodes.remove();
            for(int i = 0; i < nodeAux.links.size(); i++){
                if(nodeAux.links.get(i) == node2){
                    return true;
                }else{
                    if(!nodesVisited.contains(nodeAux.links.get(i))) {
                        nodes.add(nodeAux.links.get(i));
                        nodesVisited.add(nodeAux.links.get(i));
                    }
                }
            }
        }

        return false;
    }


}
