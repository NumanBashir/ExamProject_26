package dtu.program.domain;

import java.util.ArrayList;

public class ProjectLeader {

	String leaderName;
	String projectID;
	ArrayList<String> activityList = new ArrayList<String>();
	
	//Setter
	public ProjectLeader(String leaderName, String projectID) {
		this.leaderName = leaderName;
		this.projectID = projectID;
	}
	
	public ProjectLeader(String leaderName) {
		this.leaderName = leaderName;
	}
	
	public String getLeaderName() {
		return leaderName;
	}

	public void addActivityToProject(String activityName) {
		activityList.add(activityName);
		
	}

	public boolean isProjectLeader(String leader) {
		if(leader.equals(leader)) { // 1
			return true; // 1a
		}
		
		return false; // 2
	}
	
	public void addActivity(Activity act, Employee emp) {
		emp.Activities.add(act);
	}
	
	public String getProjectID() {
		return this.projectID;
	}
	
}
