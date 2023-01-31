package uni.car.service.web.endpoints;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uni.car.service.data.entity.user.User;
import uni.car.service.services.UserService;

import java.util.List;

@RestController
@RequestMapping("api/user")
@AllArgsConstructor
public class UserEndpoint {
    private UserService service;

    @GetMapping(path = "/list")
    public ResponseEntity<List<User>> list(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        List<User> result = service.getAll(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(path = "/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity<>(service.count(), HttpStatus.OK);
    }

    @GetMapping(path = "/load")
    public ResponseEntity<User> load(@RequestParam(required = true) Long id) {
        return new ResponseEntity<>(service.load(id), HttpStatus.OK);
    }

    @PostMapping(path = "/create")
    public ResponseEntity<User> createUser(
            @RequestBody User toCreate
    ) {
        return new ResponseEntity<>(service.save(toCreate), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<User> updateUser(
            @RequestBody User toUpdate
    ) {
        return new ResponseEntity<>(service.save(toUpdate), HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity deleteUser(
            @RequestBody User toDelete
    ) {
        toDelete.setDeleted(true);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
