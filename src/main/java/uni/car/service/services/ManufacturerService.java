package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.data.repository.ManufacturerRepository;

@Service
public class ManufacturerService extends GenericService<Manufacturer, ManufacturerRepository> {

    @Autowired
    public ManufacturerService(ManufacturerRepository repository) {
        super(repository);
    }

}
