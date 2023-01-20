package uni.car.service.data.entity.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.car.Car;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_vehicle")
public class Vehicle extends BaseEntity {
    @NotBlank
    private String registrationNumber;
    @NotBlank
    private String vin;
    @NotNull
    private Date dateOfManufacturing;
    @NotBlank
    private String color;
    @OneToOne
    @NotNull
    private Car car;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

}
