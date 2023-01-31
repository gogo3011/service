package uni.car.service.web.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
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
import uni.car.service.data.entity.enums.VehicleType;
import uni.car.service.data.entity.user.User;
import uni.car.service.data.entity.user.Vehicle;
import uni.car.service.data.repository.VehicleRepository;
import uni.car.service.services.VehicleService;

import java.sql.Date;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {VehicleEndpoint.class})
@ExtendWith(SpringExtension.class)
class VehicleEndpointTest {
    @Autowired
    private VehicleEndpoint vehicleEndpoint;

    @MockBean
    private VehicleService vehicleService;

    /**
     * Method under test: {@link VehicleEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(vehicleService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/count");
        MockMvcBuilders.standaloneSetup(vehicleEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link VehicleEndpoint#createVehicle(Vehicle)}
     */
    @Test
    void testCreateVehicle() {

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer1);
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        User user = new User();
        user.setAddress(address);
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
        VehicleRepository vehicleRepository = mock(VehicleRepository.class);
        when(vehicleRepository.save((Vehicle) any())).thenReturn(vehicle);
        VehicleEndpoint vehicleEndpoint = new VehicleEndpoint(new VehicleService(vehicleRepository));

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCreated(mock(Date.class));
        manufacturer2.setDeleted(true);
        manufacturer2.setEdited(mock(Date.class));
        manufacturer2.setId(123L);
        manufacturer2.setLogoUrl("https://example.org/example");
        manufacturer2.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(mock(Date.class));
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(mock(Date.class));
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer2);
        engine1.setName("Name");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCreated(mock(Date.class));
        manufacturer3.setDeleted(true);
        manufacturer3.setEdited(mock(Date.class));
        manufacturer3.setId(123L);
        manufacturer3.setLogoUrl("https://example.org/example");
        manufacturer3.setName("Name");

        Model model1 = new Model();
        model1.setCreated(mock(Date.class));
        model1.setDeleted(true);
        model1.setEdited(mock(Date.class));
        model1.setEndDate(mock(Date.class));
        model1.setId(123L);
        model1.setManufacturer(manufacturer3);
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

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(mock(Date.class));
        address1.setDeleted(true);
        address1.setEdited(mock(Date.class));
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");

        User user1 = new User();
        user1.setAddress(address1);
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
        ResponseEntity<Vehicle> actualCreateVehicleResult = vehicleEndpoint.createVehicle(vehicle1);
        assertTrue(actualCreateVehicleResult.hasBody());
        assertTrue(actualCreateVehicleResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.CREATED, actualCreateVehicleResult.getStatusCode());
        verify(vehicleRepository).save((Vehicle) any());
    }

    /**
     * Method under test: {@link VehicleEndpoint#createVehicle(Vehicle)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreateVehicle2() {
        VehicleEndpoint vehicleEndpoint = new VehicleEndpoint(null);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer1);
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        User user = new User();
        user.setAddress(address);
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
        vehicleEndpoint.createVehicle(vehicle);
    }

    /**
     * Method under test: {@link VehicleEndpoint#updateVehicle(Vehicle)}
     */
    @Test
    void testUpdateVehicle() {

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer1);
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        User user = new User();
        user.setAddress(address);
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
        VehicleRepository vehicleRepository = mock(VehicleRepository.class);
        when(vehicleRepository.save((Vehicle) any())).thenReturn(vehicle);
        VehicleEndpoint vehicleEndpoint = new VehicleEndpoint(new VehicleService(vehicleRepository));

        Manufacturer manufacturer2 = new Manufacturer();
        manufacturer2.setCreated(mock(Date.class));
        manufacturer2.setDeleted(true);
        manufacturer2.setEdited(mock(Date.class));
        manufacturer2.setId(123L);
        manufacturer2.setLogoUrl("https://example.org/example");
        manufacturer2.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(mock(Date.class));
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(mock(Date.class));
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer2);
        engine1.setName("Name");

        Manufacturer manufacturer3 = new Manufacturer();
        manufacturer3.setCreated(mock(Date.class));
        manufacturer3.setDeleted(true);
        manufacturer3.setEdited(mock(Date.class));
        manufacturer3.setId(123L);
        manufacturer3.setLogoUrl("https://example.org/example");
        manufacturer3.setName("Name");

        Model model1 = new Model();
        model1.setCreated(mock(Date.class));
        model1.setDeleted(true);
        model1.setEdited(mock(Date.class));
        model1.setEndDate(mock(Date.class));
        model1.setId(123L);
        model1.setManufacturer(manufacturer3);
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

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(mock(Date.class));
        address1.setDeleted(true);
        address1.setEdited(mock(Date.class));
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");

        User user1 = new User();
        user1.setAddress(address1);
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
        ResponseEntity<Vehicle> actualUpdateVehicleResult = vehicleEndpoint.updateVehicle(vehicle1);
        assertTrue(actualUpdateVehicleResult.hasBody());
        assertTrue(actualUpdateVehicleResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualUpdateVehicleResult.getStatusCode());
        verify(vehicleRepository).save((Vehicle) any());
    }

    /**
     * Method under test: {@link VehicleEndpoint#updateVehicle(Vehicle)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdateVehicle2() {

        VehicleEndpoint vehicleEndpoint = new VehicleEndpoint(null);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(mock(Date.class));
        manufacturer.setDeleted(true);
        manufacturer.setEdited(mock(Date.class));
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(mock(Date.class));
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(mock(Date.class));
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(mock(Date.class));
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(mock(Date.class));
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Model model = new Model();
        model.setCreated(mock(Date.class));
        model.setDeleted(true);
        model.setEdited(mock(Date.class));
        model.setEndDate(mock(Date.class));
        model.setId(123L);
        model.setManufacturer(manufacturer1);
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

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(mock(Date.class));
        address.setDeleted(true);
        address.setEdited(mock(Date.class));
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");

        User user = new User();
        user.setAddress(address);
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
        vehicleEndpoint.updateVehicle(vehicle);
    }

    /**
     * Method under test: {@link VehicleEndpoint#deleteVehicle(Vehicle)}
     */
    @Test
    void testDeleteVehicle() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);
        Date date4 = mock(Date.class);
        when(date4.getTime()).thenReturn(10L);
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date4);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date5);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(date2);
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(date3);
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);
        Date date8 = mock(Date.class);
        when(date8.getTime()).thenReturn(10L);
        Date date9 = mock(Date.class);
        when(date9.getTime()).thenReturn(10L);
        Date date10 = mock(Date.class);
        when(date10.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date9);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date10);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");
        Date date11 = mock(Date.class);
        when(date11.getTime()).thenReturn(10L);

        Model model = new Model();
        model.setCreated(date6);
        model.setDeleted(true);
        model.setEdited(date7);
        model.setEndDate(date8);
        model.setId(123L);
        model.setManufacturer(manufacturer1);
        model.setModelName("Model Name");
        model.setStartDate(date11);
        model.setVehicleType(VehicleType.SEDAN);

        Car car = new Car();
        car.setCreated(date);
        car.setDeleted(true);
        car.setEdited(date1);
        car.setEngine(engine);
        car.setId(123L);
        car.setModel(model);
        car.setVariant("Variant");
        Date date12 = mock(Date.class);
        when(date12.getTime()).thenReturn(10L);
        Date date13 = mock(Date.class);
        when(date13.getTime()).thenReturn(10L);
        Date date14 = mock(Date.class);
        when(date14.getTime()).thenReturn(10L);
        Date date15 = mock(Date.class);
        when(date15.getTime()).thenReturn(10L);
        Date date16 = mock(Date.class);
        when(date16.getTime()).thenReturn(10L);

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(date15);
        address.setDeleted(true);
        address.setEdited(date16);
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");
        Date date17 = mock(Date.class);
        when(date17.getTime()).thenReturn(10L);
        Date date18 = mock(Date.class);
        when(date18.getTime()).thenReturn(10L);

        User user = new User();
        user.setAddress(address);
        user.setCreated(date17);
        user.setDeleted(true);
        user.setEdited(date18);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");

        Vehicle vehicle = new Vehicle();
        vehicle.setCar(car);
        vehicle.setColor("Color");
        vehicle.setCreated(date12);
        vehicle.setDateOfManufacturing(date13);
        vehicle.setDeleted(true);
        vehicle.setEdited(date14);
        vehicle.setId(123L);
        vehicle.setOwner(user);
        vehicle.setRegistrationNumber("42");
        vehicle.setVin("Vin");
        String content = (new ObjectMapper()).writeValueAsString(vehicle);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/vehicle/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(vehicleEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link VehicleEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(vehicleService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/vehicle/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(vehicleEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link VehicleEndpoint#load(Long, Integer, Integer, String)}
     */
    @Test
    void testLoad() throws Exception {
        when(vehicleService.getVehiclesByUserId((Long) any(), (Integer) any(), (Integer) any(), (String) any()))
                .thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/vehicle/listByUserId");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("userId", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(vehicleEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}

