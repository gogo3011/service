package uni.car.service.web.endpoints;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Date;
import java.util.ArrayList;

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
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.data.entity.car.Model;
import uni.car.service.data.entity.enums.VehicleType;
import uni.car.service.services.ModelService;

@ContextConfiguration(classes = {ModelEndpoint.class})
@ExtendWith(SpringExtension.class)
class ModelEndpointTest {
    @Autowired
    private ModelEndpoint modelEndpoint;

    @MockBean
    private ModelService modelService;

    /**
     * Method under test: {@link ModelEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(modelService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/model/count");
        MockMvcBuilders.standaloneSetup(modelEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link ModelEndpoint#createModel(Model)}
     */
    @Test
    void testCreateModel() throws Exception {
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

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date3);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date4);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Model model = new Model();
        model.setCreated(date);
        model.setDeleted(true);
        model.setEdited(date1);
        model.setEndDate(date2);
        model.setId(123L);
        model.setManufacturer(manufacturer);
        model.setModelName("Model Name");
        model.setStartDate(date5);
        model.setVehicleType(VehicleType.SEDAN);
        when(modelService.save((Model) any())).thenReturn(model);
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

        Model model1 = new Model();
        model1.setCreated(date6);
        model1.setDeleted(true);
        model1.setEdited(date7);
        model1.setEndDate(date8);
        model1.setId(123L);
        model1.setManufacturer(manufacturer1);
        model1.setModelName("Model Name");
        model1.setStartDate(date11);
        model1.setVehicleType(VehicleType.SEDAN);
        String content = (new ObjectMapper()).writeValueAsString(model1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/model/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(modelEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"manufacturer\":{\"id\":123,\"created\":10,\"edited\":10,"
                                        + "\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example\"},\"modelName\":\"Model Name\","
                                        + "\"vehicleType\":\"SEDAN\",\"startDate\":10,\"endDate\":10}"));
    }

    /**
     * Method under test: {@link ModelEndpoint#deleteModel(Model)}
     */
    @Test
    void testDeleteModel() throws Exception {
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

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date3);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date4);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Model model = new Model();
        model.setCreated(date);
        model.setDeleted(true);
        model.setEdited(date1);
        model.setEndDate(date2);
        model.setId(123L);
        model.setManufacturer(manufacturer);
        model.setModelName("Model Name");
        model.setStartDate(date5);
        model.setVehicleType(VehicleType.SEDAN);
        String content = (new ObjectMapper()).writeValueAsString(model);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/model/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(modelEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ModelEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(modelService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/model/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(modelEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ModelEndpoint#updateModel(Model)}
     */
    @Test
    void testUpdateModel() throws Exception {
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

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date3);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date4);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Model model = new Model();
        model.setCreated(date);
        model.setDeleted(true);
        model.setEdited(date1);
        model.setEndDate(date2);
        model.setId(123L);
        model.setManufacturer(manufacturer);
        model.setModelName("Model Name");
        model.setStartDate(date5);
        model.setVehicleType(VehicleType.SEDAN);
        when(modelService.save((Model) any())).thenReturn(model);
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

        Model model1 = new Model();
        model1.setCreated(date6);
        model1.setDeleted(true);
        model1.setEdited(date7);
        model1.setEndDate(date8);
        model1.setId(123L);
        model1.setManufacturer(manufacturer1);
        model1.setModelName("Model Name");
        model1.setStartDate(date11);
        model1.setVehicleType(VehicleType.SEDAN);
        String content = (new ObjectMapper()).writeValueAsString(model1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/model/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(modelEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"manufacturer\":{\"id\":123,\"created\":10,\"edited\":10,"
                                        + "\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example\"},\"modelName\":\"Model Name\","
                                        + "\"vehicleType\":\"SEDAN\",\"startDate\":10,\"endDate\":10}"));
    }
}

