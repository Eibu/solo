package models.strategies;

import models.agents.Action;
import models.agents.Problem;
import models.agents.State;

import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 * Default template for the strategies classes like breadth-first, ...
 * /!\MUST OVERRIDE "compareToBest" and "applyStrategy"/!\
 */
public class Strategy {

    protected Elders elders, best;
    protected Fringe fringe;
    protected State parent;
    protected double cost;

    public Strategy() {
        fringe = new Fringe();
        best = null;
    }

    public List<Action> run(Problem problem) {
        parent = problem.getInitialState();
        elders = new Elders(parent);
        fringe.add(parent,0,elders);
        while(fringe.size()>0) {
            dequeue();
            compareToBest(problem);
            applyStrategy(problem);
        }
        System.out.println(best);
        return best.getElders();
    }





    protected void dequeue(){
        parent = fringe.getState(0);
        cost = fringe.getCumulatedCost(0);
        elders = fringe.getElders(0);
        elders.addElder(parent,cost);
        fringe.remove(0);
    }

    //To override in extension
    protected void compareToBest(Problem problem){

    }

    //To override in extension
    protected void applyStrategy(Problem problem){

    }
}
