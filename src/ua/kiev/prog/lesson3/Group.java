package ua.kiev.prog.lesson3;

import ua.kiev.prog.lesson3.exceptions.StudentNotAddedException;
import ua.kiev.prog.lesson3.exceptions.StudentNotFoundException;

import java.util.Arrays;

public class Group {
    private static final int MAX_STUDENTS_AMOUNT = 10;
    private String groupName;
    private final Student[] students = new Student[MAX_STUDENTS_AMOUNT];

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
        for (int i = 0; i <= MAX_STUDENTS_AMOUNT; i++) {
            if (i == MAX_STUDENTS_AMOUNT) throw new StudentNotAddedException();
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

    public Student getStudentByLastName(String lastName) throws StudentNotFoundException {
        Student stud = null;
        for (Student student : this.students) {
            if (student != null && student.getLastName().equals(lastName)) {
                stud = student;
            }
        }
        if (stud == null) {
            throw new StudentNotFoundException();
        }
        return stud;
    }

    public boolean removeStudent(String lastName) throws StudentNotFoundException {
        for (int i = 0; i <= students.length; i++) {
            if (i == students.length) {
                throw new StudentNotFoundException();
            }
            if (students[i].getLastName().equals(lastName)) {
                students[i] = null;
                return true;
            }
        }
        return false;
    }
}
