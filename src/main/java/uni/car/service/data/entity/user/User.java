package uni.car.service.data.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.core.Address;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {
    @NotBlank
    private String username;

    @JsonIgnore
    private String password;

    private String firstName;

    private String lastName;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;
    @OneToMany
    private List<Vehicle> vehicles;
}


