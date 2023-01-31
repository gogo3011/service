package uni.car.service.web.endpoints;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
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
import uni.car.service.data.entity.core.Address;
import uni.car.service.data.entity.shop.RepairShop;
import uni.car.service.services.RepairShopService;

@ContextConfiguration(classes = {RepairShopEndpoint.class})
@ExtendWith(SpringExtension.class)
class RepairShopEndpointTest {
    @Autowired
    private RepairShopEndpoint repairShopEndpoint;

    @MockBean
    private RepairShopService repairShopService;

    /**
     * Method under test: {@link RepairShopEndpoint#createRepairShop(RepairShop)}
     */
    @Test
    void testCreateRepairShop() throws Exception {
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

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(date2);
        repairShop.setDeleted(true);
        repairShop.setEdited(date3);
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);
        when(repairShopService.save((RepairShop) any())).thenReturn(repairShop);
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date6);
        address1.setDeleted(true);
        address1.setEdited(date7);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        Date date8 = mock(Date.class);
        when(date8.getTime()).thenReturn(10L);
        Date date9 = mock(Date.class);
        when(date9.getTime()).thenReturn(10L);
        Date date10 = mock(Date.class);
        when(date10.getTime()).thenReturn(10L);
        Date date11 = mock(Date.class);
        when(date11.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date10);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date11);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        RepairShop repairShop1 = new RepairShop();
        repairShop1.setAddress(address1);
        repairShop1.setCreated(date8);
        repairShop1.setDeleted(true);
        repairShop1.setEdited(date9);
        repairShop1.setId(123L);
        repairShop1.setMechanics(new ArrayList<>());
        repairShop1.setName("Name");
        repairShop1.setSpecializedInManufacturer(manufacturer1);
        String content = (new ObjectMapper()).writeValueAsString(repairShop1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/repairShop/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(repairShopEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"mechanics\":[],\"specializedInManufacturer"
                                        + "\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example"
                                        + "\"},\"address\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\""
                                        + ",\"city\":\"Oxford\",\"street\":\"Street\"}}"));
    }

    /**
     * Method under test: {@link RepairShopEndpoint#load(Long)}
     */
    @Test
    void testLoad() throws Exception {
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

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(date2);
        repairShop.setDeleted(true);
        repairShop.setEdited(date3);
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);
        when(repairShopService.load(anyLong())).thenReturn(repairShop);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/repairShop/load");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(repairShopEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"mechanics\":[],\"specializedInManufacturer"
                                        + "\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example"
                                        + "\"},\"address\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\""
                                        + ",\"city\":\"Oxford\",\"street\":\"Street\"}}"));
    }

    /**
     * Method under test: {@link RepairShopEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(repairShopService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/repairShop/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(repairShopEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RepairShopEndpoint#listByManufacturerId(Long, Integer, Integer, String)}
     */
    @Test
    void testListByManufacturerId() throws Exception {
        when(repairShopService.getRepairShopsByManufacturerId((Long) any(), (Integer) any(), (Integer) any(),
                (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/repairShop/listByManufacturerId");
        MockHttpServletRequestBuilder paramResult = getResult.param("manufacturerId", String.valueOf(1L));
        MockHttpServletRequestBuilder paramResult1 = paramResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult1.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(repairShopEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link RepairShopEndpoint#updateRepairShop(RepairShop)}
     */
    @Test
    void testUpdateRepairShop() throws Exception {
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

        RepairShop repairShop = new RepairShop();
        repairShop.setAddress(address);
        repairShop.setCreated(date2);
        repairShop.setDeleted(true);
        repairShop.setEdited(date3);
        repairShop.setId(123L);
        repairShop.setMechanics(new ArrayList<>());
        repairShop.setName("Name");
        repairShop.setSpecializedInManufacturer(manufacturer);
        when(repairShopService.save((RepairShop) any())).thenReturn(repairShop);
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date6);
        address1.setDeleted(true);
        address1.setEdited(date7);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        Date date8 = mock(Date.class);
        when(date8.getTime()).thenReturn(10L);
        Date date9 = mock(Date.class);
        when(date9.getTime()).thenReturn(10L);
        Date date10 = mock(Date.class);
        when(date10.getTime()).thenReturn(10L);
        Date date11 = mock(Date.class);
        when(date11.getTime()).thenReturn(10L);

        Manufacturer manufacturer1 = new Manufacturer();
        manufacturer1.setCreated(date10);
        manufacturer1.setDeleted(true);
        manufacturer1.setEdited(date11);
        manufacturer1.setId(123L);
        manufacturer1.setLogoUrl("https://example.org/example");
        manufacturer1.setName("Name");

        RepairShop repairShop1 = new RepairShop();
        repairShop1.setAddress(address1);
        repairShop1.setCreated(date8);
        repairShop1.setDeleted(true);
        repairShop1.setEdited(date9);
        repairShop1.setId(123L);
        repairShop1.setMechanics(new ArrayList<>());
        repairShop1.setName("Name");
        repairShop1.setSpecializedInManufacturer(manufacturer1);
        String content = (new ObjectMapper()).writeValueAsString(repairShop1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/repairShop/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(repairShopEndpoint)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"mechanics\":[],\"specializedInManufacturer"
                                        + "\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"name\":\"Name\",\"logoUrl\":\"https://example.org/example"
                                        + "\"},\"address\":{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\""
                                        + ",\"city\":\"Oxford\",\"street\":\"Street\"}}"));
    }
}

