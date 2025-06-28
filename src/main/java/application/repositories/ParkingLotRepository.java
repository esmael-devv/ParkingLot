package application.repositories;

import application.models.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotRepository {
    private List<ParkingLot> parkingLots = new ArrayList<>();

    public ParkingLot saveParkingLot(ParkingLot parkingLot) {
        parkingLots.add(parkingLot);
        return parkingLot;
    }

    public List<ParkingLot> findAllParkingLots() {
        return parkingLots;
    }
}
