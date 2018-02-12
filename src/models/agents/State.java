package models.agents;

import java.util.HashMap;

/**
 * Created by Florian on 07/02/2018.
 */
public class State {

    private String name;
    private HashMap<String, Object> properties;

    public State(String name) {
        this.name = name;
        this.properties = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getProperty(String property){
        return properties.get(property);
    }

    public void addProperty(String property, Object object){
        properties.put(property,object);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;

        State state = (State) o;

        return name != null ? name.equals(state.name) : state.name == null;
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                '}';
    }
}
