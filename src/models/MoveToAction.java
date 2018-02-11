package models;

import models.agents.Action;
import models.agents.Agent;
import models.agents.State;
import models.environments.Environment;
import models.graphs.Node;

/**
 * Created by Florian on 06/02/2018.
 */
public class MoveToAction extends Action {


    public MoveToAction(State start, State end) {
        super(start, end);
    }

    public void execute(Agent agent, GraphEnvironment env ){
        if(end==null){
            System.out.println("The destination has not been set.");
        }else {
            env.setAgentLocation(agent, end);
        }
    }
}
