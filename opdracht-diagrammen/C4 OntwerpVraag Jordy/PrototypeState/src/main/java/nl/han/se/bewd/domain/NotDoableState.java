package nl.han.se.bewd.domain;

public class NotDoableState implements TravelDataState {
    @Override
    public TravelDataState UpdateState(String state, String date) {
        return this;
    }
}
