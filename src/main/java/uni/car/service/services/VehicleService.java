package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.user.Vehicle;
import uni.car.service.data.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleService extends GenericService<Vehicle, VehicleRepository> {
    @Autowired
    public VehicleService(VehicleRepository repository) {
        super(repository);
    }

    public List<Vehicle> getVehiclesByUserId(Long userId, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Vehicle> result = repository.findVehiclesByOwnerId(userId, paging);

        if (result.hasContent()) {
            return result.getContent();
        } else {
            return new ArrayList<>();
        }
    }
}
