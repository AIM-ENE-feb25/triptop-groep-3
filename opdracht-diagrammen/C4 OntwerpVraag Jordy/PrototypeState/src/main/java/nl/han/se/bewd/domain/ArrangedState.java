package nl.han.se.bewd.domain;

public class ArrangedState implements TravelDataState {
    @Override
    public TravelDataState UpdateState(String state, String date) {
        return new PaidState();
    }
}
