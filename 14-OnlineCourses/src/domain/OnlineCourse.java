package domain;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author joana
 */
public class OnlineCourse {

    private int code;
    private String name;
    private int hours;
    private Professor professor;
    private Set<Integer> studentsCodes = new HashSet<>();

    public OnlineCourse(int code, String name, int hours, Professor professor) {
        this.code = code;
        this.name = name;
        this.hours = hours;
        this.professor = professor;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Set<Integer> getStudentsCodes() {
        return studentsCodes;
    }

    @Override
    public String toString() {
        return "Course: " + name + ", hours: " + hours + ", professor: " + professor;
    }

    public void enrollStudent(Student student) {
        studentsCodes.add(student.getCode());
    }
}
