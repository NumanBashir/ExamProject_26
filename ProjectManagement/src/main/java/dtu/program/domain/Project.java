package dtu.program.domain;

import java.util.ArrayList;
import java.util.List;

public class Project {

	String projectID;
	String projectName;
	
	List<Activity> activities = new ArrayList<>();
	
	public Project(int løbenummer, String name) {
		
		if(løbenummer < 10) {
			this.projectID = "21000" + løbenummer;
		} else if(løbenummer >= 10 && løbenummer < 100) {
			this.projectID = "2100" + løbenummer;
		} else if(løbenummer >= 100 && løbenummer < 1000) {
			this.projectID = "210" + løbenummer;
		} else {
			this.projectID = "21" + løbenummer;
		}
			
		this.projectName = name;
		
	}
	
	
	public boolean containsProject(String projectID) {
		
		return true;
	}

	public String getProjectId() {
		return projectID;
	}
	
	public void addActivity(Activity act) {
		this.activities.add(act);
	}

}
