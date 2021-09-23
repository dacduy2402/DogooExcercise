package com.speedhome.poc.service.mapper;

import com.speedhome.poc.api.model.Employee;
import com.speedhome.poc.api.model.EmployeeRequest;
import com.speedhome.poc.api.model.Employees;
import com.speedhome.poc.service.entity.EmployeeEntity;
import com.speedhome.poc.service.service.EmployeeIdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeMapper {

    private final EmployeeIdGenerator generator;

    @Autowired
    public EmployeeMapper(EmployeeIdGenerator generator) {
        this.generator = generator;
    }

    public Employee mapEmployeeFromEmployeeEntity(EmployeeEntity from) {
        Employee to = new Employee();

        to.setId(from.getId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmailId(from.getEmailId());

        return to;
    }

    public EmployeeEntity mapEmployeeEntityToEmployeeRequest(EmployeeRequest from) {
        EmployeeEntity to = new EmployeeEntity();

        to.setId(generator.generateRequestId());
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmailId(from.getEmailId());

        return to;
    }

    public EmployeeEntity mapEmployeeEntityToEmployeeRequest(long employeeId, EmployeeRequest from) {
        EmployeeEntity to = new EmployeeEntity();

        to.setId(employeeId);
        to.setFirstName(from.getFirstName());
        to.setLastName(from.getLastName());
        to.setEmailId(from.getEmailId());

        return to;
    }

    public Employees mapEmployeesFromEmployeeEntities(List<EmployeeEntity> from) {
        Employees employees = new Employees();

        from.forEach( employeeEntity ->
            employees.add(mapEmployeeFromEmployeeEntity(employeeEntity))
        );

        return employees;
    }
}
