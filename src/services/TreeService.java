package services;

import models.graphs.Graph;
import models.graphs.Node;
import models.trees.Tree;
import models.trees.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class TreeService {

    public static TreeNode generateTreeFromGraph(Graph graph, Node starting_node, List<Node> ancestors, double cost, int depth){
        HashMap<Node, Double> neighbours = starting_node.getNeighbours();
        Iterator<Node> i = neighbours.keySet().iterator();
        while(i.hasNext()){
            Node n= i.next();
            if(ancestors.contains(n)){
                i.remove();//neighbours.remove(n);
            }
        }
        TreeNode current = new TreeNode(depth,cost, starting_node);
        if(neighbours.size()>0){
            for(Node n : neighbours.keySet()){
                List<Node> newAncestors = new ArrayList<>(ancestors);
                newAncestors.add(n);
                //System.out.println(((Node)current.getContent()).getName()+"\n"+depth+"\n"+newAncestors.size());
                TreeNode child = generateTreeFromGraph(graph,n,newAncestors,neighbours.get(n),depth+1);
                current.addChild(child,neighbours.get(n));

            }
        }
        return current;
    }
}
