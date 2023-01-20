package uni.car.service.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.shop.RepairShop;

public interface RepairShopRepository extends JpaRepository<RepairShop, Long> {
    Page<RepairShop> findRepairShopsBySpecializedInManufacturerContains(Long manufacturerId, Pageable pageable);
}
