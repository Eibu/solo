package models.agents;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Problem {

    protected State initialState;
    protected List<Action> actions;
    protected List<Successor> successors;
    protected double pathCost;
    protected Goal goal;

    public Problem(State initialState, Goal goal) {
        this.initialState = initialState;
        actions = new ArrayList<>();
        pathCost = 0;
        this.goal = goal;
    }

    public void applySuccessionFunction(){
        //uses initialState to generate the successors (root percepts of each sequence)
    }


    public boolean testGoal(State test){
        return goal.getGoal().equals(test);
    }

    public double getPathCost(){
        return pathCost;
    }

    public double increasePathCost(double growth){
        pathCost+=growth;
        return pathCost;
    }

    public void addAction(Action action){
        actions.add(action);
    }

}
