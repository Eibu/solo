package models.agents;

/**
 * Created by Florian on 06/02/2018.
 */
public class Action {

    protected State start, end;

    public Action(State start, State end) {
        this.start = start;
        this.end = end;
    }


    public void execute(Agent agent){
    }

    public State getStart() {
        return start;
    }

    public void setStart(State start) {
        this.start = start;
    }

    public State getEnd() {
        return end;
    }

    public void setEnd(State end) {
        this.end = end;
    }
}
