package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Palawan");
        addInOrder(placesToVisit, "Boracay");
        addInOrder(placesToVisit, "Baguio");
        addInOrder(placesToVisit, "Bohol");
        addInOrder(placesToVisit, "Iloilo");
        addInOrder(placesToVisit, "Manila");

//        printList(placesToVisit);

        addInOrder(placesToVisit, "Bacolod");
        addInOrder(placesToVisit, "Japan");

//        printList(placesToVisit);
        visit(placesToVisit);


//        placesToVisit.add("Palawan");
//        placesToVisit.add("Boracay");
//        placesToVisit.add("Baguio");
//        placesToVisit.add("Bohol");
//        placesToVisit.add("Iloilo");
//
//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Manila");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//
//        printList(placesToVisit);


    }

    private static void printList(LinkedList<String> placesToVisit) {
        Iterator<String> i = placesToVisit.iterator();
        while (i.hasNext()) {
            System.out.println("Now visiting " + i.next());

        }
        System.out.println("=========================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + " is already included as a destination");
                return false;
            } else if (comparison > 0) {
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {
                //move to the next city
            }
        }
        stringListIterator.add(newCity);
        return true;

    }

    private static void visit(LinkedList cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No places to visit");
            return;
        } else {
            System.out.println("Now visiting " + listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (Vacation) over");
                    quit = true;
                    break;
                case 1:
                    if(!goingForward) {
                        if(listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    }else{
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if(goingForward) {
                        if(listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list");
                        goingForward = true;
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - print menu options");
    }


}
