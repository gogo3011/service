package uni.car.service.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uni.car.service.data.entity.enums.Specialization;
import uni.car.service.data.entity.shop.Mechanic;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

    Page<Mechanic> findMechanicsByRepairShopId(Long repairShopId, Pageable pageable);

    Page<Mechanic> findMechanicsByRepairShopIdAndSpecializationsContains
            (Long repairShopId, Specialization specialization, Pageable pageable);
}
