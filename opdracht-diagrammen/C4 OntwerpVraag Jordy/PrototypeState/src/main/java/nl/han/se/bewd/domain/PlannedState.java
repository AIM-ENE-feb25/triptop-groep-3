package nl.han.se.bewd.domain;

public class PlannedState implements TravelDataState {
    private String plannedDate;

    @Override
    public TravelDataState UpdateState(String state, String date) {
        return null;
    }

    public String getState() {
        return "Planned";
    }
}
