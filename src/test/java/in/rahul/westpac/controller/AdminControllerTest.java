package in.rahul.westpac.controller;

import in.rahul.westpac.Application;
import in.rahul.westpac.service.AdminService;
import in.rahul.westpac.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
@ContextConfiguration(classes = Application.class)
@AutoConfigureMockMvc(addFilters = false)
public class AdminControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AdminService adminService;


    @Test
    public void testGetUserDetails() throws Exception{
        Mockito.when(adminService.getUserDetails(1)).thenReturn(TestUtil.getUserWithPost());
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/userDetails/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[*].userId").isNotEmpty());

    }
}
