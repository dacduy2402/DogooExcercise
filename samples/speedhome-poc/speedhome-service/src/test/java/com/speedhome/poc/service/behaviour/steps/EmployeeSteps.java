package com.speedhome.poc.service.behaviour.steps;

import com.speedhome.poc.client.api.EmployeesApi;
import com.speedhome.poc.service.repository.EmployeeRepository;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class EmployeeSteps extends CommonStepConfiguration {

    private static final String EMPLOYEE_BASE_PATH = "/tools/governance/v1/employees";

    private static final String FIRST_NAME = "JONY";
    private static final String LAST_NAME = "IVE";
    private static final String EMAIL_ID = "jony.ive@gmail.com";

    private static final String ADMIN = "22.ewogICJ1c2VyX25hbWUiIDogIlNENTZIRyIsCiAgInVzZXJfcm9sZSIgOiAiY249REVQT19BRE1JTiIKfQ==";

    protected EmployeesApi employeesApi;

    private RestClientException restClientException;

    @Autowired
    private EmployeeRepository repository;


    @Before
    public void setup() {
        super.setup();
        employeesApi = new EmployeesApi(baseApiClient);
    }

    @When("^the user requests to get all employees$")
    public void theUserRequestsToGetAllEmployees() {
        employeesApi.getAllEmployees(ADMIN);
    }

    @Then("^the server returns a status (\\d+) for the employee service request$")
    public void theServerReturnsAStatusForTheEmployeeServiceRequest(int status) {
        assertThat(employeesApi.getApiClient().getStatusCode().value(),
                is(status));
    }

    @And("^check all employee was returned are correctly$")
    public void checkAllEmployeeWasReturnedAreCorrectly() {
        assertThat(repository.findAll(), notNullValue());
    }
}
