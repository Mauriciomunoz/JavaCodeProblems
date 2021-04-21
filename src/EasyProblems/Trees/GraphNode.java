package EasyProblems.Trees;

import java.util.ArrayList;

public class GraphNode {

    int val;
    public ArrayList<GraphNode> links = new ArrayList<>();

    GraphNode() {}
    public GraphNode(int val) { this.val = val; }
    GraphNode(int val, GraphNode linkNode) {
        this.val = val;
        links.add(linkNode);
    }
}
