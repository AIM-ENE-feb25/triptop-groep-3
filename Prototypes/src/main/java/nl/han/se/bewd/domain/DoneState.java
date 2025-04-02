package nl.han.se.bewd.domain;

public class DoneState implements TravelDataState {
    private String dateDone;

    public DoneState (String dateDone){
        this.dateDone = dateDone;
    }

    @Override
    public TravelDataState UpdateState(String state, String date) {
        System.out.println("This activity has been executed at " + dateDone + ". And can thus not be updated.");
        return this;
    }

    public String getState() {
        return "Done";
    }
}
