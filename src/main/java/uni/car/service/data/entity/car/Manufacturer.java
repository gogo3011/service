package uni.car.service.data.entity.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.URL;
import uni.car.service.data.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_manufacturer")
public class Manufacturer extends BaseEntity {
    @NotBlank
    private String name;
    @URL
    private String logoUrl;
}
