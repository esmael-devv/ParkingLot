package application.services;

import application.models.ParkingLot;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ParkingLotService {

    private final Map<Long, ParkingLot> db = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ParkingLot create(ParkingLot parkingLot) {
        //call your repository class to save your parkinglot
       parkingLot.setId(idCounter.getAndIncrement());
       db.put(parkingLot.getId(), parkingLot);
       return parkingLot;
    }

    public ParkingLot getParkingLotById(Long id) {
        return ParkingLot.builder().id(id).build();
    }
}
