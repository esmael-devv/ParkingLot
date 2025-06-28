package application.controller;
import application.dtos.CreateParkingLotRequest;
import application.models.*;
import org.springframework.web.bind.annotation.*;
import application.services.ParkingLotService;

import java.util.ArrayList;
import java.util.List;

//step1: Add RestController annotation
@RestController
@RequestMapping("/api/v1/parking-lot")   // it tells every request that we get to this end point brig=ng it to this(parkinglotcontroller)
                                            // map all the request for this url tot his controller
public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();

    //create parking lot
    //POST

    //1. request validation
    //2.data transformation
    //POST /api/v1/parking-lot
    @PostMapping
    public ParkingLot createParkingLot(@RequestBody CreateParkingLotRequest request){
        validate(request);

        ParkingLot parkingLot = transform(request);
        return parkingLotService.create(parkingLot);
    }

    //GET   /api/v1/parking-lot/{id}
    @GetMapping("/{id}")  // step3: add method level mapping
    public ParkingLot getParkingLotById(@PathVariable("id") Long id){ // step4: add pathvariable
        return ParkingLot.builder().id(id).build();
    }


    private void validate(CreateParkingLotRequest request) {
        if(request.getNumberOfFloors()<0){
            throw new RuntimeException("Number of floors must be greater than 0");
        }
        if(request.getName()==null || request.getAddress() == null){
            throw new RuntimeException("Name and Address cannot be null");
        }

    }

    private ParkingLot transform(CreateParkingLotRequest request){
        List<ParkingFloor> floors = new ArrayList<>();
        for(int i=0;i<request.getNumberOfFloors();i++){
            ParkingFloor floor = ParkingFloor.builder()
                    .floorNumber(i)
                    .build();
            floors.add(floor);
        }
        List<Gate> entrygates = new ArrayList<>();
        for(int i=0; i<request.getNumberOfEntryGates(); i++){
            EntryGate entryGate = EntryGate.builder()
                    .gateNumber(i)
                    .gateType(GateType.ENTRY)
                    .build();
            entrygates.add(entryGate);
        }

        List<Gate> exitgates = new ArrayList<>();
        for(int i=0; i<request.getNumberOfExitGates(); i++){
            ExitGate exitGate = ExitGate.builder()
                    .gateNumber(i)
                    .gateType(GateType.EXIT)
                    .build();
            exitgates.add(exitGate);
        }

        return ParkingLot.builder()
                .name(request.getName())
                .address(request.getAddress())
                .floors(floors)
                .entryGate(entrygates)
                .exitGate(exitgates)
                .build();
    }
}
