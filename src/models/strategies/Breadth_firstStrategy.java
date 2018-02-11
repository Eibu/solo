package models.strategies;

import models.MoveToAction;
import models.agents.Action;
import models.agents.Problem;
import models.agents.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 11/02/2018.
 */
public class Breadth_firstStrategy extends Strategy{

    private List<State> fringe, olds;
    private List<List<Object>> memory;


    public Breadth_firstStrategy() {
        super();
        fringe = new ArrayList<>();
        olds = new ArrayList<>();
        memory = new ArrayList<>();
    }


    @Override
    public List<Action> run(Problem problem) {
        fringe.add(problem.getInitialState());
        memory.add(generateMemory(problem.getInitialState(),null));
        while(fringe.size()>0) {
            State parent = dequeue();
            if( problem.testGoal(parent) ) return buildSolution(parent);
            List<State> children =  problem.applySuccessionFunction(parent);
            for(State s : children){
                if(!olds.contains(s) && !fringe.contains(s)){
                    memory.add(generateMemory(parent,s));
                    fringe.add(s);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Action> buildSolution(State last){
        List<Action> solution = new ArrayList<>();
        State current = last;
        boolean found = false;
        while(current != null){
            for(int i = 0; i<memory.size()&& !found;i++){
                if(memory.get(i).get(1).equals(last)){
                    found = true;
                    solution.add((Action)memory.get(i).get(2));
                    current = (State) memory.get(i).get(0);
                }
            }
        }
        return solution;
    }

    private State dequeue(){
        State parent = fringe.get(0);
        fringe.remove(0);
        olds.add(parent);
        return parent;
    }

    private List<Object> generateMemory(State parent,State child){
        List<Object> memory = new ArrayList<>();
        memory.add(parent);
        memory.add(child);
        memory.add(new MoveToAction(parent,child));
        return memory;
    }

}
