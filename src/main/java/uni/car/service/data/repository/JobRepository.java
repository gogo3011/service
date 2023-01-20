package uni.car.service.data.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uni.car.service.data.entity.job.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
    Page<Job> findAllJobsByRepairShopId(long repairShopId, Pageable pageable);
}
