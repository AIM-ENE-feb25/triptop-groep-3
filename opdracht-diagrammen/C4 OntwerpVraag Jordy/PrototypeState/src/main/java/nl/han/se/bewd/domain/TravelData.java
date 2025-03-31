package nl.han.se.bewd.domain;

public class TravelData {
    private String travelDataDescription;
    private String DataType;
    private String sourceLink;
    private int travelerId;
    private TravelDataState currentState;

    public void update(String state, String date) {
        currentState = currentState.UpdateState(state, date);
    }
}
