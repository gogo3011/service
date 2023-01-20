package uni.car.service.data.entity.shop;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.enums.Specialization;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_mechanic")
public class Mechanic extends BaseEntity {
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Min(value = 16)
    private int age;

    @OneToOne()
    @JoinColumn(name = "repairshop_id")
    private RepairShop repairShop;

    @NotEmpty
    @ElementCollection(targetClass = Specialization.class)
    @CollectionTable
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(EnumType.STRING)
    private List<Specialization> specializations;
}
