package models;

import models.agents.Agent;
import models.agents.Goal;
import models.agents.Problem;
import models.environments.EnvironmentState;

/**
 * Created by Florian on 06/02/2018.
 */
public class GraphAgent extends Agent {


    public GraphAgent(String id, EnvironmentState environmentState, Goal goal, Problem problem) {
        super(id, environmentState, goal, problem);
    }
}
