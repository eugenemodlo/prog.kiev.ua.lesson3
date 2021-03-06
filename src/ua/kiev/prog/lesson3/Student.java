package ua.kiev.prog.lesson3;

public class Student extends Person {
    private String groupName;

    public Student(String firstName, String secondName, String lastName, Sex sex, int age, String groupName) {
        super(firstName, secondName, lastName, sex, age);
        this.groupName = groupName;
    }

    public Student() {
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + getFirstName() + getSecondName() + getLastName() + '\'' +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
