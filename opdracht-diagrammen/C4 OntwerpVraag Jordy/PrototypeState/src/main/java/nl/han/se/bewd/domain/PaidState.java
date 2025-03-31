package nl.han.se.bewd.domain;

public class PaidState implements TravelDataState {
    @Override
    public TravelDataState UpdateState(String state, String date) {
        if(state == "done") {
            return new DoneState(date);
        } else {
            return this;
        }
    }
}

