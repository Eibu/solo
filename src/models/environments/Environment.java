package models.environments;

import models.agents.Agent;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Environment {

    protected HashMap<Agent,Object> agentProperties;
    protected HashMap<String,Object> properties;

    public Environment() {
        agentProperties = new HashMap<>();
        properties = new HashMap<>();
    }

    public HashMap<Agent, Object> getAgentProperties() {
        return agentProperties;
    }

    public void setAgentProperties(HashMap<Agent, Object> agentProperties) {
        this.agentProperties = agentProperties;
    }

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(HashMap<String, Object> properties) {
        this.properties = properties;
    }
}
