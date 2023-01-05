package oop_2;
import java.util.List;
import java.util.Scanner;

import javax.swing.SortingFocusTraversalPolicy;

import oop_2.model;
import oop_2.person;
import oop_2.mainMenu;
import oop_2.tempTable;

public class controller {
    public static void run(){
        tempTable table = new tempTable();
        Scanner scanner = new Scanner(System.in);
        view vieww = new view();
        model modell = new model(scanner);
        person persn = null;
        List<person> persons = table.gPersons();
        boolean check = true;
        while(check){
            vieww.showMainMenu();
            try {
                mainMenu menuItem = modell.getMenuItem(scanner);
                if(!menuItem.equals(mainMenu.none) && !menuItem.equals(mainMenu.all)){
                    boolean checkInput = false;
                    while(!checkInput){
                        vieww.showMenuSelectionId();
                        Integer id = modell.inputInt(scanner);
                        persn = modell.getPersonById(id, persons);
                        if(persn != null || id.equals(0)) checkInput = true;
                        else vieww.showError();
                    }
                    if (persn == null) continue;
                }
                
                String text = "";
                switch (menuItem) {
                    case all:
                        persons.stream().forEach(p -> System.out.println(p.toString()));
                        break;
                    case parents:
                        vieww.showText("Родители " + persn.toString() + ":\n");
                        text = modell.getParents(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case grandparents:
                        vieww.showText("Бабушки и дедушки " + persn.toString() + ":\n");
                        text = modell.getGrandParents(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case children:
                        vieww.showText("Дети " + persn.toString() + ":\n");
                        text = modell.getChildren(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case siblings:
                        vieww.showText("Братья и сестры " + persn.toString() + ":\n");
                        text = modell.getSiblings(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case auntAndUncles:
                        vieww.showText("Дяди и тети " + persn.toString() + ":\n");
                        text = modell.getAuntAndUncle(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case grandchild:
                        vieww.showText("Внуки " + persn.toString() + ":\n");
                        text = modell.getGrandChildren(persons, persn).toString();
                        vieww.showText((text.equals("[]")) ? "Данные отсутсвуют" : text);
                        break;
                    case none:
                        check = false;
                        break;
                }
                if (check){
                    vieww.showReturnMenu();
                    while(modell.inputInt(scanner) != 0);
                }
                
                
            } catch (Exception e) {
                
            }
            
        } 
        scanner.close();  
    }
}
