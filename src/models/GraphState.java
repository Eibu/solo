package models;

import models.agents.Agent;
import models.environments.EnvironmentState;
import models.graphs.Graph;
import models.graphs.Node;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphState extends EnvironmentState {


    private Graph graph;
    public GraphState(String name) {
        super(name);
    }

    public GraphState(long id, String name) {
        super(id, name);
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public Node getAgentLocation(Agent agent){
        for(Agent a : agentLocation.keySet()){
            if(a.equals(agent)) return (Node) agentLocation.get(a);
        }
        return null;
    }

    public void setAgentLocation(Agent agent, Node newLocation){
        agentLocation.replace(agent,newLocation);
    }


    public void addAgent(Agent agent, Node locaton){
        agentLocation.put(agent,locaton);
    }
}
