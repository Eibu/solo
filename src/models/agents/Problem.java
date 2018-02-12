package models.agents;

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

    public List<Action> getActions(State state){
        return null;
    }


    public State SuccessorFn(State state, Action action){

        return null;
    }

    public double getCost(State s1, Action action, State s2){
        return 0;
    }

    public boolean testGoal(State test){
        //System.out.println("PROBLEM - Testing goal");
        return goal.getGoal().equals(test);
    }

    public double getPathCost(){
        return pathCost;
    }

    public void increasePathCost(double growth){
        pathCost+=growth;
    }

    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }
}
