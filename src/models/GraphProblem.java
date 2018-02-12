package models;

import models.agents.Action;
import models.agents.Goal;
import models.agents.Problem;
import models.agents.State;
import models.graphs.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 * Run through the graph to obtain the connected states and their cost of the given state
 */
public class GraphProblem extends Problem{


    public GraphProblem(State initialState, Goal goal) {
        super(initialState, goal);

    }




    @Override
    public List<Action> getActions(State state) {
        List<Action> actions = new ArrayList<>();
        Node node = GraphEnvironment.getInstance(null).getGraph().getNode(state);
        for(Node n : node.getNeighbours().keySet()){
            actions.add(new MoveToAction(state,n.getState(),node.getNeighbours().get(n)));
        }
        return actions;
    }

    @Override
    public State SuccessorFn(State state, Action action) {
        if(action instanceof MoveToAction){
            if(((MoveToAction)action).getStart().equals(state)){
                return action.getEnd();
            }
        }
        return null;
    }

    @Override
    public double getCost(State s1, Action action, State s2) {
        if(action instanceof MoveToAction){
            MoveToAction mta = (MoveToAction) action;
            if(mta.getStart().equals(s1) && mta.getEnd().equals(s2)){
                return mta.getCost();
            }
        }
        return 0;
    }
}
