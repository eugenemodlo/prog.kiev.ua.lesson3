package ua.kiev.prog.lesson3;

import ua.kiev.prog.lesson3.exceptions.StudentNotAddedException;

public class Main {
    public static void main(String[] args) {
        Student studentOne = new Student("John", "Doe", "Rambo", Sex.MALE, 34);
        Student studentTwo = new Student("Abraham", "Doe", "Lincoln", Sex.MALE, 24);
        Student studentThree = new Student("Henry", "Doe", "Ford", Sex.MALE, 35);
        Student studentFour = new Student("Jonny", "Doe", "Mnemonic", Sex.MALE, 44);
        Student studentFive = new Student("Forest", "Doe", "Hamp", Sex.MALE, 24);
        Student studentSix = new Student("Miranda", "Doe", "Priestly", Sex.FEMALE, 36);
        Student studentSeven = new Student("Scarlett", "Doe", "O'hara", Sex.FEMALE, 37);
        Student studentEight = new Student("Maria", "Doe", "Cure", Sex.FEMALE, 22);
        Student studentNine = new Student("Liza", "Doe", "Minelly", Sex.FEMALE, 23);
        Student studentTen = new Student("Lilu", "Doe", "Dallas", Sex.FEMALE, 30);
        Student studentZero = new Student("Terra", "Doe", "Incognita", Sex.FEMALE, 29);

        Group group = new Group("AA-00");

        try {
            group.addStudent(studentOne);
            group.addStudent(studentTwo);
            group.addStudent(studentThree);
            group.addStudent(studentFour);
            group.addStudent(studentFive);
            group.addStudent(studentSix);
            group.addStudent(studentSeven);
            group.addStudent(studentEight);
            group.addStudent(studentNine);
            group.addStudent(studentTen);

//            group.addStudent(studentZero);
        } catch (StudentNotAddedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(group.toString());
    }
}