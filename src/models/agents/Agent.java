package models.agents;

import models.strategies.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Agent {

    private String id;
    private List<Action> sequence;
    private State state;
    private Goal goal;
    private Problem problem;
    private Strategy strategy;


    public Agent(String id, State state, Strategy strategy, Goal goal) {
        this.id = id;
        this.sequence = new ArrayList<>();
        this.state = state;
        this.goal = goal;
        this.strategy = strategy;
    }

    public void run(){
        if(sequence.size()<1){
            formulateGoal();
            formulateProblem();
            search();
        }
        recommends();
        updateSequence();
    }




    private void formulateGoal(){
        //uses state to obtain a goal
        goal = new Goal("Bucharest",new State("Bucharest"));
    }

    private void formulateProblem(){
        //uses environmentState and goal to obtain a problem
        problem = new Problem(new State("Arad"), goal);
    }

    private void search(){
        //uses problem to get a sequence
        if(problem.testGoal(state));
        sequence = strategy.run(problem);
    }

    private void recommends(){
        //uses sequence and state to choose an action
        Action action = sequence.get(1);

    }

    private void updateSequence(){
        //uses sequence and state to update sequence
        if(sequence.size()>0) {
            if (sequence.get(0).getStart().equals(state)) {
                sequence.remove(0);
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
