package act.coaching.jigsaw.domain;

public class Project {

    private String projectCode;
    private int id;
    private String projectName;
    private int totalCnt;
    private int pmCnt;
    private int devCnt;
    private int cxCnt;


    public Project(int id, String projectCode, String projectName, int totalCnt, int pmCnt, int devCnt, int cxCnt) {
        this.id = id;
        this.projectCode= projectCode;
        this.projectName = projectName;
        this.totalCnt = totalCnt;
        this.pmCnt = pmCnt;
        this.devCnt = devCnt;
        this.cxCnt = cxCnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return id == project.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public void setPmCnt(int pmCnt) {
        this.pmCnt = pmCnt;
    }

    public void setDevCnt(int devCnt) {
        this.devCnt = devCnt;
    }

    public void setCxCnt(int cxCnt) {
        this.cxCnt = cxCnt;
    }

    public int getId() {
        return id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public int getPmCnt() {
        return pmCnt;
    }

    public int getDevCnt() {
        return devCnt;
    }

    public int getCxCnt() {
        return cxCnt;
    }
}
