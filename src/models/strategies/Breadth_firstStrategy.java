package models.strategies;

import models.MoveToAction;
import models.agents.Action;
import models.agents.Problem;
import models.agents.State;

import java.util.ArrayList;
import java.util.Collections;
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
        System.out.println("STRATEGY - Initiate");
        fringe.add(problem.getInitialState());
        memory.add(generateMemory(problem.getInitialState(),null));
        while(fringe.size()>0) {
            System.out.println("STRATEGY - Running through "+fringe.size()+" nodes.");
            State parent = dequeue();
            if( problem.testGoal(parent) ){
                System.out.println("STRATEGY - Solution found !");
                return buildSolution(parent);
            }
            List<State> children =  problem.applySuccessionFunction(parent);
            System.out.println("STRATEGY - "+children.size()+" found, examinating them...");
            for(State s : children){
                if(!olds.contains(s) && !fringe.contains(s)){
                    System.out.println("STRATEGY - New child found : "+s.getName());
                    memory.add(generateMemory(parent,s));
                    //System.out.println("STRATEGY - Memory added : "+parent.getName()+" "+memory.size());
                    fringe.add(s);
                }
            }
        }
        return new ArrayList<>();
    }

    private List<Action> buildSolution(State last){
        System.out.println("STRATEGY - Compiling solution...");
        String str = "STRATEGY - Solution : \n";
        List<Action> solution = new ArrayList<>();
        State current = last;
        boolean found = false;
        while(current != null){
            found = false;
            str =str+current.getName() +" - ";
            for(int i = memory.size()-1; i>=0 && !found ; i--){
                List<Object> mem = memory.get(i);
                State s = (State)mem.get(1);
                if(s != null) {
                    if (current.getName().equals(s.getName())) {
                        found = true;
                        solution.add((Action) mem.get(2));
                        current = (State) mem.get(0);
                    }
                }else{
                    found = true;
                    current = null;
                }
            }
        }
        System.out.println(str);
        Collections.reverse(solution);
        return solution;
    }

    private State dequeue(){
        State parent = fringe.get(0);
        fringe.remove(0);
        olds.add(parent);
        return parent;
    }

    private List<Object> generateMemory(State parent,State child){
        List<Object> mem = new ArrayList<>();
        mem.add(parent);
        mem.add(child);
        mem.add(new MoveToAction(parent,child));
        return mem;
    }

}
