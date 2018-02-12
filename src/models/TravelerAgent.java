package models;

import models.agents.Agent;
import models.agents.Goal;
import models.agents.State;
import models.strategies.Strategy;

/**
 * Created by Florian on 11/02/2018.
 * Just an agent who creates GraphProblems
 */
public class TravelerAgent extends Agent {

    public TravelerAgent(String id, State state, Strategy strategy, Goal goal) {
        super(id, state, strategy, goal);
    }


    @Override
    protected void formulateProblem() {
        System.out.println("AGENT - Problem is generated");
        problem = new GraphProblem(state,goal);
    }
}
