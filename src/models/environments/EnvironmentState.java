package models.environments;

import models.agents.Agent;

import java.util.HashMap;

/**
 * Created by Florian on 06/02/2018.
 */
public class EnvironmentState {

    protected long id;
    protected String name;
    protected HashMap<Agent,Object> agentLocation;

    public EnvironmentState(String name) {
        this.id = 1;
        this.name = name;
        this.agentLocation = new HashMap<>();
    }

    public EnvironmentState(long id, String name) {
        this.id = id;
        this.name = name;
        this.agentLocation = new HashMap<>();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashMap<Agent, Object> getAgentLocation() {
        return agentLocation;
    }

    public void setAgentLocation(HashMap<Agent, Object> agentLocation) {
        this.agentLocation = agentLocation;
    }
}
