package dtu.calculator;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

import dtu.program.app.ProjectManagementApp;
import dtu.program.domain.Employee;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class EmployeeSteps {
	
	Employee employee;
	ProjectManagementApp pma;
	ErrorMessageHolder errorMessage;
	
	public EmployeeSteps(ProjectManagementApp pma) {
		this.pma = pma;
	}
	
	//Scenarios for employee
	@Given("that there is an employee with name {string}")
	public void that_there_is_an_employee_with_name(String name) {
		employee = new Employee(name);
	}

	@When("the employee {string} is added to the app")
	public void the_employee_is_added_to_the_app(String name) {
		assertTrue(employee.getUserName().equals(name));
		
	}

	@Then("the employee with name {string} is contained in the app")
	public void the_employee_with_name_is_contained_in_the_app(String name) {
	    assertThat(employee.getUserName(), is(equalTo(name)));
	}
	
	
	
}