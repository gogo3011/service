package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.data.repository.RepairShopRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepairShopService extends GenericService<RepairShop, RepairShopRepository> {

    @Autowired
    RepairShopService(RepairShopRepository repository) {
        super(repository);
    }

    public List<RepairShop> getRepairShopsByManufacturerId(Long manufacturerId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<RepairShop> result = repository.findRepairShopsBySpecializedInManufacturerContains(manufacturerId, paging);

        if (result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
