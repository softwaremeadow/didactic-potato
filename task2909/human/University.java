package com.codegym.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student studentWithAverageGrade = null;
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) {
                studentWithAverageGrade = student;
            }
        }
        return studentWithAverageGrade;
    }

    public Student getStudentWithHighestAverageGrade() {
        Student studentWithHighestGrade = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > studentWithHighestGrade.getAverageGrade()) {
                studentWithHighestGrade = students.get(i);
            }
        }
        return studentWithHighestGrade;
    }

    public Student getStudentWithLowestAverageGrade() {
        double min = students.get(0).getAverageGrade();
        Student studentWithLowestGrade = students.get(0);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < min) {
                studentWithLowestGrade = students.get(i);
            }
        }
        return studentWithLowestGrade;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}