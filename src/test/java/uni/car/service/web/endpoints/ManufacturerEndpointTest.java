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
import uni.car.service.data.entity.car.Manufacturer;
import uni.car.service.services.ManufacturerService;

import java.sql.Date;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {ManufacturerEndpoint.class})
@ExtendWith(SpringExtension.class)
class ManufacturerEndpointTest {
    @Autowired
    private ManufacturerEndpoint manufacturerEndpoint;

    @MockBean
    private ManufacturerService manufacturerService;

    /**
     * Method under test: {@link ManufacturerEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(manufacturerService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/manufacturer/count");
        MockMvcBuilders.standaloneSetup(manufacturerEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link ManufacturerEndpoint#createManufacturer(Manufacturer)}
     */
    @Test
    void testCreateManufacturer() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date1);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        when(manufacturerService.save((Manufacturer) any())).thenReturn(manufacturer);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date2);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date3);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(manufacturer1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/manufacturer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(manufacturerEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org"
                                        + "/example\"}"));
    }

    /**
     * Method under test: {@link ManufacturerEndpoint#deleteManufacturer(Manufacturer)}
     */
    @Test
    void testDeleteManufacturer() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date1);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(manufacturer);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/manufacturer/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(manufacturerEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link ManufacturerEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(manufacturerService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/manufacturer/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(manufacturerEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link ManufacturerEndpoint#updateManufacturer(Manufacturer)}
     */
    @Test
    void testUpdateManufacturer() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCreated(date);
        manufacturer.setDeleted(true);
        manufacturer.setEdited(date1);
        manufacturer.setId(123L);
        manufacturer.setLogoUrl("https://example.org/example");
        manufacturer.setName("Name");
        when(manufacturerService.save((Manufacturer) any())).thenReturn(manufacturer);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date2);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date3);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(manufacturer1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/manufacturer/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(manufacturerEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org"
                                        + "/example\"}"));
    }
}

