package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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
}
