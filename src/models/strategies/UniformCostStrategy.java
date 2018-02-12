package models.strategies;

import models.agents.Action;
import models.agents.Problem;
import models.agents.State;

import java.util.List;

/**
 * Created by Florian on 11/02/2018.
 * Implementation of the uniformcost strategy using the path cost to achieve goal
 */
public class UniformCostStrategy extends Strategy{

    public UniformCostStrategy() {
        super();
    }



    @Override
    protected void applyStrategy(Problem problem, SearchAlgorithm algorithm){
        State parent = algorithm.getParent();
        Elders elders = algorithm.getElders();
        List<Action> actions =  problem.getActions(parent);
        for(Action a : actions){
            State child = problem.SuccessorFn(parent,a);
            if(!elders.contains(child)) {
                algorithm.getFringe().add(child, problem.getCost(parent, a, child) + algorithm.getCost(), elders);
            }
        }
        algorithm.getFringe().sortByIncreasingCumulatedCost();
    }


    @Override
    protected void compareToBest(Problem problem,SearchAlgorithm algorithm){
        Elders elders = algorithm.getElders();
        Elders best = algorithm.getBest();
        if( problem.testGoal(algorithm.getParent()) ){
            if(best!=null){
                if(best.getCumulatedCost()>elders.getCumulatedCost()){
                    algorithm.setBest(new Elders(elders));
                }
            }else{
                algorithm.setBest(new Elders(elders));
            }
        }
    }

}
