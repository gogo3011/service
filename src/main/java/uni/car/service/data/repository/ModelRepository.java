package uni.car.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.car.Model;

public interface ModelRepository extends JpaRepository<Model, Long> {
}
