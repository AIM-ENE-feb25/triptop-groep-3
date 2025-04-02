package nl.han.se.bewd.domain;

public class TravelData {

    private String travelDataDescription;
    private int travelerId;
    private int travelDataId;
    private TravelDataState currentState;

    public String getTravelDataDescription() {
        return travelDataDescription;
    }

    public void setTravelDataDescription(String travelDataDescription) {
        this.travelDataDescription = travelDataDescription;
    }

    public int getTravelDataId() {
        return travelDataId;
    }

    public void setTravelDataId(int travelDataId) {
        this.travelDataId = travelDataId;
    }

    public int getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(int travelerId) {
        this.travelerId = travelerId;
    }

    public TravelDataState getCurrentState() {
        return currentState;
    }

    public void update(String state, String date) {
        if(currentState != null) {
            currentState = currentState.UpdateState(state, date);
        } else {
            currentState = new PlannedState();
        }
    }

}
