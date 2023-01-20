package uni.car.service.data.entity.job;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uni.car.service.data.entity.BaseEntity;
import uni.car.service.data.entity.enums.JobStatus;
import uni.car.service.data.entity.shop.Mechanic;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.data.entity.user.Vehicle;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_job")
public class Job extends BaseEntity {
    @NotNull
    @OneToOne
    private RepairShop repairShop;
    @NotNull
    @ManyToOne
    @JoinColumn(name="vehicle_id")
    private Vehicle vehicle;
    @NotNull
    @OneToOne
    private Mechanic mechanic;
    @NotNull
    private Date started;
    @NotNull
    private Date finished;
    @Enumerated(EnumType.STRING)
    private JobStatus status;
}
