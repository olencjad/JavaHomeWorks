package main.java.pl.infoshare.seven.zaddom;

import main.java.pl.infoshare.seven.zaddom.Employee;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;


public class Department {

    private static final Employee defEmp1 = new Employee("Ola", "Dabrowska", "Tester", 9876);
    private static final Employee defEmp2 = new Employee("Agata", "Filip", "Terrorystka", 1);

    // private fields
    private String name;                // nazwa dzialu
    private int noOfEmployees;          // ilosc zatrudnionych w dziale pracownikow
    private List<Employee> employees = new ArrayList();  // lista z pracownikami przypisanymi do dzialu

    // constructors
    public Department()
    {
        this.noOfEmployees = 0;     // tworzony nowy dzial, nie ma pracownikow
    }

    public Department(String name)
    {
        this.name = name;           // przypisanie nazwy do dzialu
        this.noOfEmployees = 0;     // tworzony nowy dzial, nie ma pracownikow
        employees.clear();
        employees.add(defEmp1);
        employees.add(defEmp2);
        noOfEmployees = 2;
    }

    // public methods
    public String getName() {
        return this.name;
    }
    public void setName(String name) {this.name = name;}

    public int getNoOfEmployees() {return this.noOfEmployees;}

    public void addEmployee()        // dodanie nowego pracownika do dzialu
    {
        System.out.println("Dodawanie pracownika do dzialu " + this.name);
        Employee newEmployee = new Employee();      // obiekt pracownik ktory zostanie dodany do listy
        Scanner stdIn = new Scanner(System.in);     // pobieranie danych z konsoli
        // pobieranie potrzebnych danych pracownika
        System.out.print("Podaj imie: ");
        newEmployee.setName(stdIn.nextLine());
        System.out.print("Podaj nazwisko: ");
        newEmployee.setLastName(stdIn.nextLine());
        System.out.print("Podaj stanowisko: ");
        newEmployee.setPosition(stdIn.nextLine());
        System.out.print("Podaj zarobki: ");
        newEmployee.setPosition(stdIn.nextLine());

        noOfEmployees++;

        employees.add(newEmployee);
    }

    public void listAllEmployees()
    {
        int idx = 1;
        System.out.println("Lista pracownikow z " + this.getName());
        for(Employee employee : employees)
        {
            System.out.println(idx + ". " + employee);
            idx++;
        }
    }

    public void delEmployee(int index)
    {
        if (index < employees.size())
        {
            System.out.println("Usuwam pracownika " + employees.get(index));
            employees.remove(index);
            if(noOfEmployees > 0)
                noOfEmployees--;
        }
    }
}

