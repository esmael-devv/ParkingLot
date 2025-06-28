package application.models;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder
public abstract class BaseModel {
    private Long id;
    private Date createdAt;
    private Date updatedAt;
}
