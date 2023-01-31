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
import uni.car.service.data.entity.user.User;
import uni.car.service.services.UserService;

import java.sql.Date;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {UserEndpoint.class})
@ExtendWith(SpringExtension.class)
class UserEndpointTest {
    @Autowired
    private UserEndpoint userEndpoint;

    @MockBean
    private UserService userService;

    /**
     * Method under test: {@link UserEndpoint#count()}
     */
    @Test
    void testCount() throws Exception {
        when(userService.count()).thenReturn(3L);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/user/count");
        MockMvcBuilders.standaloneSetup(userEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("3"));
    }

    /**
     * Method under test: {@link UserEndpoint#createUser(User)}
     */
    @Test
    void testCreateUser() throws Exception {
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

        User user = new User();
        user.setAddress(address);
        user.setCreated(date2);
        user.setDeleted(true);
        user.setEdited(date3);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        when(userService.save((User) any())).thenReturn(user);
        Date date4 = mock(Date.class);
        when(date4.getTime()).thenReturn(10L);
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date4);
        address1.setDeleted(true);
        address1.setEdited(date5);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        User user1 = new User();
        user1.setAddress(address1);
        user1.setCreated(date6);
        user1.setDeleted(true);
        user1.setEdited(date7);
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userEndpoint).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"address\":{\"id"
                                        + "\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\",\"city\":\"Oxford\","
                                        + "\"street\":\"Street\"}}"));
    }

    /**
     * Method under test: {@link UserEndpoint#deleteUser(User)}
     */
    @Test
    void testDeleteUser() throws Exception {
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

        User user = new User();
        user.setAddress(address);
        user.setCreated(date2);
        user.setDeleted(true);
        user.setEdited(date3);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/user/delete")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(userEndpoint).build().perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link UserEndpoint#list(Integer, Integer, String)}
     */
    @Test
    void testList() throws Exception {
        when(userService.getAll((Integer) any(), (Integer) any(), (String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/user/list");
        MockHttpServletRequestBuilder paramResult = getResult.param("pageNo", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1))
                .param("sortBy", "foo");
        MockMvcBuilders.standaloneSetup(userEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link UserEndpoint#updateUser(User)}
     */
    @Test
    void testUpdateUser() throws Exception {
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

        User user = new User();
        user.setAddress(address);
        user.setCreated(date2);
        user.setDeleted(true);
        user.setEdited(date3);
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        when(userService.save((User) any())).thenReturn(user);
        Date date4 = mock(Date.class);
        when(date4.getTime()).thenReturn(10L);
        Date date5 = mock(Date.class);
        when(date5.getTime()).thenReturn(10L);

        Address address1 = new Address();
        address1.setCity("Oxford");
        address1.setCountryCode("GB");
        address1.setCreated(date4);
        address1.setDeleted(true);
        address1.setEdited(date5);
        address1.setHouseNumber("42");
        address1.setId(123L);
        address1.setStreet("Street");
        Date date6 = mock(Date.class);
        when(date6.getTime()).thenReturn(10L);
        Date date7 = mock(Date.class);
        when(date7.getTime()).thenReturn(10L);

        User user1 = new User();
        user1.setAddress(address1);
        user1.setCreated(date6);
        user1.setDeleted(true);
        user1.setEdited(date7);
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPassword("iloveyou");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(userEndpoint)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"address\":{\"id"
                                        + "\":123,\"created\":10,\"edited\":10,\"deleted\":true,\"countryCode\":\"GB\",\"houseNumber\":\"42\",\"city\":\"Oxford\","
                                        + "\"street\":\"Street\"}}"));
    }
}

