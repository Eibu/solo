package models.agents;

import java.util.HashMap;

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

    public HashMap<State,Double> applySuccessionFunction(State state){
        //uses initialState to generate the successors

        return null;
    }



    public boolean testGoal(State test){
        //System.out.println("PROBLEM - Testing goal");
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
