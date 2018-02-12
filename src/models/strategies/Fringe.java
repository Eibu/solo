package models.strategies;

import models.agents.State;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Florian on 12/02/2018.
 * contains the list of all the nodes to explore and the ancestors needed to go to them with path cost
 */
public class Fringe {
    
    private List<List<Object>> fringe;

    public Fringe() {
        fringe = new ArrayList<>();
    }
    
    
    public void add(State state, double cumulatedCost, Elders elders){
        List<Object> l = new ArrayList<>();
        l.add(state);
        l.add(cumulatedCost);
        l.add(new Elders(elders));
        fringe.add(l);
    }
    
    public List<Object> get(int index){
        return fringe.get(index);
    }
    
    public State getState(int index){
        return (State)fringe.get(index).get(0);
    }
    
    public double getCumulatedCost(int index){
        return (double)fringe.get(index).get(1);
    }
    
    public Elders getElders(int index){
        return new Elders((Elders)fringe.get(index).get(2));
    }



    public int size(){
        return fringe.size();
    }

    public void remove(int index){
        fringe.remove(index);
    }

    public void sortByIncreasingCumulatedCost(){
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for( int i = 1; i<fringe.size();i++){
                if((double)fringe.get(i-1).get(1)>(double)fringe.get(i).get(1)){
                    List<Object> tmp = new ArrayList<>(fringe.get(i-1));
                    fringe.set(i-1,fringe.get(i));
                    fringe.set(i,tmp);
                    sorted = false;
                }
            }
        }
    }
}
