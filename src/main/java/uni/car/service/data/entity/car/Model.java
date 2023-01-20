package uni.car.service.data.entity.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.enums.VehicleType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_model")
public class Model extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @NotBlank
    private String modelName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private VehicleType vehicleType;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;
}
