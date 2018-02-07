package models.agents;

/**
 * Created by Florian on 06/02/2018.
 */
public class Action {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State execute(){
        return null;
    }
    public String toString(){
        return name;
    }
}
