package org.example.rest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        Employee emp = new Employee("E001", "Eric Simmons");
        String id = "E001";
        Mockito.when(restTemplate.getForEntity("http://example.com/employee/" + id, Employee.class))
               .thenReturn(new ResponseEntity<>(emp, HttpStatus.OK));

        Employee employee = employeeService.getEmployee(id);

        Assertions.assertEquals(emp, employee);
    }
}
