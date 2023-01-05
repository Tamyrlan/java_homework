package oop_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class model {
    Scanner scanner;

    public model(Scanner scanner) {
        this.scanner = scanner;
    }

    public mainMenu getMenuItem(Scanner scanner) {
        int current = inputInt(scanner);
        if (current >= 0 && current < 8)
            return mainMenu.values()[current];
        return null;
    }

    public int inputInt(Scanner scanner) {
        int result = -1;
        try {
            result = scanner.nextInt();
            return result;
        } catch (Exception ex) {
            scanner.next();
            return result;
        }
    }

    public person getPersonById(Integer id, List<person> persons) {
        for (person persn : persons) {
            if (persn.getId().equals(id))
                return persn;
        }
        return null;
    }

    public List<person> getParents(List<person> persons, person person) {
        List<person> parents = new ArrayList<>();
        persons.stream().filter(p -> p.getId().equals(person.getFatherId()) || p.getId().equals(person.getMotherId()))
                .forEach(p -> parents.add(p));
        return parents;
    }

    public List<person> getGrandParents(List<person> persons, person persn) {
        List<person> grandparents = new ArrayList<>();
        List<person> parents = getParents(persons, persn);
        for (person parent : parents) {
            getParents(persons, parent).forEach(p -> grandparents.add(p));
        }
        // for (Person parent : parents) {
        // persons.stream().filter(p -> p.getId().equals(parent.getFatherId()) ||
        // p.getId().equals(parent.getMotherId())).
        // forEach(p -> grandparents.add(p));
        // }
        return grandparents;
    }

    public List<person> getChildren(List<person> persons, person persn) {
        List<person> сhildren = new ArrayList<>();
        for (Integer id : persn.getSonsId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).forEach(p -> сhildren.add(p));
        }
        for (Integer id : persn.getDaughtersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).forEach(p -> сhildren.add(p));
        }
        return сhildren;
    }

    public List<person> getSiblings(List<person> persons, person persn) {
        List<person> siblings = new ArrayList<>();
        for (Integer id : persn.getBrothersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).forEach(p -> siblings.add(p));
        }
        for (Integer id : persn.getSistersId()) {
            persons.stream().filter(p -> p.getId().equals(id) || p.getId().equals(id)).forEach(p -> siblings.add(p));
        }
        return siblings;
    }

    public List<person> getAuntAndUncle(List<person> persons, person persn) {
        List<person> parents = getParents(persons, persn);
        List<person> auntAndUncles = new ArrayList<>();
        for (person parent : parents) {
            getSiblings(persons, persn).stream().forEach(p -> auntAndUncles.add(p));
        }
        return auntAndUncles;
    }

    public List<person> getGrandChildren(List<person> persons, person persn) {
        List<person> childre = getChildren(persons, persn);
        List<person> grandchildren = new ArrayList<>();
        for (person child : childre) {
            getChildren(persons, persn).stream().forEach(p -> grandchildren.add(p));
        }
        return grandchildren;
    }
}
