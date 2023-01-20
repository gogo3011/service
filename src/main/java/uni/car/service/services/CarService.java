package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.car.Car;
import uni.car.service.data.repository.CarRepository;

@Service
public class CarService extends GenericService<Car, CarRepository> {
    @Autowired
    CarService(CarRepository repository) {
        super(repository);
    }
}
