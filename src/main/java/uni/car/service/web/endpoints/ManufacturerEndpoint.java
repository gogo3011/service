package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.services.ManufacturerService;

import java.util.List;

@RestController
@RequestMapping("api/manufacturer")
@AllArgsConstructor
public class ManufacturerEndpoint {
    private ManufacturerService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Manufacturer>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Manufacturer> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Manufacturer> createManufacturer(
            @RequestBody Manufacturer toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Manufacturer> updateManufacturer(
            @RequestBody Manufacturer toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteManufacturer(
            @RequestBody Manufacturer toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
