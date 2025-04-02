package nl.han.se.bewd.controllers;

import nl.han.se.bewd.domain.TravelData;
import nl.han.se.bewd.domain.TravelDataUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/travelData")
public class TravelDataController {
    private List<TravelData> travelDataList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<TravelData> addTravelData(@RequestBody TravelData travelData) {
        if (travelData != null) {
            travelData.update(null, null);
            travelDataList.add(travelData);
            return ResponseEntity.ok(travelData);
        } else {
            throw new IllegalArgumentException("TravelData cannot be null.");
        }
    }

    @PutMapping
    public ResponseEntity<TravelData> updateTravelDataState(@RequestBody TravelDataUpdate travelDataUpdate) {
        for (TravelData travelData : travelDataList) {
            if (travelData.getTravelDataId() == travelDataUpdate.getTravelDataId()) {
                travelData.update(travelDataUpdate.getNewState(), travelDataUpdate.getDate());
                return ResponseEntity.ok(travelData);
            }
        }
        throw new IllegalArgumentException("TravelData with ID " + travelDataUpdate.getTravelDataId() + " not found.");
    }

    @GetMapping
    public ResponseEntity<List<TravelData>> displayAllTravelData() {
        if (travelDataList.isEmpty()) {
            throw new IllegalArgumentException("No travel data found.");
        } else {
            return ResponseEntity.ok(travelDataList);
        }
    }
}
