package ua.kiev.prog.lesson3;

import ua.kiev.prog.lesson3.exceptions.StudentNotAddedException;

public class Group {
    private Student[] students = new Student[10];

    public Group(Student[] students) {
        this.students = students;
    }

    public Group() {
    }

    public Student[] getStudents() {
        return students;
    }

    public void addStudent(Student student) throws StudentNotAddedException {
        for (int i = 0; i < 10; i++) {
            if (students[i] == null) {
                students[i] = student;
                break;
            }
        }
        throw new StudentNotAddedException("Group is full!!!");
    }
}
