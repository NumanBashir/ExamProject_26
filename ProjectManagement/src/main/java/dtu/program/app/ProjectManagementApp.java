package dtu.program.app;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BooleanSupplier;

import dtu.program.domain.Activity;
import dtu.program.domain.Employee;
import dtu.program.domain.Project;
import dtu.program.domain.ProjectLeader;

public class ProjectManagementApp {

	ExampleEmployeeRepository exampleDatabase;
	static ArrayList<String> employees = new ArrayList<String>();
	static ArrayList<Project> projectList = new ArrayList<Project>();
	ArrayList<String> activityList = new ArrayList<String>();
	static ArrayList<String> leaderList = new ArrayList<String>();
	static ArrayList<ProjectLeader> projectLeaders = new ArrayList<ProjectLeader>();
	Employee employee;
	Project project;
	ProjectLeader leader;
	Activity activity;
	int løbenummer = 0;
	
	public ProjectManagementApp() {
		
	}

	public ProjectManagementApp(ExampleEmployeeRepository exampleDatabase) {
		this.exampleDatabase = exampleDatabase;
		
	}

	public static boolean containsEmployeeWithName(String string) {
		return employees.contains(string);
	}
	
	public boolean containsLeaderWithName(String string) {
		return leaderList.contains(string);
	}

	public Project createProjectByUser(String userName) {
		løbenummer++;
		Project newProject = new Project(løbenummer, "user");
		projectList.add(newProject);
		return newProject;
	}

	public void addEmployee(String name) {
		employees.add(name);
		
	}

	public boolean containsProject(String projectID) {
		System.out.println("projectId: "+ projectID);
		for(int i = 0; i<projectList.size(); i++) { // 1
			System.out.println("projectId in list: "+ projectList.get(i).getProjectId());
			if(projectID.equals(projectList.get(i).getProjectId())) { // 2
				return true; // 2a
			}
		}
		return false; // 3
	}

	public Project getProject() {
		return projectList.get(løbenummer);
		
	}

	public boolean containsEmployeeAsLeader(String leader) {
		for(int i = 0; i<employees.size(); i++) {
			if(leader.equals(employees.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void addToProject(Employee user) {
		projectList.add(project);
		
	}

	public void addActivityToProject(String activityName) {
		activityList.add(activityName);
		
	}
	
	public void printEmployees() {
		if(employees.isEmpty()) {
			System.out.println("No registered employees");
		}
		else {
			System.out.println("Currently registered employees: ");
			for(int i = 0; i < employees.size(); i++) {
				System.out.println(employees.get(i));
			}
		}
	}
	
	public void login(Scanner x) {
		System.out.println("Choose your position");
		System.out.println("1. Employee");
		System.out.println("2. Project Leader");
		
		int loginStep = x.nextInt();
		String init = "";
		
		switch (loginStep) {
		case 1:
			System.out.print("Please enter your initials: ");
			init = x.next();
			if(containsEmployeeWithName(init.toUpperCase())) {
				employeeMenu(init, x);
			}
			else {
				System.out.println("Initials did not match a registered employee");
			}
			break;
			
		case 2:
			System.out.print("Please enter your initials: ");
			init = x.next();
			if(containsLeaderWithName(init)) {
				leaderMenu(init, x);
			}
			else {
				System.out.println("Initials did not match a registered Project leader");
			}
			break;
		}
		
	}
	
	
	public void register(Scanner x) {
		System.out.print("Please enter the initials of the employee: ");
		String name = x.next();
		
		if(name.length() == 4 && name.matches("[a-åA-Å]+")) {
		
			if(!containsEmployeeWithName(name)) {
				addEmployee(name.toUpperCase());
			}
			else {
				System.out.println("Employee is already registered");
			}
		}
		else {
			System.out.println("The entered initials did not match the requirements (4 letters, only A-Z)");
		}
	}
	
	
	
	public static void employeeMenu(String init, Scanner x) {
		Boolean menu = true;
		System.out.println("Welcome " + init);
		System.out.println();
		while(menu == true) {
			System.out.println("Choose next step");
			System.out.println("1. Create Project");
			System.out.println("2. Time register"); 
			System.out.println("3. Go back");

			

			int employeeMenuStep = x.nextInt();
			
			switch (employeeMenuStep) {
			case 1:
				System.out.print("Please enter name of project: ");
				String projectName = x.next();
				Project project = new Project(projectList.size()+1, projectName);
				System.out.println("You have created project " + projectName + " with ID number " + project.getProjectId());
				System.out.print("Please enter the initials of the project leader: ");
				String leader = x.next();
				if(containsEmployeeWithName(leader.toUpperCase())) {
					leaderList.add(leader.toUpperCase());
					projectList.add(project);
					projectLeaders.add(new ProjectLeader(leader.toUpperCase(), project.getProjectId()));
				}
				else {
					System.out.println("The entered initials did not match a registered employee");
				}
				break;
		
			case 2:
			
				break;
			
			case 3: 
				menu = false;
				break;

			default:	
				break;
			}
			
		}
	}
	
	public static void leaderMenu(String init, Scanner scan) {
		String projectID = "";
		for(int i = 0; i < projectLeaders.size(); i++) {
			if(init.equals(projectLeaders.get(i).getLeaderName())) {
				projectID = projectLeaders.get(i).getProjectID();
			}
		}
		System.out.println("Welcome " + init + ", you are the leader of projectID " + projectID);
		int ID = Integer.parseInt(projectID)-210000;
		Project project = projectList.get(ID-1);
		System.out.println("1. Add activity to project");
		System.out.println("2. Go back");
		
		int leaderMenuStep = scan.nextInt();
		
		switch (leaderMenuStep) {
		case 1:

			System.out.print("Enter the name of the activity: ");
			String name = scan.next();
			project.addActivity(new Activity(name));
			break;
			
		case 2:
			
			break;
		}
		
		
	}
	
	
}
