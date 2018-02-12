package models;

import models.agents.Goal;
import models.agents.Problem;
import models.agents.State;
import models.graphs.Node;

import java.util.HashMap;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphProblem extends Problem{

    public GraphProblem(State initialState, Goal goal) {
        super(initialState, goal);
    }

    @Override
    public HashMap<State,Double> applySuccessionFunction(State state) {
        //System.out.println("PROBLEM - Obtaining successors...");
        Node node = GraphEnvironment.getInstance(null).getGraph().getNode(state);
        HashMap<State,Double> successors = new HashMap<>();
        for(Node n :node.getNeighbours().keySet()){
            successors.put(n.getState(),node.getNeighbours().get(n));
        }
        //System.out.println("PROBLEM - Obtaining successors done.");
        return successors;
    }
}
