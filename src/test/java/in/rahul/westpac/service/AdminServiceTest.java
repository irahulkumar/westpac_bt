package in.rahul.westpac.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.rahul.westpac.entity.User;
import in.rahul.westpac.util.TestUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    RestTemplate restTemplate;

    AdminService adminService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        adminService = new AdminServiceImpl(restTemplate);
    }

    @Test
    void testGetUserDetails(){
        when(restTemplate.getForEntity(
                eq("https://jsonplaceholder.typicode.com/users/1"),
                any()))
                .thenReturn(new ResponseEntity<>(TestUtil.getUser(), HttpStatus.OK));
        when(restTemplate.getForEntity(
                eq("https://jsonplaceholder.typicode.com/posts?userId=1"),
                any()))
                .thenReturn(new ResponseEntity<>(TestUtil.getposts(), HttpStatus.OK));

        assertEquals(1, adminService.getUserDetails(1).getId());
    }

    @Test
    void testGetUserDetailsFailure() {
        when(restTemplate.getForEntity(
                eq("https://jsonplaceholder.typicode.com/users/1"),
                any()))
                .thenReturn(new ResponseEntity<>(null, HttpStatus.OK));
        when(restTemplate.getForEntity(
                eq("https://jsonplaceholder.typicode.com/posts?userId=1"),
                any()))
                .thenReturn(new ResponseEntity<>(TestUtil.getposts(), HttpStatus.NOT_FOUND));

        assertEquals(null, adminService.getUserDetails(1));

    }

}
