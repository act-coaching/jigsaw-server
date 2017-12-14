package act.coaching.jigsaw.domain;

public class Team {
    private String team;

    private String department;

    private Integer totalCount;

    private Integer earning;

    private Integer working;

    private Integer staying;

    public Team(String team, String department, Integer totalCount, Integer earning, Integer working, Integer staying) {
        this.team = team;
        this.department = department;
        this.totalCount = totalCount;
        this.earning = earning;
        this.working = working;
        this.staying = staying;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getEarning() {
        return earning;
    }

    public void setEarning(Integer earning) {
        this.earning = earning;
    }

    public Integer getWorking() {
        return working;
    }

    public void setWorking(Integer working) {
        this.working = working;
    }

    public Integer getStaying() {
        return staying;
    }

    public void setStaying(Integer staying) {
        this.staying = staying;
    }
}
