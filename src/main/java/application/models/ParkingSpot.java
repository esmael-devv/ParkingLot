package application.models;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class  ParkingSpot extends BaseModel {

    private Long spotId;
    private Long floorId;
    private VehicleType vehicleType;
    private SpotStatus spotStatus;
}
