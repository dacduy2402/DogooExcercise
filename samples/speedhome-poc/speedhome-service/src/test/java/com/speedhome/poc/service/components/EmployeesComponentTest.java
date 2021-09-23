package com.speedhome.poc.service.components;

import com.speedhome.poc.client.api.EmployeesApi;
import com.speedhome.poc.client.handler.ApiClient;
import com.speedhome.poc.client.model.Employee;
import com.speedhome.poc.client.model.Employees;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeesComponentTest {
    private static final String HTTP_LOCALHOST = "http://localhost:";
    private static final String BASE_PATH = "/speedhome/backend/v1";

    private static final String REQUEST_CONTEXT = "context";
    private static final String FIRST_NAME = "Edgar";
    private static final String LAST_NAME = "Elliott";
    private static final String EMAIL_ID = "e.elliott@randatmail.com";

    private EmployeesApi api;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        String url = HTTP_LOCALHOST + port + BASE_PATH;
        ApiClient client = new ApiClient();
        client.setBasePath(url);
        api = new EmployeesApi(client);
    }

    @Test
    public void ensureEmployeesExistsWhenGetAll() {
        Employees employees = api.getAllEmployees(REQUEST_CONTEXT);

        assertThat(employees.isEmpty(), is(false));
        assertEmployee(employees.get(0));
    }

    private void assertEmployee(Employee actual) {
        assertThat(actual.getFirstName(), is(FIRST_NAME));
        assertThat(actual.getLastName(), is(LAST_NAME));
        assertThat(actual.getEmailId(), is(EMAIL_ID));
    }

}
