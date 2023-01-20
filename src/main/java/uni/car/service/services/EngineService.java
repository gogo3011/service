package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.car.Engine;
import uni.car.service.data.repository.EngineRepository;

@Service
public class EngineService extends GenericService<Engine, EngineRepository> {
    @Autowired
    public EngineService(EngineRepository repository) {
        super(repository);
    }
}
