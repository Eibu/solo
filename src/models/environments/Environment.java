package models.environments;

import models.agents.Agent;

import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Environment {

    private List<Agent> agents;
    private EnvironmentState environmentState;

    public Environment(List<Agent> agents, EnvironmentState environmentState) {
        this.agents = agents;
        this.environmentState = environmentState;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }

    public void addAgent(Agent agent){
        this.agents.add(agent);
    }

    public void removeAgent(Agent agent){
        this.agents.remove(agent);
    }

    public EnvironmentState getEnvironmentState() {
        return environmentState;
    }

    public void setEnvironmentState(EnvironmentState environmentState) {
        this.environmentState = environmentState;
    }
}
