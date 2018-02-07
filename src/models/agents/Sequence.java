package models.agents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Florian on 06/02/2018.
 */
public class Sequence {

    private List<Successor> sequence;

    public Sequence(){
        sequence = new ArrayList<>();
    }

    public Sequence(List<Successor> sequence) {
        this.sequence = sequence;
    }

    public Successor next(State state){
        for(Successor p : sequence){
            if(p.getInitialState().equals(state))return p;
        }
        return null;
    }


    public void update(State state){
        int last_index = 0;
        for(int i =0; i<sequence.size();i++){
            if(sequence.get(i).getInitialState().equals(state))last_index = i;
        }
        sequence = sequence.subList(last_index,sequence.size()-1);
    }

    public Successor goToNext(){
        sequence.remove(0);
        return sequence.get(0);
    }

    public int getNumberOfActions(){
        return sequence.size();
    }
}
