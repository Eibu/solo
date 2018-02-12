package models;

import models.agents.Action;
import models.agents.Agent;
import models.agents.State;

/**
 * Created by Florian on 06/02/2018.
 */
public class MoveToAction extends Action {


    private double cost;

    public MoveToAction(State start, State end,double cost) {
        super(start, end);
        this.cost = cost;
    }



    @Override
    public void execute(Agent agent){
        if(end==null){
            System.out.println("The destination has not been set.");
        }else {
            if(agent.getState().equals(start)) {
                System.out.println("ACTION - The agent " + agent.getId() + " has moved from \"" + start.getName() + "\" to \"" + end.getName()+"\"");
                GraphEnvironment.getInstance(null).setAgentLocation(agent, end);
                agent.setState(end);
                agent.getProblem().increasePathCost(cost);
            }else {
                System.out.println("ACTION - preconditions are not respected : \nAgent "+agent.getId()+" is currently at \""+agent.getState().getName()+ "\" it has to move to \""+start.getName()+"\" first !");

            }
        }
    }

    public double getCost() {
        return cost;
    }
}
