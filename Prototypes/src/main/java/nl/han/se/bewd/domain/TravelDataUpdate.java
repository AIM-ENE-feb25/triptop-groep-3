package nl.han.se.bewd.domain;

public class TravelDataUpdate {
    private int travelDataId;
    private String newState;
    private String date;

    public int getTravelDataId() {
        return travelDataId;
    }

    public void setTravelDataId(int travelDataId) {
        this.travelDataId = travelDataId;
    }

    public String getNewState() {
        return newState;
    }

    public void setNewState(String newState) {
        this.newState = newState;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
