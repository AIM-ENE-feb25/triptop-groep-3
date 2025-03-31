package nl.han.se.bewd.controllers;

import nl.han.se.bewd.domain.TravelData;
import java.util.ArrayList;
import java.util.List;

public class TravelDataController {
    private List<TravelData> travelDataList = new ArrayList<>();
    public void addTravelData(TravelData travelData) {
        if (travelData != null) {
            travelDataList.add(travelData);
        } else {
            throw new IllegalArgumentException("TravelData cannot be null.");
        }
    }

    public TravelData updateTravelDataState(int travelerId, String newState, String date) {
        for (TravelData travelData : travelDataList) {
            if (travelData.getTravelerId() == travelerId) {
                travelData.update(newState, date);
                return travelData;
            }
        }
        throw new IllegalArgumentException("TravelData with ID " + travelerId + " not found.");
    }

    public void displayAllTravelData() {
        if (travelDataList.isEmpty()) {
            System.out.println("No TravelData available to display.");
            return;
        }
        for (TravelData travelData : travelDataList) {
            System.out.println("ID: " + travelData.getTravelerId() +
                    ", Description: " + travelData.getTravelDataDescription() +
                    ", Current State: " + travelData.getCurrentState().getClass().getSimpleName());
        }
    }
}
