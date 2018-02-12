package models.agents;

import models.strategies.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Agent {

    protected String id;
    protected List<Action> sequence;
    protected State state;
    protected Goal goal;
    protected Problem problem;
    protected Strategy strategy;


    public Agent(String id, State state, Strategy strategy, Goal goal) {
        this.id = id;
        this.sequence = new ArrayList<>();
        this.state = state;
        this.goal = goal;
        this.strategy = strategy;
    }

    public void run(){
        do {
            if (sequence.size() < 1) {
                formulateGoal();
                formulateProblem();
                search();
            }
            recommends();
            updateSequence();
        }while(!problem.testGoal(state) );
        System.out.println("AGENT - Goal achieved");
    }




    protected void formulateGoal(){
        //uses state to obtain a goal
        System.out.println("AGENT - goal is generated");
        //goal = new Goal("Bucharest",new State("Bucharest"));
    }

    protected void formulateProblem(){
        //uses environmentState and goal to obtain a problem
        System.out.println("AGENT - Problem is generated");
        problem = new Problem(state, goal);
    }

    private void search(){
        //uses problem to get a sequence
        System.out.println("AGENT - Initiate research...");
        sequence = strategy.run(problem);
        System.out.println("AGENT - research done.");
    }

    private void recommends(){
        //uses sequence and state to choose an action
        System.out.println("AGENT - Recommended action executed");
        Action action = sequence.get(0);
        action.execute(this);

    }

    private void updateSequence(){
        //uses sequence and state to update sequence

        if(sequence.size()>0) {
            //System.out.println(sequence.get(0).getStart().getName()+" - "+state.getName());
            if (sequence.get(0).getEnd().equals(state)) {
                sequence.remove(0);
                System.out.println("AGENT - Updating objective list");
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Action> getSequence() {
        return sequence;
    }


    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }
}
