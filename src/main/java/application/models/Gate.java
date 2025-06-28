package application.models;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public abstract class Gate extends BaseModel {
    private Integer gateNumber;
    private GateType gateType;
}
