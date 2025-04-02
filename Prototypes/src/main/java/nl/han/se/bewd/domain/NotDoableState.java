package nl.han.se.bewd.domain;

public class NotDoableState implements TravelDataState {
    @Override
    public TravelDataState UpdateState(String state, String date) {
        System.out.println("This activity is unable to be executed, and can thus not be updated.");
        return this;
    }

    public String getState() {
        return "NotDoable";
    }
}
