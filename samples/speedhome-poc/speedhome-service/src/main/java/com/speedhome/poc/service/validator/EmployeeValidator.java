package com.speedhome.poc.service.validator;

import com.speedhome.poc.api.model.EmployeeRequest;
import com.speedhome.poc.service.entity.EmployeeEntity;
import com.speedhome.poc.service.exception.BadRequestException;
import com.speedhome.poc.service.exception.EntityNotFoundException;
import com.speedhome.poc.service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeValidator {
    private static final String EMPLOYEE_DOES_NOT_EXIST = "Employee Does Not Exist";

    private static final String FIRST_NAME_REQUEST = "First name is requested";

    private static final String LAST_NAME_REQUEST = "Last name is requested";

    private static final String EMAIL_ID_REQUEST = "Email is requested";

    private static final String EMAIL_ID_ALREADY_EXIST = "Email Id already exist";

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeValidator(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void validateEmployeeExist(long employeeId) {
        if (repository.existsById(employeeId)) {return;}

        throw new EntityNotFoundException(EMPLOYEE_DOES_NOT_EXIST);
    }

    public void validateAddEmployee(EmployeeRequest request) {
        isNotPopulated(request.getFirstName(), FIRST_NAME_REQUEST);
        isNotPopulated(request.getLastName(), LAST_NAME_REQUEST);
        isNotPopulated(request.getEmailId(), EMAIL_ID_REQUEST);

        if (!repository.existsByEmailId(request.getEmailId())) { return; }

        throw new BadRequestException(EMAIL_ID_ALREADY_EXIST);
    }

    public void validateUpdateEmployee(long employeeId, EmployeeRequest request) {
        validateEmployeeExist(employeeId);

        isNotPopulated(request.getFirstName(), FIRST_NAME_REQUEST);
        isNotPopulated(request.getLastName(), LAST_NAME_REQUEST);
        isNotPopulated(request.getEmailId(), EMAIL_ID_REQUEST);

        EmployeeEntity employeeByEmail = repository.findByEmailId(request.getEmailId());

        if (employeeByEmail.getId() != employeeId) {
            throw new BadRequestException(EMAIL_ID_ALREADY_EXIST);
        }
    }

    private void isNotPopulated(String value, String errorMsg) {
        if (null == value || value.trim().isEmpty()) {
            throw new BadRequestException(errorMsg);
        }
    }

}
