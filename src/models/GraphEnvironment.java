package models;

import models.agents.Agent;
import models.agents.State;
import models.environments.Environment;
import models.graphs.Graph;

/**
 * Created by Florian on 11/02/2018.
 */
public class GraphEnvironment extends Environment {

    public GraphEnvironment(Graph graph) {
        super();
        properties.put("graph",graph);
    }


    public void addAgent(Agent agent){
        agentProperties.put(agent,null);
    }

    public void setAgentLocation(Agent agent,State location){
        agentProperties.replace(agent,location);
    }

    public State getAgentLocation(Agent agent){
        return (State) agentProperties.get(agent);
    }
}
