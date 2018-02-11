package models.graphs;

import models.agents.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Graph {

    private String name;
    private List<Node> nodes;

    public Graph(String name) {
        this.name = name;
        nodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public Node getNode(String name){
        for(Node node : nodes){
            if(node.getName().equals(name)) return node;
        }
        return null;
    }

    public Node getNode(State state){
        for(Node n : nodes){
            if(n.getState().equals(state))return n;
        }
        return null;
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addPath(Node n1, Node n2, double distance){
        n1.addNeighbour(n2,distance);
        n2.addNeighbour(n1,distance);
    }

    public void removePath(Node n1, Node n2){
        n1.removeNeighbour(n2);
        n2.removeNeighbour(n1);
    }


}
