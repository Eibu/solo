package models;

import models.agents.Agent;
import models.agents.Goal;
import models.agents.Problem;
import models.agents.State;
import models.environments.Environment;
import models.graphs.Graph;
import models.graphs.Node;
import models.trees.Tree;
import models.trees.TreeNode;
import services.TreeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphProblem extends Problem{


    private Graph graph;

    public GraphProblem(State initialState, Goal goal, Graph graph) {
        super(initialState, goal);
        this.graph = graph;
    }


    @Override
    public List<State> applySuccessionFunction(State state) {
        Node node = graph.getNode(state);
        List<State> successors = new ArrayList<>();
        for(Node n :node.getNeighbours().keySet()){
            successors.add(n.getState());
        }
        return successors;
    }
}
