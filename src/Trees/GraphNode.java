package Trees;

import java.util.ArrayList;

public class GraphNode {

    int val;
    ArrayList<GraphNode> links = new ArrayList<>();

    GraphNode() {}
    GraphNode(int val) { this.val = val; }
    GraphNode(int val, GraphNode linkNode) {
        this.val = val;
        links.add(linkNode);
    }
}
