package models.agents;

/**
 * Created by Florian on 06/02/2018.
 */
public class Goal {

    private String name;
    private Object goal;

    public Goal() {
    }

    public Goal(String name, Object goal) {
        this.name = name;
        this.goal = goal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Object getGoal() {
        return goal;
    }

    public void setGoal(Object goal) {
        this.goal = goal;
    }

}
