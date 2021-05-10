package dtu.calculator;

import static org.junit.Assert.assertTrue;

import dtu.program.app.ProjectManagementApp;
import dtu.program.domain.Activity;
import dtu.program.domain.Employee;
import dtu.program.domain.Project;
import dtu.program.domain.ProjectLeader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivitySteps {
	
	Employee user;
	Project project;
	ProjectManagementApp pma;
	ProjectHolder projectHolder;
	ProjectLeader leader;
	Activity activity;
	
	public ActivitySteps(ProjectManagementApp pma, ProjectHolder projectHolder) {
		this.pma = pma;
		this.projectHolder = projectHolder;
		
	}
	

	@Given("that the user is a project leader with the name {string}")
	public void that_the_user_is_a_project_leader_with_the_name(String name) { 
	    leader = new ProjectLeader(name);
	    leader.isProjectLeader(name);
		
	}

	@Given("a project with project number {string} exists")
	public void a_project_with_project_number_exists(String projectID) {
		pma.createProjectByUser(leader.getLeaderName());
	    assertTrue(pma.containsProject(projectID));
		
	}

	@When("the project leader adds an activity named {string}")
	public void the_project_leader_adds_an_activity_named(String activityName) {
		leader.addActivityToProject(activityName);
		
	}

	@Then("an activity named {string} is added to the project")
	public void an_activity_named_is_added_to_the_project(String activityName) {
	    assertTrue(leader.isProjectLeader(activityName));
	}
	
}
