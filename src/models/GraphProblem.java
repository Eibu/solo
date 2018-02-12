package models;

import models.agents.Goal;
import models.agents.Problem;
import models.agents.State;
import models.graphs.Node;

import java.util.HashMap;

/**
 * Created by Florian on 06/02/2018.
 * Run through the graph to obtain the connected states and their cost of the given state
 */
public class GraphProblem extends Problem{

    public GraphProblem(State initialState, Goal goal) {
        super(initialState, goal);
    }

    @Override
    public HashMap<State,Double> applySuccessionFunction(State state) {

        Node node = GraphEnvironment.getInstance(null).getGraph().getNode(state);

        HashMap<State,Double> successors = new HashMap<>();
        for(Node n :node.getNeighbours().keySet()){
            successors.put(n.getState(),node.getNeighbours().get(n));
        }
        return successors;
    }
}
