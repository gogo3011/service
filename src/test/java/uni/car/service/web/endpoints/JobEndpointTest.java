package uni.car.service.web.endpoints;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uni.car.service.data.entity.car.Car;
import uni.car.service.data.entity.car.Engine;
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.data.entity.car.Model;
import uni.car.service.data.entity.core.Address;
import uni.car.service.data.entity.enums.FuelType;
import uni.car.service.data.entity.enums.JobStatus;
import uni.car.service.data.entity.enums.VehicleType;
import uni.car.service.data.entity.job.Job;
import uni.car.service.data.entity.shop.Mechanic;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.data.entity.user.User;
import uni.car.service.data.entity.user.Vehicle;
import uni.car.service.services.JobService;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {JobEndpoint.class})
@ExtendWith(SpringExtension.class)
class JobEndpointTest {
    @Autowired
    private JobEndpoint jobEndpoint;

    @MockBean
    private JobService jobService;

    /**
     * Method under test: {@link JobEndpoint#createJob(Job)}
     */
    @Test
    void testCreateJob() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of JobEndpoint.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(mock(Date.class));
        repairShop.setDeleted(true);
        repairShop.setEdited(mock(Date.class));
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);

        Mechanic mechanic = new Mechanic();
        mechanic.setAge(1);
        mechanic.setCreated(mock(Date.class));
        mechanic.setDeleted(true);
        mechanic.setEdited(mock(Date.class));
        mechanic.setFirstName("Jane");
        mechanic.setId(123L);
        mechanic.setLastName("Doe");
        mechanic.setRepairShop(repairShop);
        mechanic.setSpecializations(new ArrayList<>());

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(mock(Date.class));
        address1.setDeleted(true);
        address1.setEdited(mock(Date.class));
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        RepairShop repairShop1 = new RepairShop();
        repairShop1.setAddress(address1);
        repairShop1.setCreated(mock(Date.class));
        repairShop1.setDeleted(true);
        repairShop1.setEdited(mock(Date.class));
        repairShop1.setId(123L);
        repairShop1.setMechanics(new ArrayList<>());
        repairShop1.setName("Name");
        repairShop1.setSpecializedInManufacturer(manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCreated(mock(Date.class));
        manufacturer2.setDeleted(true);
        manufacturer2.setEdited(mock(Date.class));
        manufacturer2.setId(123L);
        manufacturer2.setLogoUrl("https://example.org/example");
        manufacturer2.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer2);
        engine.setName("Name");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCreated(mock(Date.class));
        manufacturer3.setDeleted(true);
        manufacturer3.setEdited(mock(Date.class));
        manufacturer3.setId(123L);
        manufacturer3.setLogoUrl("https://example.org/example");
        manufacturer3.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer3);
        model.setModelName("Model Name");
        model.setStartDate(mock(Date.class));
        model.setVehicleType(VehicleType.SEDAN);

        Car car = new Car();
        car.setCreated(mock(Date.class));
        car.setDeleted(true);
        car.setEdited(mock(Date.class));
        car.setEngine(engine);
        car.setId(123L);
        car.setModel(model);
        car.setVariant("Variant");

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountryCode("GB");
        address2.setCreated(mock(Date.class));
        address2.setDeleted(true);
        address2.setEdited(mock(Date.class));
        address2.setHouseNumber("42");
        address2.setId(123L);
        address2.setStreet("Street");

        User user = new User();
        user.setAddress(address2);
        user.setCreated(mock(Date.class));
        user.setDeleted(true);
        user.setEdited(mock(Date.class));
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");

        Vehicle vehicle = new Vehicle();
        vehicle.setCar(car);
        vehicle.setColor("Color");
        vehicle.setCreated(mock(Date.class));
        vehicle.setDateOfManufacturing(mock(Date.class));
        vehicle.setDeleted(true);
        vehicle.setEdited(mock(Date.class));
        vehicle.setId(123L);
        vehicle.setOwner(user);
        vehicle.setRegistrationNumber("42");
        vehicle.setVin("Vin");

        Job job = new Job();
        job.setCreated(mock(Date.class));
        job.setDeleted(true);
        job.setEdited(mock(Date.class));
        job.setFinished(mock(Date.class));
        job.setId(123L);
        job.setMechanic(mechanic);
        job.setRepairShop(repairShop1);
        job.setStarted(mock(Date.class));
        job.setStatus(JobStatus.OPEN);
        job.setVehicle(vehicle);
        JobService jobService = mock(JobService.class);
        when(jobService.save((Job) any())).thenReturn(job);
        JobEndpoint jobEndpoint = new JobEndpoint(jobService);

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountryCode("GB");
        address3.setCreated(mock(Date.class));
        address3.setDeleted(true);
        address3.setEdited(mock(Date.class));
        address3.setHouseNumber("42");
        address3.setId(123L);
        address3.setStreet("Street");

        Manufacturer manufacturer4 = new Manufacturer();
        manufacturer4.setCreated(mock(Date.class));
        manufacturer4.setDeleted(true);
        manufacturer4.setEdited(mock(Date.class));
        manufacturer4.setId(123L);
        manufacturer4.setLogoUrl("https://example.org/example");
        manufacturer4.setName("Name");

        RepairShop repairShop2 = new RepairShop();
        repairShop2.setAddress(address3);
        repairShop2.setCreated(mock(Date.class));
        repairShop2.setDeleted(true);
        repairShop2.setEdited(mock(Date.class));
        repairShop2.setId(123L);
        repairShop2.setMechanics(new ArrayList<>());
        repairShop2.setName("Name");
        repairShop2.setSpecializedInManufacturer(manufacturer4);

        Mechanic mechanic1 = new Mechanic();
        mechanic1.setAge(1);
        mechanic1.setCreated(mock(Date.class));
        mechanic1.setDeleted(true);
        mechanic1.setEdited(mock(Date.class));
        mechanic1.setFirstName("Jane");
        mechanic1.setId(123L);
        mechanic1.setLastName("Doe");
        mechanic1.setRepairShop(repairShop2);
        mechanic1.setSpecializations(new ArrayList<>());

        Address address4 = new Address();
        address4.setCity("Oxford");
        address4.setCountryCode("GB");
        address4.setCreated(mock(Date.class));
        address4.setDeleted(true);
        address4.setEdited(mock(Date.class));
        address4.setHouseNumber("42");
        address4.setId(123L);
        address4.setStreet("Street");

        Manufacturer manufacturer5 = new Manufacturer();
        manufacturer5.setCreated(mock(Date.class));
        manufacturer5.setDeleted(true);
        manufacturer5.setEdited(mock(Date.class));
        manufacturer5.setId(123L);
        manufacturer5.setLogoUrl("https://example.org/example");
        manufacturer5.setName("Name");

        RepairShop repairShop3 = new RepairShop();
        repairShop3.setAddress(address4);
        repairShop3.setCreated(mock(Date.class));
        repairShop3.setDeleted(true);
        repairShop3.setEdited(mock(Date.class));
        repairShop3.setId(123L);
        repairShop3.setMechanics(new ArrayList<>());
        repairShop3.setName("Name");
        repairShop3.setSpecializedInManufacturer(manufacturer5);

        Manufacturer manufacturer6 = new Manufacturer();
        manufacturer6.setCreated(mock(Date.class));
        manufacturer6.setDeleted(true);
        manufacturer6.setEdited(mock(Date.class));
        manufacturer6.setId(123L);
        manufacturer6.setLogoUrl("https://example.org/example");
        manufacturer6.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(mock(Date.class));
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(mock(Date.class));
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer6);
        engine1.setName("Name");

        Manufacturer manufacturer7 = new Manufacturer();
        manufacturer7.setCreated(mock(Date.class));
        manufacturer7.setDeleted(true);
        manufacturer7.setEdited(mock(Date.class));
        manufacturer7.setId(123L);
        manufacturer7.setLogoUrl("https://example.org/example");
        manufacturer7.setName("Name");

        Model model1 = new Model();
        model1.setCreated(mock(Date.class));
        model1.setDeleted(true);
        model1.setEdited(mock(Date.class));
        model1.setEndDate(mock(Date.class));
        model1.setId(123L);
        model1.setManufacturer(manufacturer7);
        model1.setModelName("Model Name");
        model1.setStartDate(mock(Date.class));
        model1.setVehicleType(VehicleType.SEDAN);

        Car car1 = new Car();
        car1.setCreated(mock(Date.class));
        car1.setDeleted(true);
        car1.setEdited(mock(Date.class));
        car1.setEngine(engine1);
        car1.setId(123L);
        car1.setModel(model1);
        car1.setVariant("Variant");

        Address address5 = new Address();
        address5.setCity("Oxford");
        address5.setCountryCode("GB");
        address5.setCreated(mock(Date.class));
        address5.setDeleted(true);
        address5.setEdited(mock(Date.class));
        address5.setHouseNumber("42");
        address5.setId(123L);
        address5.setStreet("Street");

        User user1 = new User();
        user1.setAddress(address5);
        user1.setCreated(mock(Date.class));
        user1.setDeleted(true);
        user1.setEdited(mock(Date.class));
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setCar(car1);
        vehicle1.setColor("Color");
        vehicle1.setCreated(mock(Date.class));
        vehicle1.setDateOfManufacturing(mock(Date.class));
        vehicle1.setDeleted(true);
        vehicle1.setEdited(mock(Date.class));
        vehicle1.setId(123L);
        vehicle1.setOwner(user1);
        vehicle1.setRegistrationNumber("42");
        vehicle1.setVin("Vin");

        Job job1 = new Job();
        job1.setCreated(mock(Date.class));
        job1.setDeleted(true);
        job1.setEdited(mock(Date.class));
        job1.setFinished(mock(Date.class));
        job1.setId(123L);
        job1.setMechanic(mechanic1);
        job1.setRepairShop(repairShop3);
        job1.setStarted(mock(Date.class));
        job1.setStatus(JobStatus.OPEN);
        job1.setVehicle(vehicle1);
        ResponseEntity<Job> actualCreateJobResult = jobEndpoint.createJob(job1);
        assertTrue(actualCreateJobResult.hasBody());
        assertTrue(actualCreateJobResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualCreateJobResult.getStatusCode());
        verify(jobService).save((Job) any());
    }

    /**
     * Method under test: {@link JobEndpoint#updateJob(Job)}
     */
    @Test
    void testUpdateJob() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of JobEndpoint.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(mock(Date.class));
        repairShop.setDeleted(true);
        repairShop.setEdited(mock(Date.class));
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);

        Mechanic mechanic = new Mechanic();
        mechanic.setAge(1);
        mechanic.setCreated(mock(Date.class));
        mechanic.setDeleted(true);
        mechanic.setEdited(mock(Date.class));
        mechanic.setFirstName("Jane");
        mechanic.setId(123L);
        mechanic.setLastName("Doe");
        mechanic.setRepairShop(repairShop);
        mechanic.setSpecializations(new ArrayList<>());

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(mock(Date.class));
        address1.setDeleted(true);
        address1.setEdited(mock(Date.class));
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        RepairShop repairShop1 = new RepairShop();
        repairShop1.setAddress(address1);
        repairShop1.setCreated(mock(Date.class));
        repairShop1.setDeleted(true);
        repairShop1.setEdited(mock(Date.class));
        repairShop1.setId(123L);
        repairShop1.setMechanics(new ArrayList<>());
        repairShop1.setName("Name");
        repairShop1.setSpecializedInManufacturer(manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCreated(mock(Date.class));
        manufacturer2.setDeleted(true);
        manufacturer2.setEdited(mock(Date.class));
        manufacturer2.setId(123L);
        manufacturer2.setLogoUrl("https://example.org/example");
        manufacturer2.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer2);
        engine.setName("Name");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCreated(mock(Date.class));
        manufacturer3.setDeleted(true);
        manufacturer3.setEdited(mock(Date.class));
        manufacturer3.setId(123L);
        manufacturer3.setLogoUrl("https://example.org/example");
        manufacturer3.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer3);
        model.setModelName("Model Name");
        model.setStartDate(mock(Date.class));
        model.setVehicleType(VehicleType.SEDAN);

        Car car = new Car();
        car.setCreated(mock(Date.class));
        car.setDeleted(true);
        car.setEdited(mock(Date.class));
        car.setEngine(engine);
        car.setId(123L);
        car.setModel(model);
        car.setVariant("Variant");

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountryCode("GB");
        address2.setCreated(mock(Date.class));
        address2.setDeleted(true);
        address2.setEdited(mock(Date.class));
        address2.setHouseNumber("42");
        address2.setId(123L);
        address2.setStreet("Street");

        User user = new User();
        user.setAddress(address2);
        user.setCreated(mock(Date.class));
        user.setDeleted(true);
        user.setEdited(mock(Date.class));
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");

        Vehicle vehicle = new Vehicle();
        vehicle.setCar(car);
        vehicle.setColor("Color");
        vehicle.setCreated(mock(Date.class));
        vehicle.setDateOfManufacturing(mock(Date.class));
        vehicle.setDeleted(true);
        vehicle.setEdited(mock(Date.class));
        vehicle.setId(123L);
        vehicle.setOwner(user);
        vehicle.setRegistrationNumber("42");
        vehicle.setVin("Vin");

        Job job = new Job();
        job.setCreated(mock(Date.class));
        job.setDeleted(true);
        job.setEdited(mock(Date.class));
        job.setFinished(mock(Date.class));
        job.setId(123L);
        job.setMechanic(mechanic);
        job.setRepairShop(repairShop1);
        job.setStarted(mock(Date.class));
        job.setStatus(JobStatus.OPEN);
        job.setVehicle(vehicle);
        JobService jobService = mock(JobService.class);
        when(jobService.save((Job) any())).thenReturn(job);
        JobEndpoint jobEndpoint = new JobEndpoint(jobService);

        Address address3 = new Address();
        address3.setCity("Oxford");
        address3.setCountryCode("GB");
        address3.setCreated(mock(Date.class));
        address3.setDeleted(true);
        address3.setEdited(mock(Date.class));
        address3.setHouseNumber("42");
        address3.setId(123L);
        address3.setStreet("Street");

        Manufacturer manufacturer4 = new Manufacturer();
        manufacturer4.setCreated(mock(Date.class));
        manufacturer4.setDeleted(true);
        manufacturer4.setEdited(mock(Date.class));
        manufacturer4.setId(123L);
        manufacturer4.setLogoUrl("https://example.org/example");
        manufacturer4.setName("Name");

        RepairShop repairShop2 = new RepairShop();
        repairShop2.setAddress(address3);
        repairShop2.setCreated(mock(Date.class));
        repairShop2.setDeleted(true);
        repairShop2.setEdited(mock(Date.class));
        repairShop2.setId(123L);
        repairShop2.setMechanics(new ArrayList<>());
        repairShop2.setName("Name");
        repairShop2.setSpecializedInManufacturer(manufacturer4);

        Mechanic mechanic1 = new Mechanic();
        mechanic1.setAge(1);
        mechanic1.setCreated(mock(Date.class));
        mechanic1.setDeleted(true);
        mechanic1.setEdited(mock(Date.class));
        mechanic1.setFirstName("Jane");
        mechanic1.setId(123L);
        mechanic1.setLastName("Doe");
        mechanic1.setRepairShop(repairShop2);
        mechanic1.setSpecializations(new ArrayList<>());

        Address address4 = new Address();
        address4.setCity("Oxford");
        address4.setCountryCode("GB");
        address4.setCreated(mock(Date.class));
        address4.setDeleted(true);
        address4.setEdited(mock(Date.class));
        address4.setHouseNumber("42");
        address4.setId(123L);
        address4.setStreet("Street");

        Manufacturer manufacturer5 = new Manufacturer();
        manufacturer5.setCreated(mock(Date.class));
        manufacturer5.setDeleted(true);
        manufacturer5.setEdited(mock(Date.class));
        manufacturer5.setId(123L);
        manufacturer5.setLogoUrl("https://example.org/example");
        manufacturer5.setName("Name");

        RepairShop repairShop3 = new RepairShop();
        repairShop3.setAddress(address4);
        repairShop3.setCreated(mock(Date.class));
        repairShop3.setDeleted(true);
        repairShop3.setEdited(mock(Date.class));
        repairShop3.setId(123L);
        repairShop3.setMechanics(new ArrayList<>());
        repairShop3.setName("Name");
        repairShop3.setSpecializedInManufacturer(manufacturer5);

        Manufacturer manufacturer6 = new Manufacturer();
        manufacturer6.setCreated(mock(Date.class));
        manufacturer6.setDeleted(true);
        manufacturer6.setEdited(mock(Date.class));
        manufacturer6.setId(123L);
        manufacturer6.setLogoUrl("https://example.org/example");
        manufacturer6.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(mock(Date.class));
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(mock(Date.class));
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer6);
        engine1.setName("Name");

        Manufacturer manufacturer7 = new Manufacturer();
        manufacturer7.setCreated(mock(Date.class));
        manufacturer7.setDeleted(true);
        manufacturer7.setEdited(mock(Date.class));
        manufacturer7.setId(123L);
        manufacturer7.setLogoUrl("https://example.org/example");
        manufacturer7.setName("Name");

        Model model1 = new Model();
        model1.setCreated(mock(Date.class));
        model1.setDeleted(true);
        model1.setEdited(mock(Date.class));
        model1.setEndDate(mock(Date.class));
        model1.setId(123L);
        model1.setManufacturer(manufacturer7);
        model1.setModelName("Model Name");
        model1.setStartDate(mock(Date.class));
        model1.setVehicleType(VehicleType.SEDAN);

        Car car1 = new Car();
        car1.setCreated(mock(Date.class));
        car1.setDeleted(true);
        car1.setEdited(mock(Date.class));
        car1.setEngine(engine1);
        car1.setId(123L);
        car1.setModel(model1);
        car1.setVariant("Variant");

        Address address5 = new Address();
        address5.setCity("Oxford");
        address5.setCountryCode("GB");
        address5.setCreated(mock(Date.class));
        address5.setDeleted(true);
        address5.setEdited(mock(Date.class));
        address5.setHouseNumber("42");
        address5.setId(123L);
        address5.setStreet("Street");

        User user1 = new User();
        user1.setAddress(address5);
        user1.setCreated(mock(Date.class));
        user1.setDeleted(true);
        user1.setEdited(mock(Date.class));
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setCar(car1);
        vehicle1.setColor("Color");
        vehicle1.setCreated(mock(Date.class));
        vehicle1.setDateOfManufacturing(mock(Date.class));
        vehicle1.setDeleted(true);
        vehicle1.setEdited(mock(Date.class));
        vehicle1.setId(123L);
        vehicle1.setOwner(user1);
        vehicle1.setRegistrationNumber("42");
        vehicle1.setVin("Vin");

        Job job1 = new Job();
        job1.setCreated(mock(Date.class));
        job1.setDeleted(true);
        job1.setEdited(mock(Date.class));
        job1.setFinished(mock(Date.class));
        job1.setId(123L);
        job1.setMechanic(mechanic1);
        job1.setRepairShop(repairShop3);
        job1.setStarted(mock(Date.class));
        job1.setStatus(JobStatus.OPEN);
        job1.setVehicle(vehicle1);
        ResponseEntity<Job> actualUpdateJobResult = jobEndpoint.updateJob(job1);
        assertTrue(actualUpdateJobResult.hasBody());
        assertTrue(actualUpdateJobResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateJobResult.getStatusCode());
        verify(jobService).save((Job) any());
    }

    /**
     * Method under test: {@link JobEndpoint#deleteJob(Job)}
     */
    @Test
    void testDeleteJob() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R008 Failed to instantiate class under test.
        //   Diffblue Cover was unable to construct an instance of JobEndpoint.
        //   Ensure there is a package-visible constructor or factory method that does not
        //   throw for the class under test.
        //   If such a method is already present but Diffblue Cover does not find it, it can
        //   be specified using custom rules for inputs:
        //   https://docs.diffblue.com/knowledge-base/cli/custom-inputs/
        //   This can happen because the factory method takes arguments, throws, returns null
        //   or returns a subtype.
        //   See https://diff.blue/R008 for further troubleshooting of this issue.

        JobEndpoint jobEndpoint = new JobEndpoint(mock(JobService.class));

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(mock(Date.class));
        repairShop.setDeleted(true);
        repairShop.setEdited(mock(Date.class));
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);

        Mechanic mechanic = new Mechanic();
        mechanic.setAge(1);
        mechanic.setCreated(mock(Date.class));
        mechanic.setDeleted(true);
        mechanic.setEdited(mock(Date.class));
        mechanic.setFirstName("Jane");
        mechanic.setId(123L);
        mechanic.setLastName("Doe");
        mechanic.setRepairShop(repairShop);
        mechanic.setSpecializations(new ArrayList<>());

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(mock(Date.class));
        address1.setDeleted(true);
        address1.setEdited(mock(Date.class));
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        RepairShop repairShop1 = new RepairShop();
        repairShop1.setAddress(address1);
        repairShop1.setCreated(mock(Date.class));
        repairShop1.setDeleted(true);
        repairShop1.setEdited(mock(Date.class));
        repairShop1.setId(123L);
        repairShop1.setMechanics(new ArrayList<>());
        repairShop1.setName("Name");
        repairShop1.setSpecializedInManufacturer(manufacturer1);

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCreated(mock(Date.class));
        manufacturer2.setDeleted(true);
        manufacturer2.setEdited(mock(Date.class));
        manufacturer2.setId(123L);
        manufacturer2.setLogoUrl("https://example.org/example");
        manufacturer2.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer2);
        engine.setName("Name");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCreated(mock(Date.class));
        manufacturer3.setDeleted(true);
        manufacturer3.setEdited(mock(Date.class));
        manufacturer3.setId(123L);
        manufacturer3.setLogoUrl("https://example.org/example");
        manufacturer3.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer3);
        model.setModelName("Model Name");
        model.setStartDate(mock(Date.class));
        model.setVehicleType(VehicleType.SEDAN);

        Car car = new Car();
        car.setCreated(mock(Date.class));
        car.setDeleted(true);
        car.setEdited(mock(Date.class));
        car.setEngine(engine);
        car.setId(123L);
        car.setModel(model);
        car.setVariant("Variant");

        Address address2 = new Address();
        address2.setCity("Oxford");
        address2.setCountryCode("GB");
        address2.setCreated(mock(Date.class));
        address2.setDeleted(true);
        address2.setEdited(mock(Date.class));
        address2.setHouseNumber("42");
        address2.setId(123L);
        address2.setStreet("Street");

        User user = new User();
        user.setAddress(address2);
        user.setCreated(mock(Date.class));
        user.setDeleted(true);
        user.setEdited(mock(Date.class));
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");

        Vehicle vehicle = new Vehicle();
        vehicle.setCar(car);
        vehicle.setColor("Color");
        vehicle.setCreated(mock(Date.class));
        vehicle.setDateOfManufacturing(mock(Date.class));
        vehicle.setDeleted(true);
        vehicle.setEdited(mock(Date.class));
        vehicle.setId(123L);
        vehicle.setOwner(user);
        vehicle.setRegistrationNumber("42");
        vehicle.setVin("Vin");

        Job job = new Job();
        job.setCreated(mock(Date.class));
        job.setDeleted(true);
        job.setEdited(mock(Date.class));
        job.setFinished(mock(Date.class));
        job.setId(123L);
        job.setMechanic(mechanic);
        job.setRepairShop(repairShop1);
        job.setStarted(mock(Date.class));
        job.setStatus(JobStatus.OPEN);
        job.setVehicle(vehicle);
        ResponseEntity actualDeleteJobResult = jobEndpoint.deleteJob(job);
        assertNull(actualDeleteJobResult.getBody());
        assertEquals(HttpStatus.NO_CONTENT, actualDeleteJobResult.getStatusCode());
        assertTrue(actualDeleteJobResult.getHeaders().isEmpty());
        assertTrue(job.isDeleted());
    }

    /**
     * Method under test: {@link JobEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(jobService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/job/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(jobEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link JobEndpoint#listByMechanic(Integer, Integer, Integer, String)}
     */
    @Test
    void testListByMechanic() throws Exception {
        when(jobService.getJobsByRepairShopId((Integer) any(), (Integer) any(), (Integer) any(), (String) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/job/listByMechanic");
        MockHttpServletRequestBuilder paramResult = getResult.param("mechanicId", String.valueOf(1));
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(jobEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link JobEndpoint#listByRepairShop(Integer, Integer, Integer, String)}
     */
    @Test
    void testListByRepairShop() throws Exception {
        when(jobService.getJobsByRepairShopId((Integer) any(), (Integer) any(), (Integer) any(), (String) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/job/listByRepairShop");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageSize", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("repairShopId", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(jobEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

