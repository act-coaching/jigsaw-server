package act.coaching.jigsaw.domain;

import javax.persistence.*;

@Entity
@Table(name = "Team")
public class Team {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String team;

    @Column
    private String department;

    @Column
    private Integer totalCount;

    @Column
    private Integer earning;

    @Column
    private Integer working;

    @Column
    private Integer staying;

    public Team() {
    }

    public Team(Integer id, String team, String department, Integer totalCount, Integer earning, Integer working, Integer staying) {
        this.id = id;
        this.team = team;
        this.department = department;
        this.totalCount = totalCount;
        this.earning = earning;
        this.working = working;
        this.staying = staying;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
