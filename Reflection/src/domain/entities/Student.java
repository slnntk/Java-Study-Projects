package domain.entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Student {
    private int code;
    private String name;
    private int registrationNumber;
    private GregorianCalendar registrationDate;
    private ArrayList<Double> grades;
    private double value;

    public Student(int code, String name, int registrationNumber, GregorianCalendar registrationDate, ArrayList<Double> grades, double value) {
        this.code = code;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.registrationDate = registrationDate;
        this.grades = grades;
        this.value = value;
    }

    public Student() {
        this.grades = new ArrayList<>();
        this.registrationDate = new GregorianCalendar();
    }

    public void addGrade(double n) {
        grades.add(n);
    }

    public double calcFinalGrade() {
        double finalGrade = 0;
        for (Double grade : grades) {
            finalGrade += grade;
        }
        return finalGrade;
    }

    public void printData() {
        SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Object data: ");
        System.out.println(
                "Student object[" + "\n" +
                        "code=" + code + "\n" +
                        "name=" + name + "\n" +
                        "registrationNumber=" + registrationNumber + "\n" +
                        "registrationDate=" + formattedDate.format(registrationDate.getTime()) + "\n" +
                        "grades=" + grades + "\n" +
                        "value=" + value + "\n" +
                        "Final grade=" + calcFinalGrade() + "\n" +
                        ']'
        );
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

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public GregorianCalendar getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(GregorianCalendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ArrayList<Double> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Double> grades) {
        this.grades = grades;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
