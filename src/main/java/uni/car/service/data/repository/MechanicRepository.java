package uni.car.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.shop.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {
}
