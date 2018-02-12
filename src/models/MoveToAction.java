package models;

import models.agents.Action;
import models.agents.Agent;
import models.agents.State;

/**
 * Created by Florian on 06/02/2018.
 */
public class MoveToAction extends Action {


    public MoveToAction(State start, State end) {
        super(start, end);
    }



    @Override
    public void execute(Agent agent){
        if(end==null){
            System.out.println("The destination has not been set.");
        }else {
            System.out.println("ACTION - The agent "+agent.getId()+" has moved from "+start.getName() +" to "+end.getName());
            GraphEnvironment.getInstance(null).setAgentLocation(agent, end);
            agent.setState(end);
        }
    }
}
