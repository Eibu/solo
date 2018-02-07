package models;

import models.agents.Action;
import models.agents.Agent;
import models.graphs.Node;

/**
 * Created by Florian on 06/02/2018.
 */
public class MoveToAction extends Action {

    private Node destination;

    public MoveToAction(Node destination) {
        this.destination = destination;
    }

    public void setDestination(Node destination){
        this.destination = destination;
    }

    public void execute(Agent agent, GraphState state){
        if(destination==null){
            System.out.println("The node has not been set.");
        }else {
            state.setAgentLocation(agent, destination);
        }
    }
}
