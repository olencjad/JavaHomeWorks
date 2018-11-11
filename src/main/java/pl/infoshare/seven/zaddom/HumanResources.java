package main.java.pl.infoshare.seven.zaddom;

import main.java.pl.infoshare.seven.zaddom.Department;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HumanResources
{
    private static final int MAIN_MENU = 0;
    private static final int DEP_MENU = 1;
    private static final int CLOSE_APP = 0;
    private static final int ADD_EMP= 1;
    private static final int DEL_EMP= 2;
    private static final int LIST_EMP= 3;
    private static final int CHG_DEPT= 4;

    // private fields
    private int currentMenu;            // gdzie aktualnie jestem w menu
    private Department currentDept;            // ktory dzial chcemy modyfikowac
    private List<Department> depList = new ArrayList();
    private Scanner stdIn = new Scanner(System.in);
    private int readKey = 0;

    // constructors
    public HumanResources()
    {
        this.currentMenu = MAIN_MENU;     // tworzony nowy dzial, nie ma pracownikow
        Department hardware = new Department("Hardware");
        Department firmware = new Department("Firmware");
        depList.add(hardware);
        depList.add(firmware);
    }

    public boolean runAppMenu()        // dodanie nowego pracownika do dzialu
    {
        switch(currentMenu)
        {
            case MAIN_MENU:
            {
                int idx = 1;
                for(Department dept : depList)
                {
                    System.out.println(idx + ". " + dept.getName());
                    idx++;
                }
                System.out.println(CLOSE_APP + ". wyjscie");
                System.out.print("Wybierz dzial: ");
                readKey = stdIn.nextInt();
                if(readKey == CLOSE_APP)
                    return false;
                readKey--;
                if(readKey < depList.size())
                {
                    currentDept = depList.get(readKey);
                    System.out.println("Wybrales " + readKey + " - " + currentDept.getName());
                    currentMenu = DEP_MENU;
                }
                System.out.println();
                System.out.println("-------------------");
            }
            break;
            case DEP_MENU:
            {
                System.out.println("Wybierz akcje ktora chcesz wykonac w dziale " + currentDept.getName());
                System.out.println(ADD_EMP + ". Dodaj pracownika");
                System.out.println(DEL_EMP + ". Usun pracownika");
                System.out.println(LIST_EMP + ". Wyswietl liste pracownikow");
                System.out.println(CHG_DEPT + ". Zmien dzial");
                System.out.println(CLOSE_APP + ". Zakoncz");
                System.out.print("Twoj wybor: ");

                readKey = stdIn.nextInt();
                switch(readKey)
                {
                    case ADD_EMP:
                        currentDept.addEmployee();
                        break;
                    case DEL_EMP:
                        currentDept.listAllEmployees();
                        System.out.println();
                        System.out.print("Ktorego chcesz usunac (0 - anuluj): ");
                        readKey = stdIn.nextInt();
                        if(readKey == 0)
                            break;
                        readKey--;
                        if(readKey < currentDept.getNoOfEmployees())
                        {
                            currentDept.delEmployee(readKey);
                        }
                        else
                            System.out.println("Nie ma takiego praconika");
                        break;
                    case LIST_EMP:
                        currentDept.listAllEmployees();
                        System.out.println();
                        System.out.println("-------------------");
                        break;
                    case CHG_DEPT:
                        currentMenu = MAIN_MENU;
                        System.out.println();
                        System.out.println("-------------------");
                        break;
                    case CLOSE_APP:
                    default:
                        return false;
                }
            }
            break;
        }

        return true;
    }
}

