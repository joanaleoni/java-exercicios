package main;

import domain.OnlineCourse;
import domain.Professor;
import domain.Student;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author joana
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final List<OnlineCourse> courses = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.print("How many courses do you want to register? ");
        int nC = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nC; i++) {
            registerOnlineCourse();
            System.out.println();
        }

        System.out.print("How many students do you want to register? ");
        int nS = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < nS; i++) {
            registerStudent();
            System.out.println();
        }
                
        System.out.print("Enter the professor's code for the number of distinct students you want to see: ");
        int codeP = Integer.parseInt(sc.nextLine());

        System.out.println("Total distinct students: " + getDistinctStudents(codeP));
        sc.close();
    }

    public static void registerOnlineCourse() {
        System.out.println("--- Course data ---");
        System.out.print("Course code: ");
        int code = Integer.parseInt(sc.nextLine());

        System.out.print("Course name: ");
        String name = sc.nextLine();

        System.out.print("Hours: ");
        int hours = Integer.parseInt(sc.nextLine());

        System.out.println();
        System.out.println("-- Enter professor data --");
        Professor p = registerProfessor();
        courses.add(new OnlineCourse(code, name, hours, p));
    }

    public static Professor registerProfessor() {
        System.out.print("Professor code: ");
        int code = Integer.parseInt(sc.nextLine());

        System.out.print("Professor name: ");
        String name = sc.nextLine();

        return new Professor(code, name);
    }

    public static void registerStudent() {
        System.out.print("Student code: ");
        int code = Integer.parseInt(sc.nextLine());

        System.out.print("Student name: ");
        String name = sc.nextLine();

        Student s = new Student(code, name);        
        
        System.out.print("Codes for the courses to enroll this student, separated by comma (,), without space: ");
        String allCodes = sc.nextLine();
        
        String[] codes = allCodes.split(",");
        for (String cd : codes) {
            int cdInt = Integer.parseInt(cd);
            
            for(OnlineCourse c : courses){
                if(c.getCode() == cdInt){
                    c.enrollStudent(s);
                }
            }
        }
    }

    public static int getDistinctStudents(int professorCode) {
        Set<Integer> distinctStudents = new HashSet();
        for (OnlineCourse course : courses) {
            if (course.getProfessor().getCode() == professorCode) {
                distinctStudents.addAll(course.getStudentsCodes());
            }
        }        
        return distinctStudents.size();
    }
}