package uni.car.service.data.entity.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uni.car.service.data.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "t_address")
public class Address extends BaseEntity {
    @NotBlank
    private String countryCode;

    private String houseNumber;
    @NotBlank
    private String city;
    @NotBlank
    private String street;
}
