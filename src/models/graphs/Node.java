package models.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Node {

    private String name;
    private HashMap<Node,Double> neighbours;

    public Node(String name) {
        this.name = name;
        neighbours = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public HashMap<Node, Double> getNeighbours() {
        return neighbours;
    }

    public void addNeighbour(Node neighbour, double pathLength){
        neighbours.put(neighbour,pathLength);
    }

    public void removeNeighbour(Node neighbour){
        neighbours.remove(neighbour);
    }

    public boolean equals(Node node){
        return name.equals(node.name);
    }
}
