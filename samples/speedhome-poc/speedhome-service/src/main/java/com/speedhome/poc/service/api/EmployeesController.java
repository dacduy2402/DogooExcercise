package com.speedhome.poc.service.api;

import com.speedhome.poc.api.EmployeesApi;
import com.speedhome.poc.api.model.Employee;
import com.speedhome.poc.api.model.EmployeeRequest;
import com.speedhome.poc.api.model.Employees;
import com.speedhome.poc.service.service.EmployeeService;
import com.speedhome.poc.service.validator.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/speedhome/backend/v1")
@CrossOrigin
public class EmployeesController implements EmployeesApi {

    private final EmployeeService service;

    private final EmployeeValidator validator;

    @Autowired
    public EmployeesController(EmployeeService service,
                              EmployeeValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Employee> addEmployee(
            @RequestHeader(value = "Request-Context", required = false) String requestContext,
            @RequestBody EmployeeRequest request) {

        validator.validateAddEmployee(request);

        Employee employee = service.saveEmployee(request);

        return new ResponseEntity<>(employee, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Employees> getAllEmployees(
            @RequestHeader(value = "Request-Context", required = false) String requestContext) {
        Employees employees = service.getAllEmployees();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(
            @RequestHeader(value = "Request-Context") String requestContext,
            @PathVariable("employeeId") Long employeeId) {
        validator.validateEmployeeExist(employeeId);

        Employee employee = service.getEmployeeById(employeeId);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeEmployeeById(
            @RequestHeader(value = "Request-Context", required = true) String requestContext,
            @PathVariable("employeeId") Long employeeId) {

        validator.validateEmployeeExist(employeeId);

        service.deleteEmployee(employeeId);

        return new ResponseEntity<>(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<Employee> updateEmployeeById(
            @RequestHeader(value = "Request-Context", required = true) String requestContext,
            @PathVariable("employeeId") Long employeeId, @RequestBody EmployeeRequest request) {
        validator.validateUpdateEmployee(employeeId, request);

        Employee employee = service.updateEmployee(employeeId, request);

        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
