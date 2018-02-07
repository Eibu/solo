import models.graphs.Graph;
import models.graphs.Node;
import models.trees.TreeNode;
import populators.GraphPopulator;
import services.TreeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Main {

    public static void main(String[] args){
        Graph graph = GraphPopulator.populate();
        Node start = graph.getNode("Arad");
        List<Node> ancestors = new ArrayList<>();
        ancestors.add(start);
        TreeNode tree = TreeService.generateTreeFromGraph(graph,start,ancestors,0,0);
    }
}
