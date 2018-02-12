package models.strategies;

import models.agents.Problem;
import models.agents.State;

import java.util.HashMap;

/**
 * Created by Florian on 11/02/2018.
 * Implementation of the Breadth-first strategy using the path cost to achieve goal
 */
public class Breadth_firstStrategy extends Strategy{

    public Breadth_firstStrategy() {
        super();
    }



    @Override
    protected void applyStrategy(Problem problem){
        HashMap<State,Double> children =  problem.applySuccessionFunction(parent);
        for(State s : children.keySet()){
            if(!elders.contains(s)){
                fringe.add(s,children.get(s)+cost,elders);
            }
        }
        fringe.sortByIncreasingCumulatedCost();
    }

    @Override
    protected void compareToBest(Problem problem){
        if( problem.testGoal(parent) ){
            if(best!=null){
                if(best.getCumulatedCost()>elders.getCumulatedCost()){
                    best = new Elders(elders);
                }
            }else{
                best = new Elders(elders);
            }
        }
    }

}
