package uni.car.service.data.entity.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.data.entity.core.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_repairshop")
public class RepairShop extends BaseEntity {
    @NotBlank
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Mechanic> mechanics;

    @OneToOne
    private Manufacturer specializedInManufacturer;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
