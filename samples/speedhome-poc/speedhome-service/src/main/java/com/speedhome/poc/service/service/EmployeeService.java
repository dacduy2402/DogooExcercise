package com.speedhome.poc.service.service;


import com.speedhome.poc.api.model.Employee;
import com.speedhome.poc.api.model.EmployeeRequest;
import com.speedhome.poc.api.model.Employees;
import com.speedhome.poc.service.entity.EmployeeEntity;
import com.speedhome.poc.service.mapper.EmployeeMapper;
import com.speedhome.poc.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeService(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Employees getAllEmployees() {
        List<EmployeeEntity> entities = repository.findAll();

        return mapper.mapEmployeesFromEmployeeEntities(entities);
    }

    public Employee getEmployeeById(long employeeId) {
        EmployeeEntity entity = repository.getOne(employeeId);

        return mapper.mapEmployeeFromEmployeeEntity(entity);
    }

    public Employee saveEmployee(EmployeeRequest request) {
        EmployeeEntity entity = mapper.mapEmployeeEntityToEmployeeRequest(request);

        EmployeeEntity entitySaved = repository.save(entity);

        return mapper.mapEmployeeFromEmployeeEntity(entitySaved);
    }

    public Employee updateEmployee(long employeeId, EmployeeRequest request) {

        EmployeeEntity entity = mapper.mapEmployeeEntityToEmployeeRequest(employeeId, request);

        EmployeeEntity entitySaved = repository.save(entity);

        return mapper.mapEmployeeFromEmployeeEntity(entitySaved);
    }

    public void deleteEmployee(long employeeId) {
        EmployeeEntity entity = repository.getOne(employeeId);

        repository.delete(entity);
    }
}
