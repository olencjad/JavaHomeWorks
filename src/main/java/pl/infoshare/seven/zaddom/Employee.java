package main.java.pl.infoshare.seven.zaddom;

public class Employee {

    private String name;
    private String lastName;
    private String position;
    private int salary;

    public Employee () {}

    public Employee(String name, String lastName, String postion, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.position = postion;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + " " + lastName + "\t\t" + position + "\t" + salary + "zl";
    }
}
