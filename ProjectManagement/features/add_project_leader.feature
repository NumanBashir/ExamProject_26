Feature: Add project leader
	Description: An employee is added as the project leader to a given project 
	Actors: Employee
	
# Main scenario
Scenario: Add an employee as the project leader succesully
	Given that the user with the name "LARS"
	And a project with project number of "210001" does exists 
	And there is no employee "LARS" assigned as a project leader to that project
	When that employee "LARS" is assigned to that project
	Then The employee with the name "LARS" is registered as the project leader for the project number "210001"
	
#Alternative scenario
##Scenario: Add a project leader to a non-existing project
	##Given that the user with the name "LARS"
	##And a project with project number of "210001" does not exists 
	##When that employee is assigned to that project
	##Then the error message “The project does not exist” is given
	
##Scenario: Add a project leader when there is already one assigned 
	##Given that the user with the name "LARS"
	##And a project with project number of 030901 does exists
	##And the employee is not a project leader for that project
	##And a project leader with the name “SARA” is assigned to project 030901 
	##When the employee is assigned as the project leader to that project 
	##Then the error message “There is already a project leader” is given
