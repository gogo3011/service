package uni.car.service.web.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import uni.car.service.data.entity.car.Engine;
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.data.entity.enums.FuelType;
import uni.car.service.services.EngineService;

import java.sql.Date;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {EngineEndpoint.class})
@ExtendWith(SpringExtension.class)
class EngineEndpointTest {
    @Autowired
    private EngineEndpoint engineEndpoint;

    @MockBean
    private EngineService engineService;

    /**
     * Method under test: {@link EngineEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(engineService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/engine/count");
        MockMvcBuilders.standaloneSetup(engineEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link EngineEndpoint#createEngine(Engine)}
     */
    @Test
    void testCreateEngine() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date2);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date3);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(date);
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(date1);
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");
        when(engineService.save((Engine) any())).thenReturn(engine);
        Date date4 = mock(Date.class);
        when(date4.getTime()).thenReturn(10L);
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date6);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date7);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(date4);
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(date5);
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer1);
        engine1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(engine1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/engine/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(engineEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"manufacturer\":{\"id\":123,\"created\":10,\"edited\":10,"
                                        + "\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example\"},\"name\":\"Name\",\"displacement\":10"
                                        + ".0,\"fuelType\":\"DIESEL\",\"horsePower\":10.0}"));
    }

    /**
     * Method under test: {@link EngineEndpoint#deleteEngine(Engine)}
     */
    @Test
    void testDeleteEngine() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date2);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date3);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(date);
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(date1);
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(engine);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/engine/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(engineEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link EngineEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(engineService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/engine/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(engineEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link EngineEndpoint#updateEngine(Engine)}
     */
    @Test
    void testUpdateEngine() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date2);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date3);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");

        Engine engine = new Engine();
        engine.setCreated(date);
        engine.setDeleted(true);
        engine.setDisplacement(10.0d);
        engine.setEdited(date1);
        engine.setFuelType(FuelType.DIESEL);
        engine.setHorsePower(10.0d);
        engine.setId(123L);
        engine.setManufacturer(manufacturer);
        engine.setName("Name");
        when(engineService.save((Engine) any())).thenReturn(engine);
        Date date4 = mock(Date.class);
        when(date4.getTime()).thenReturn(10L);
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date6);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date7);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        Engine engine1 = new Engine();
        engine1.setCreated(date4);
        engine1.setDeleted(true);
        engine1.setDisplacement(10.0d);
        engine1.setEdited(date5);
        engine1.setFuelType(FuelType.DIESEL);
        engine1.setHorsePower(10.0d);
        engine1.setId(123L);
        engine1.setManufacturer(manufacturer1);
        engine1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(engine1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/engine/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(engineEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"manufacturer\":{\"id\":123,\"created\":10,\"edited\":10,"
                                        + "\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example\"},\"name\":\"Name\",\"displacement\":10"
                                        + ".0,\"fuelType\":\"DIESEL\",\"horsePower\":10.0}"));
    }
}

