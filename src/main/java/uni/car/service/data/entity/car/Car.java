package uni.car.service.data.entity.car;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_car")
public class Car extends BaseEntity {

    @ManyToOne
    @NotNull
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @NotBlank
    private String variant;

}
