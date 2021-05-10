package dtu.calculator;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import dtu.program.app.ProjectManagementApp;
import dtu.program.domain.Employee;
import dtu.program.domain.Project;
import dtu.program.domain.ProjectLeader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProjectLeaderSteps {
	
	Project project;
	Employee user;
	ProjectManagementApp pma;
	ProjectHolder projectHolder;
	ProjectLeader leader;
	
	public ProjectLeaderSteps(ProjectManagementApp pma, ProjectHolder projectHolder) {
		this.pma = pma;
		this.projectHolder = projectHolder;
		
	}
	
	
	@Given("that the user with the name {string}")
	public void that_the_user_with_the_name(String userName) {
	    user = new Employee(userName);
		
	}

	@Given("a project with project number of {string} does exists")
	public void a_project_with_project_number_of_does_exists(String projectID) {
		pma.createProjectByUser(user.getUserName());
		assertTrue(pma.containsProject(projectID));
		
	}
	
	@Given("there is no employee {string} assigned as a project leader to that project")
	public void there_is_no_employee_assigned_as_a_project_leader_to_that_project(String userName) {
	    assertFalse(pma.containsEmployeeAsLeader(userName));
	    
	}
	

	@When("that employee {string} is assigned to that project")
	public void that_employee_is_assigned_to_that_project(String name) {
		pma.addToProject(user);
		assertTrue(user.getUserName().equals(name));
		
	}

	@Then("The employee with the name {string} is registered as the project leader for the project number {string}")
	public void the_employee_with_the_name_is_registered_as_the_project_leader_for_the_project_number(String name, String projectID) {
	    assertTrue(user.isProjectLeader(name));
		
	}
	


	
	
}
