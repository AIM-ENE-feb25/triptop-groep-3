package nl.han.se.bewd.domain;

import java.util.Objects;

public class ArrangedState implements TravelDataState {
    @Override
    public TravelDataState UpdateState(String state, String date) {
        if(Objects.equals(state, "Paid")) {
            return new PaidState();
        } else if (Objects.equals(state, "NotDoable")){
            return new NotDoableState();
        } else if (Objects.equals(state, "Done")){
            return new DoneState(date);
        } else {
            System.out.println("This state can only be updated to paid, not doable or done.");
            return this;
        }
    }
}
