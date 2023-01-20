package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.car.Model;
import uni.car.service.services.ModelService;

import java.util.List;

@RestController
@RequestMapping("api/model")
@AllArgsConstructor
public class ModelEndpoint {
    private ModelService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<Model>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<Model> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Model> createModel(
            @RequestBody Model toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Model> updateModel(
            @RequestBody Model toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteModel(
            @RequestBody Model toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
