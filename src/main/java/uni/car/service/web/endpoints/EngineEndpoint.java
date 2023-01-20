package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.car.Engine;
import uni.car.service.services.EngineService;

import java.util.List;

@RestController
@RequestMapping("api/engine")
@AllArgsConstructor
public class EngineEndpoint {
    private EngineService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Engine>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Engine> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Engine> createEngine(
            @RequestBody Engine toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Engine> updateEngine(
            @RequestBody Engine toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteEngine(
            @RequestBody Engine toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
