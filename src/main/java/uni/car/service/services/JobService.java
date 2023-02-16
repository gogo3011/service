package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.job.Job;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.data.repository.JobRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService extends GenericService<Job, JobRepository> {

    private RepairShopService repairShopService;

    @Autowired
    JobService(JobRepository repository, RepairShopService repairShopService) {
        super(repository);
        this.repairShopService = repairShopService;
    }

    @Override
    public Job save(Job toSave) {
        RepairShop repairShop = this.repairShopService.load(toSave.getRepairShop().getId());
        if (toSave.getRepairShop().getSpecializedInManufacturer() != null &&
                repairShop.getSpecializedInManufacturer().getId() != toSave.getVehicle().getCar().getModel().getManufacturer().getId()) {
            throw new IllegalArgumentException();
        }
        return super.save(toSave);
    }

    public List<Job> getJobsByRepairShopId(Integer repairShopId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Job> result = repository.findAllJobsByRepairShopId(repairShopId.longValue(), paging);

        if (result.hasContent()) {
            return result.getContent();
        }
        return new ArrayList<>();
    }

    public List<Job> getJobsByMechanicId(Integer repairShopId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Job> result = repository.findAllByMechanicId(repairShopId.longValue(), paging);

        if (result.hasContent()) {
            return result.getContent();
        }
        return new ArrayList<>();
    }
}
