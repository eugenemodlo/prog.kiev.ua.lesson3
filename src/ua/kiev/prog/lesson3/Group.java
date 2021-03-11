package ua.kiev.prog.lesson3;

import ua.kiev.prog.lesson3.exceptions.StudentNotAddedException;

import java.util.Arrays;
import java.util.Comparator;

public class Group {
    private String groupName;
    private Student[] students = new Student[10];

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public Student[] getStudents() {
        return students;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void addStudent(Student student) throws StudentNotAddedException {
        for (int i = 0; i <= 10; i++) {
            if (i == 10) throw new StudentNotAddedException();
            if (students[i] == null) {
                students[i] = student;
                student.setGroupName(this.groupName);
                System.out.println("student " + student.getLastName() + " " + student.getFirstName() + " added!");
                break;
            }
        }
    }

    @Override
    public String toString() {
        Arrays.sort(students, (o1, o2) -> CheckNull.checkNull(o1, o2) != CheckNull.NOT_NULL ? CheckNull.checkNull(o1, o2) :
                o1.getLastName().compareTo(o2.getLastName()));

        return "Group{" +
                "groupName='" + groupName + '\'' +
                ", students=" + Arrays.toString(students) +
                '}';
    }
}
