package application.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder
@Data
@Getter
public class ParkingLot extends BaseModel {
    private String name;
    private String address;
    @Builder.Default
    private List<ParkingFloor> floors = new ArrayList<>();
    @Builder.Default
    private List<Gate> entryGate = new ArrayList<>();
    @Builder.Default
    private List<Gate> exitGate = new ArrayList<>();
    private DisplayBoard displayBoard;
}
