package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.user.Vehicle;
import uni.car.service.data.repository.VehicleRepository;

@Service
public class VehicleService extends GenericService<Vehicle, VehicleRepository> {

    @Autowired
    public VehicleService(VehicleRepository repository) {
        super(repository);
    }
}
