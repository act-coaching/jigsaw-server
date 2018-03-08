package act.coaching.jigsaw.domain;

public class Team {

    private int id;
    private String team;
    private String department;
    private int totalNumber = 0;
    private int assignedNumber = 0;
    private int unassignedWorkingNumber = 0;
    private int unassignedNotWorkingNumber = 0;

    public Team() {

    }

    public Team(int id, String team, String department, int totalNumber, int assignedNumber, int unassignedWorkingNumber, int unassignedNotWorkingNumber) {
        this.id = id;
        this.team = team;
        this.department = department;
        this.totalNumber = totalNumber;
        this.assignedNumber = assignedNumber;
        this.unassignedWorkingNumber = unassignedWorkingNumber;
        this.unassignedNotWorkingNumber = unassignedNotWorkingNumber;
    }



    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getAssignedNumber() {
        return assignedNumber;
    }

    public void setAssignedNumber(int assignedNumber) {
        this.assignedNumber = assignedNumber;
    }

    public int getUnassignedWorkingNumber() {
        return unassignedWorkingNumber;
    }

    public void setUnassignedWorkingNumber(int unassignedWorkingNumber) {
        this.unassignedWorkingNumber = unassignedWorkingNumber;
    }

    public int getUnassignedNotWorkingNumber() {
        return unassignedNotWorkingNumber;
    }

    public void setUnassignedNotWorkingNumber(int unassignedNotWorkingNumber) {
        this.unassignedNotWorkingNumber = unassignedNotWorkingNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
