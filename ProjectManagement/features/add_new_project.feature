Feature: Add new project
	Description: An employee can add a new project 
	Actor: Employee

# Main scenario
Scenario: add an activity to a project successfully 
	Given that the user is an employee with name "LARS" exists 
	When that employee adds a project
	Then the project with project number "210001" is added