package uni.car.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.car.Engine;

public interface EngineRepository extends JpaRepository<Engine, Long> {
}
