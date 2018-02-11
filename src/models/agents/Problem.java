package models.agents;

import models.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Problem {

    protected State initialState;
    protected double pathCost;
    protected Goal goal;

    public Problem(State initialState, Goal goal) {
        this.initialState = initialState;
        pathCost = 0;
        this.goal = goal;
    }

    public List<State> applySuccessionFunction(State state){
        //uses initialState to generate the successors


        return null;
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

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }
}
