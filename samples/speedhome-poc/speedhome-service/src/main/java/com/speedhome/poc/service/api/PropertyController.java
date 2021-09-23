package com.speedhome.poc.service.api;

import com.speedhome.poc.api.EmployeesApi;
import com.speedhome.poc.api.PropertiesApi;
import com.speedhome.poc.api.model.*;
import com.speedhome.poc.service.service.EmployeeService;
import com.speedhome.poc.service.service.PropertyService;
import com.speedhome.poc.service.validator.EmployeeValidator;
import com.speedhome.poc.service.validator.PropertyValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/speedhome/backend/v1")
@CrossOrigin
public class PropertyController implements PropertiesApi {

    private final PropertyService service;

    private final PropertyValidator validator;

    @Autowired
    public PropertyController(PropertyService service,
                              PropertyValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Property> addProperty(
            @RequestBody @Valid PropertyReq request) {
        validator.validateAddProperty(request);

        Property property = service.createProperty(request);

        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Property> updateProperty(
            @PathVariable("id") String id,
            @RequestBody @Valid PropertyReq request) {
        validator.validateUpdateProperty(id, request);

        Property property = service.updateProperty(id, request);

        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Property> approveProperty(
            @PathVariable("id") String id,
            @RequestBody @Valid PropertyApproveReq request) {
        validator.validateApprovedProperty(id, request);

        Property property = service.approveProperty(id, request);

        return new ResponseEntity<>(property, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Properties> search(
            @NotNull @Valid String term) {

        Properties properties = service.search(term);

        return new ResponseEntity<>(properties, HttpStatus.OK);
    }

}
