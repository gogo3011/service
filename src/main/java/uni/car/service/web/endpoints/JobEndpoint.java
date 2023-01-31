package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.job.Job;
import uni.car.service.services.JobService;

import java.util.List;

@RestController
@RequestMapping("api/job")
@AllArgsConstructor
public class JobEndpoint {

    private final JobService jobService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Job>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Job> list = jobService.getAll(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/listByRepairShop")
    public ResponseEntity<List<Job>> listByRepairShop(
            @RequestParam(required = true) Integer repairShopId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Job> list = jobService.getJobsByRepairShopId(repairShopId, pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/listByMechanic")
    public ResponseEntity<List<Job>> listByMechanic(
            @RequestParam(required = true) Integer mechanicId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Job> list = jobService.getJobsByRepairShopId(mechanicId, pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Job> createJob(
            @RequestBody Job toCreate
    ) {
        return new ResponseEntity<>(jobService.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Job> updateJob(
            @RequestBody Job toUpdate
    ) {
        return new ResponseEntity<>(jobService.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteJob(
            @RequestBody Job toDelete
    ) {
        toDelete.setDeleted(true);
        jobService.save(toDelete);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
