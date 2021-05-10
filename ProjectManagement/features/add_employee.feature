Feature: Add an employee
	Description: An employee is added
	Actor: Employee
	
# Main Scenario
Scenario: Add an employee succesfully
	Given that there is an employee with name "LARS" 
	When the employee "LARS" is added to the app
	Then the employee with name "LARS" is contained in the app