Feature: Get All Employee

  Scenario: Successful Get All Employee
    When the user requests to get all employees
    Then the server returns a status 200 for the employee service request
    And check all employee was returned are correctly



