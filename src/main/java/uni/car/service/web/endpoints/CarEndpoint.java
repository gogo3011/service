package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.car.Car;
import uni.car.service.services.CarService;

import java.util.List;

@RestController
@RequestMapping("api/car")
@AllArgsConstructor
public class CarEndpoint {
    private CarService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Car>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Car> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Car> createCar(
            @RequestBody Car toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Car> updateCar(
            @RequestBody Car toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteCar(
            @RequestBody Car toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
