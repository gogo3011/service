package uni.car.service.data.entity.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_car")
public class Car extends BaseEntity {

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @NotNull
    @JoinColumn(name = "engine_id")
    private Engine engine;

    private String variant;

}
