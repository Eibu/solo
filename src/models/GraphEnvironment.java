package models;

import models.agents.Agent;
import models.agents.State;
import models.environments.Environment;
import models.graphs.Graph;

/**
 * Created by Florian on 11/02/2018.
 * An environment with a quick access to its graph property
 */
public class GraphEnvironment extends Environment {

    private static GraphEnvironment instance = null;


    private GraphEnvironment(Graph graph) {
        super();
        properties.put("graph",graph);
    }

    public static GraphEnvironment getInstance(Graph graph){
        if(instance == null) instance = new GraphEnvironment(graph);
        return instance;
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

    public Graph getGraph(){
        return (Graph) properties.get("graph");
    }
}
