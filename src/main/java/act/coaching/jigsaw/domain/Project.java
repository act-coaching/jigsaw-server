package act.coaching.jigsaw.domain;


import javax.persistence.*;


@Entity
@Table(name = "Project")
public class Project {

    @Id
    @GeneratedValue
    int id;

    @Column
    String projectName;

    @Column
    String projectCode;

    @Column
    int totalCount;

    @Column
    int pm;

    @Column
    int dev;

    @Column
    int cx;

    public Project() {
    }

    public Project(String projectName, String projectCode, int totalCount, int pm, int dev, int cx) {
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.totalCount = totalCount;
        this.pm = pm;
        this.dev = dev;
        this.cx = cx;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getDev() {
        return dev;
    }

    public void setDev(int dev) {
        this.dev = dev;
    }

    public int getCx() {
        return cx;
    }

    public void setCx(int cx) {
        this.cx = cx;
    }
}
