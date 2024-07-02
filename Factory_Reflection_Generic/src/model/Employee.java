package model;

public class Employee extends Person{
    private String position;

    public Employee(String id, String name, String lastName, String position) {
        super(id, name, lastName);
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                '}';
    }
}
