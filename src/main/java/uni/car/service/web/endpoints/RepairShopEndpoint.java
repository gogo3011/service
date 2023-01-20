package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.services.RepairShopService;

import java.util.List;

@RestController
@RequestMapping("api/repairShop/")
@AllArgsConstructor
public class RepairShopEndpoint {

    private final RepairShopService repairShopService;

    @GetMapping(path = "/list")
    public ResponseEntity<List<RepairShop>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<RepairShop> result = repairShopService.getAll(pageNo, pageSize, sortBy);

        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/load")
    public ResponseEntity<RepairShop> load(
            @RequestParam(required = true) Long id
    ) {
        return new ResponseEntity<>(repairShopService.load(id), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/listByManufacturerId")
    public ResponseEntity<List<RepairShop>> listByManufacturerId(
            @RequestParam(required = true) Long manufacturerId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<RepairShop> result = repairShopService.getRepairShopsByManufacturerId(manufacturerId, pageNo, pageSize, sortBy);

        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<RepairShop> createRepairShop(
            @RequestBody RepairShop toCreate
    ) {
        return new ResponseEntity<>(repairShopService.save(toCreate), new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<RepairShop> updateRepairShop(
            @RequestBody RepairShop toCreate
    ) {
        return new ResponseEntity<>(repairShopService.save(toCreate), new HttpHeaders(), HttpStatus.CREATED);
    }
}
