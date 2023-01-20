package uni.car.service.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uni.car.service.data.entity.user.User;
import uni.car.service.data.repository.UserRepository;

@Service
public class UserService extends GenericService<User, UserRepository> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }
}
