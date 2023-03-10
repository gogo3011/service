package uni.car.service.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.BaseEntity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class GenericService<T extends BaseEntity, K extends JpaRepository<T, Long>> {

    GenericService(K repository) {
        this.repository = repository;
    }

    protected K repository;

    public T load(long id) {
        return repository.findById(id).get();
    }

    public List<T> getAll(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<T> result = repository.findAll(paging);

        if (result.hasContent()) {
            return result.getContent();
        }
        return new ArrayList<>();
    }

    public T save(T toSave) {
        if (toSave.getId() <= 1) {
            toSave.setCreated(new Date(System.currentTimeMillis()));
        }
        toSave.setEdited(new Date(System.currentTimeMillis()));
        return repository.save(toSave);
    }

    public long count() {
        return repository.count();
    }

}
