package models.strategies;

import models.MoveToAction;
import models.agents.Action;
import models.agents.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 12/02/2018.
 * Contains the list of the actions to execute to get to the last state memorized and its cost
 */
public class Elders {

    private List<Action> elders;
    private State last_state;
    private double cumulatedCost;
    private String states;

    public Elders(State last_state) {
        elders = new ArrayList<>();
        cumulatedCost = 0;
        states = "";
        this.last_state = last_state;
    }

    public Elders(Elders elders){
        this.elders = new ArrayList<>(elders.getElders());
        this.cumulatedCost = elders.cumulatedCost;
        this.states = elders.states;
        this.last_state = elders.last_state;
    }

    public List<Action> getElders() {
        return elders;
    }

    public void addElder(State state, double cost){
        if(!last_state.equals(state)) {
            Action a = new MoveToAction(last_state, state, cost-cumulatedCost);
            cumulatedCost = cost;
            states += state + " - ";
            last_state = state;
            elders.add(a);
        }
    }


    public boolean contains(State state){
        for(Action a : elders){
            if(a.getEnd().equals(state))return  true;
        }
        return false;
    }

    public double getCumulatedCost() {
        return cumulatedCost;
    }

    @Override
    public String toString() {
        return states;
    }

    public void setCumulatedCost(double cumulatedCost) {
        this.cumulatedCost = cumulatedCost;
    }


}
