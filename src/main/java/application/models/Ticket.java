package application.models;

import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@SuperBuilder
public class Ticket extends BaseModel{
    private Long vehicleId;
    private LocalDateTime entryTime;
    private Long spotId;
}
