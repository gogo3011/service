package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.car.Model;
import uni.car.service.data.repository.ModelRepository;

@Service
public class ModelService extends GenericService<Model, ModelRepository> {
    @Autowired
    public ModelService(ModelRepository repository) {
        super(repository);
    }
}
