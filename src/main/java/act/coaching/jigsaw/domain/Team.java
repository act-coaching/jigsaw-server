package act.coaching.jigsaw.domain;

public class Team {
    private String name;

    private String groupName;

    private Person person;

    public Team(String name, String groupName, Person person) {
        this.name = name;
        this.groupName = groupName;
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
