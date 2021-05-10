package dtu.gui.app;

import java.util.ArrayList;
import java.util.Scanner;
import dtu.program.app.ProjectManagementApp;
import dtu.program.domain.Employee;

public class MainScreen {

	static ProjectManagementApp pma = new ProjectManagementApp();
	Employee employee;
	ArrayList<String> employees = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		boolean main = true;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome To Softwarehuset A/S");
		
		System.out.println();
		while(main == true) {
			System.out.println("Choose next step");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Show employees");
			System.out.println("4. Close program");
			
			int firstStep = scan.nextInt();
			
			switch (firstStep) {
			
				case 1:
					System.out.println();
					System.out.println("Login as Employee or Project Leader");
					pma.login(scan);
					break;
					
				case 2:
					System.out.println();
					System.out.println("Register as employee");
					pma.register(scan);
					break;
					
				case 3:
					System.out.println();
					pma.printEmployees();
					break;
				
				case 4:
					main = false;
					break;
				
				default:
					
					break;
			}
			
			System.out.println();
		
		
		}
	
		
	}

}
