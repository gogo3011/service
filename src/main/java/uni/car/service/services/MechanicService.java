package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.enums.Specialization;
import uni.car.service.data.entity.shop.Mechanic;
import uni.car.service.data.repository.MechanicRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MechanicService extends GenericService<Mechanic, MechanicRepository> {

    @Autowired
    MechanicService(MechanicRepository repository) {
        super(repository);
    }

    public List<Mechanic> getMechanicsByRepairShopId(Long repairShopId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Mechanic> result = repository.findMechanicsByRepairShopId(repairShopId, paging);

        if (result.hasContent()) {
            return result.getContent();
        }
        return new ArrayList<>();
    }

    public List<Mechanic> getMechanicsByRepairShopIdAndSpecialization(Long repairShopId, Specialization specialization, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Mechanic> result = repository.findMechanicsByRepairShopIdAndSpecializationsContains(repairShopId, specialization, paging);

        if (result.hasContent()) {
            return result.getContent();
        }
        return new ArrayList<>();
    }
}
