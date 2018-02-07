package models;

import models.agents.Goal;
import models.graphs.Node;

/**
 * Created by Florian on 06/02/2018.
 */
public class NodeGoal extends Goal {

    public NodeGoal(String name, Node goal) {
        super(name, goal);
    }

    public Node getGoal() {
        return (Node) super.getGoal();
    }



    public void setGoal(Node goal) {
        super.setGoal(goal);
    }
}
