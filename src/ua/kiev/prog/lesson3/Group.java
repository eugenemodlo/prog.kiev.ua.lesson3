package ua.kiev.prog.lesson3;

import ua.kiev.prog.lesson3.exceptions.StudentNotAddedException;
import ua.kiev.prog.lesson3.exceptions.StudentNotFoundException;

import java.util.Arrays;

public class Group {
    private static final int STUDENTS_AMOUNT = 10;
    private String groupName;
    private final Student[] students = new Student[STUDENTS_AMOUNT];

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
        for (int i = 0; i < STUDENTS_AMOUNT - 1; i++) {
            if (students[i] == null) {
                students[i] = student;
                student.setGroupName(this.groupName);
                System.out.println("student " + student.getLastName() + " " + student.getFirstName() + " added!");
                break;
            }
            if (i == STUDENTS_AMOUNT - 2) throw new StudentNotAddedException();
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

    public void removeStudent(Student student) throws StudentNotFoundException {
        for (int i = 0; i < students.length - 1; i++) {
            if (student == students[i]) {
                students[i] = null;
                System.out.println("Student removed from group!");
                break;
            }
            if (i == students.length - 2) {
                throw new StudentNotFoundException();
            }
        }
    }

}
