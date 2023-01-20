package uni.car.service.data.entity.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.enums.FuelType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_engine")
public class Engine extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @NotBlank
    private String name;

    @NotNull
    private Double displacement;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private FuelType fuelType;

    private double horsePower;
}
