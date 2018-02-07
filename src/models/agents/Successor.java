package models.agents;

/**
 * Created by Florian on 07/02/2018.
 */
public class Successor {

    private State initialState, endingState;
    private Action action;

    public Successor(State initialState, State endingState, Action action) {
        this.initialState = initialState;
        this.endingState = endingState;
        this.action = action;
    }

    public State applyAction(){
        return action.execute();
    }


    public State getInitialState() {
        return initialState;
    }

    public void setInitialState(State initialState) {
        this.initialState = initialState;
    }

    public State getEndingState() {
        return endingState;
    }

    public void setEndingState(State endingState) {
        this.endingState = endingState;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }
}
