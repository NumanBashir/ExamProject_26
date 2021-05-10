package dtu.program.domain;

import java.util.ArrayList;

public class Employee {
	
	String name;
	ArrayList<Activity> Activities = new ArrayList<Activity>();
	
	public Employee(String name) {
		this.name = name;
		
	}
	
	public  String getUserName() {
		return name;
		
	}

	public boolean isProjectLeader(String leader) {
		if(leader.equals(name)) { // 1
			return true; // 1a
		}
		
		return false; // 2
	}
	
	public void addActivity(Activity act) {
		Activities.add(act);
	}
	
}
