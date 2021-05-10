Feature: Add activity
	Description: A new activity is added
	Actors: Project leader
	
# Main scenario
Scenario: An activity is added succesfully
	Given that the user is a project leader with the name "JACO"
	And a project with project number "210001" exists
	When the project leader adds an activity named "Graphical Interface"
	Then an activity named "Graphical Interface" is added to the project
	