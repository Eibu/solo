package models.agents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Sequence {

    private List<Action> sequence;

    public Sequence(){
        sequence = new ArrayList<>();
    }

    public Sequence(List<Action> sequence) {
        this.sequence = sequence;
    }

    public Action next(State state){
        for(Action a : sequence){
            if(a.getStart().equals(state))return a;
        }
        return null;
    }


    public void update(State state){
        int last_index = 0;
        for(int i =0; i<sequence.size();i++){
            if(sequence.get(i).getStart().equals(state))last_index = i;
        }
        sequence = sequence.subList(last_index,sequence.size()-1);
    }

    public Action goToNext(){
        sequence.remove(0);
        return sequence.get(0);
    }

    public int getNumberOfActions(){
        return sequence.size();
    }
}
