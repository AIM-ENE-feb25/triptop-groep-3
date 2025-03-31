package nl.han.se.bewd.domain;

public class TravelData {
    public String getTravelDataDescription() {
        return travelDataDescription;
    }

    public void setTravelDataDescription(String travelDataDescription) {
        this.travelDataDescription = travelDataDescription;
    }

    public String getDataType() {
        return DataType;
    }

    public void setDataType(String dataType) {
        DataType = dataType;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }

    public int getTravelDataId() {
        return TravelDataId;
    }

    public void setTravelDataId(int travelDataId) {
        TravelDataId = travelDataId;
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

    private String travelDataDescription;
    private String DataType;
    private String sourceLink;
    private int travelerId;
    private int TravelDataId;
    private TravelDataState currentState;


    public void update(String state, String date) {
        currentState = currentState.UpdateState(state, date);
    }

}
