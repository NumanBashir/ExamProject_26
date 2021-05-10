package dtu.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import dtu.program.app.ExampleEmployeeRepository;
import dtu.program.app.ProjectManagementApp;
import dtu.program.domain.Employee;
import dtu.program.domain.Project;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectSteps {
	ProjectManagementApp pma;
	String userName;
	Project project;
	Employee employee;
	ProjectHolder projectHolder;
	
	public ProjectSteps(ProjectManagementApp pma, ProjectHolder projectHolder) {
		this.pma = pma;
		this.projectHolder = projectHolder;
		
	}
	
	@Given("that the user is an employee with name {string} exists")
	public void that_the_user_is_an_employee_with_name_exists(String employeeName) {
		userName = employeeName;
		pma.addEmployee(employeeName);
		ExampleEmployeeRepository exampleDatabase = new ExampleEmployeeRepository();
		assertTrue(pma.containsEmployeeWithName(employeeName));
	}
	
	
	@When("that employee adds a project")
	public void that_employee_adds_a_project() {
		projectHolder.setProject(pma.createProjectByUser(userName));
	}

	@Then("the project with project number {string} is added")
	public void the_project_with_project_number_is_added(String projectName) {
	    
		equals(projectName);
	}
	
	////////////////////////////////////////////////////////////////////////
	
	
	
	
}
