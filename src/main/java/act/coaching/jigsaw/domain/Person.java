package act.coaching.jigsaw.domain;


import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue
    int id;

    @Column
    String name;


    @Column
    String nickname;

    @Column
    String email;

    @Column
    String employeeNumber;

    @Column
    String gender;

    @Column
    String cellPhoneNumber;

    @Column
    String team;

    @Column
    String department;

    @Column
    String rank;

    @Column
    String duty;

    @Column
    String projectName;

    @Column
    String projectCode;

    @Column
    String assignType;



    public Person(){}

    public Person(int id, String name, String email){
        this.id = id;
        this.name= name;
        this.email = email;
    }

    public Person(int id, String name, String email, String rank){
        this.id = id;
        this.name= name;
        this.email = email;
        this.rank = rank;
    }

    public Person(int id, String name, String email, String rank, String projectName, String projectCode, String duty) {
        this.id = id;
        this.name= name;
        this.email = email;
        this.rank = rank;
        this.projectName = projectName;
        this.projectCode = projectCode;
        this.duty = duty;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
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

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType;
    }


}
