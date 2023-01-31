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
import uni.car.service.data.entity.core.Address;
import uni.car.service.services.AddressService;

import java.sql.Date;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {AddressEndpoint.class})
@ExtendWith(SpringExtension.class)
class AddressEndpointTest {
    @Autowired
    private AddressEndpoint addressEndpoint;

    @MockBean
    private AddressService addressService;

    /**
     * Method under test: {@link AddressEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(addressService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/address/count");
        MockMvcBuilders.standaloneSetup(addressEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link AddressEndpoint#createAddress(Address)}
     */
    @Test
    void testCreateAddress() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(date);
        address.setDeleted(true);
        address.setEdited(date1);
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");
        when(addressService.save((Address) any())).thenReturn(address);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date2);
        address1.setDeleted(true);
        address1.setEdited(date3);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(address1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/address/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(addressEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\",\"city\":\"Oxford"
                                        + "\",\"street\":\"Street\"}"));
    }

    /**
     * Method under test: {@link AddressEndpoint#deleteAddress(Address)}
     */
    @Test
    void testDeleteAddress() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(date);
        address.setDeleted(true);
        address.setEdited(date1);
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(address);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/address/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(addressEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link AddressEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(addressService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/address/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(addressEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AddressEndpoint#updateAddress(Address)}
     */
    @Test
    void testUpdateAddress() throws Exception {
        Date date = mock(Date.class);
        when(date.getTime()).thenReturn(10L);
        Date date1 = mock(Date.class);
        when(date1.getTime()).thenReturn(10L);

        Address address = new Address();
        address.setCity("Oxford");
        address.setCountryCode("GB");
        address.setCreated(date);
        address.setDeleted(true);
        address.setEdited(date1);
        address.setHouseNumber("42");
        address.setId(123L);
        address.setStreet("Street");
        when(addressService.save((Address) any())).thenReturn(address);
        Date date2 = mock(Date.class);
        when(date2.getTime()).thenReturn(10L);
        Date date3 = mock(Date.class);
        when(date3.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date2);
        address1.setDeleted(true);
        address1.setEdited(date3);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        String content = (new ObjectMapper()).writeValueAsString(address1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/address/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(addressEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\",\"city\":\"Oxford"
                                        + "\",\"street\":\"Street\"}"));
    }
}

