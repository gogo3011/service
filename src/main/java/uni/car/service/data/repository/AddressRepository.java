package uni.car.service.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.core.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
