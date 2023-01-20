package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.core.Address;
import uni.car.service.data.repository.AddressRepository;

@Service
public class AddressService extends GenericService<Address, AddressRepository> {
    @Autowired
    AddressService(AddressRepository repository) {
        super(repository);
    }
}
