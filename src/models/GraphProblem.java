package models;

import models.agents.Goal;
import models.agents.Problem;
import models.agents.State;
import models.graphs.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphProblem extends Problem{

    public GraphProblem(State initialState, Goal goal) {
        super(initialState, goal);
    }

    @Override
    public List<State> applySuccessionFunction(State state) {
        //System.out.println("PROBLEM - Obtaining successors...");
        Node node = GraphEnvironment.getInstance(null).getGraph().getNode(state);
        List<State> successors = new ArrayList<>();
        for(Node n :node.getNeighbours().keySet()){
            successors.add(n.getState());
        }
        //System.out.println("PROBLEM - Obtaining successors done.");
        return successors;
    }
}
