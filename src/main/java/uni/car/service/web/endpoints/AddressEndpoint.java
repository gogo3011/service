package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.core.Address;
import uni.car.service.services.AddressService;

import java.util.List;

@RestController
@RequestMapping("api/address")
@AllArgsConstructor
public class AddressEndpoint {
    private AddressService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Address>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Address> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Address> createAddress(
            @RequestBody Address toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Address> updateAddress(
            @RequestBody Address toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteAddress(
            @RequestBody Address toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
