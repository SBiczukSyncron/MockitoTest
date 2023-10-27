package org.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {

	@Autowired
	private RestTemplate restTemplate;

	public Employee getEmployee(String id) {
		ResponseEntity<Employee> resp = restTemplate.getForEntity("http://example.com/employee/" + id, Employee.class);
		return resp.getStatusCode().is2xxSuccessful() ? resp.getBody() : null;
	}
}
