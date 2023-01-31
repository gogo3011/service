package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.enums.Specialization;
import uni.car.service.data.entity.shop.Mechanic;
import uni.car.service.services.MechanicService;

import java.util.List;

@RestController
@RequestMapping("api/mechanic")
@AllArgsConstructor
public class MechanicEndpoint {

    private MechanicService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Mechanic>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Mechanic> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/listByRepairShop")
    public ResponseEntity<List<Mechanic>> listByRepairShop(
            @RequestParam(required = true) Long repairShopId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Mechanic> list = service.getMechanicsByRepairShopId(repairShopId, pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/listByRepairShopAndSpecialization")
    public ResponseEntity<List<Mechanic>> listByRepairShop(
            @RequestParam(required = true) Long repairShopId,
            @RequestParam(required = true) Specialization specialization,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Mechanic> list = service.getMechanicsByRepairShopIdAndSpecialization(repairShopId, specialization, pageNo, pageSize, sortBy);

        return new ResponseEntity<>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Mechanic> createModel(
            @RequestBody Mechanic toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Mechanic> updateModel(
            @RequestBody Mechanic toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteModel(
            @RequestBody Mechanic toDelete
    ) {
        toDelete.setDeleted(true);
        service.save(toDelete);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
