package models.strategies;

import models.agents.Action;
import models.agents.Problem;
import models.agents.State;

import java.util.List;

/**
 * Created by Florian on 12/02/2018.
 */
public class SearchAlgorithm {

    protected Elders elders, best;
    protected Fringe fringe;
    protected State parent;
    protected double cost;
    protected Strategy strategy;

    public SearchAlgorithm(Strategy strategy) {
        fringe = new Fringe();
        best = null;
        this.strategy = strategy;
    }

    public List<Action> run(Problem problem) {
        parent = problem.getInitialState();
        elders = new Elders(parent);
        fringe.add(parent,0,elders);
        while(fringe.size()>0) {
            dequeue();
            strategy.compareToBest(problem, this);
            strategy.applyStrategy(problem,this);
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

    public Elders getElders() {
        return elders;
    }

    public void setElders(Elders elders) {
        this.elders = elders;
    }

    public Elders getBest() {
        return best;
    }

    public void setBest(Elders best) {
        this.best = best;
    }

    public Fringe getFringe() {
        return fringe;
    }

    public void setFringe(Fringe fringe) {
        this.fringe = fringe;
    }

    public State getParent() {
        return parent;
    }

    public void setParent(State parent) {
        this.parent = parent;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
