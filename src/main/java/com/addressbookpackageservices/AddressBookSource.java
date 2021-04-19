package com.addressbookpackageservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookSource {


    private static Scanner scanner = new Scanner(System.in);
    List<Person> personList = new ArrayList<>();


    private static Person addPerson() {
        Person person = new Person();
        System.out.println("Please enter first name");
        String firstName = scanner.next();
        person.setFirstName(firstName);
        System.out.println("Please enter last name");
        String lastName = scanner.next();
        person.setLastName(lastName);
        System.out.println("Please enter address");
        String address = scanner.next();
        person.setAddress(address);
        System.out.println("Please enter city");
        String city = scanner.next();
        person.setCity(city);
        System.out.println("Please enter state");
        String state = scanner.next();
        person.setState(state);
        System.out.println("Please enter phone number");
        String phoneNumber = scanner.next();
        person.setPhoneNumber(phoneNumber);
        System.out.println("Please enter zip code");
        String zipCode = scanner.next();
        person.setZipCode(zipCode);
        System.out.println("Please enter email");
        String email = scanner.next();
        person.setEmail(email);
        return person;
    }

    private static Person editPerson(Person person) {
        System.out.println("Please enter first name");
        String firstName = scanner.next();
        person.setFirstName(firstName);
        System.out.println("Please enter last name");
        String lastName = scanner.next();
        person.setLastName(lastName);
        System.out.println("Please enter address");
        String address = scanner.next();
        person.setAddress(address);
        System.out.println("Please enter city");
        String city = scanner.next();
        person.setCity(city);
        System.out.println("Please enter state");
        String state = scanner.next();
        person.setState(state);
        System.out.println("Please enter phone number");
        String phoneNumber = scanner.next();
        person.setPhoneNumber(phoneNumber);
        System.out.println("Please enter zip code");
        String zipCode = scanner.next();
        person.setZipCode(zipCode);
        System.out.println("Please enter email");
        String email = scanner.next();
        person.setEmail(email);
        return person;
    }

    public void createPerson() {
        System.out.println("Welcome to address book");

        boolean isExit = false;
        while (!isExit) {
            System.out.println("Please select\n1.Adding Person\n2.Updating Person\n3.Delete Person\n4.Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    if (!duplicateCheck(getFName(),getLName())){
                        personList.add(addPerson());
                    }
                    System.out.println(personList.toString());
                }
                case 2 -> {
                    System.out.println("Please enter name to Update");
                    Person person1 = findPerson(getFName());
                    if (person1 != null) {
                        editPerson(person1);
                    }
                    System.out.println(personList.toString());
                }
                case 3 -> {
                    System.out.println("Please enter name to Delete");
                    Person person = findPerson(getFName());
                    if (person != null) {
                        personList.remove(person);
                    }
                    System.out.println(personList.toString());
                }
                default -> isExit = true;
            }
        }

    }

    private boolean isPersonExist(String name) {
        return personList.stream()
                .anyMatch(personElement -> personElement.getFirstName().equals(name) || personElement
                        .getLastName().equals(name));
    }

    private Person findPerson(String name) {
        Person person = personList.stream().filter(
                personElement -> personElement.getFirstName().equals(name) || personElement
                        .getLastName().equals(name))
                .findFirst().orElse(null);

        if (person == null) {
            System.out.println("No person present matching with your name");
            return null;
        } else {
            return person;
        }

    }

    private static String getFName() {
        System.out.println("Please enter name");
        return scanner.next();
    }


    private static String getLName() {
        System.out.println("Please enter name");
        return scanner.next();
    }

    private boolean duplicateCheck(String firstname, String lastname){
        return personList.stream().anyMatch(element -> element.getFirstName().equals(firstname) &&
                element.getLastName().equals(lastname));
    }


}
