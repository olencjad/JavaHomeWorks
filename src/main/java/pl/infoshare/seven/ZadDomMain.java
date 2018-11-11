package main.java.pl.infoshare.seven;
import main.java.pl.infoshare.seven.zaddom.HumanResources;

public class ZadDomMain {

    public static void main(String[] args)    {
        HumanResources catalog = new HumanResources();
        while(catalog.runAppMenu() == true);
    }
}