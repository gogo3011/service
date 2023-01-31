package uni.car.service.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.user.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Page<Vehicle> findVehiclesByOwnerId(Long userId, Pageable pageable);
}
