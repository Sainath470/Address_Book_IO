package com.addressbookpackageservices;

import java.util.*;

public class AddressBookSource {
    private static Scanner scanner = new Scanner(System.in);
     ArrayList<Person> personList;
     FileIOServices fileIOServices = new FileIOServices();
    public AddressBookSource() {
        personList = new ArrayList<>();
    }


    private Person addPerson() {
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
        long phoneNumber = scanner.nextLong();
        person.setPhoneNumber(phoneNumber);
        System.out.println("Please enter email");
        String email = scanner.next();
        person.setEmail(email);
        System.out.println("Please enter zip code");
        int zipCode = scanner.nextInt();
        person.setZipCode(zipCode);
        return person;
    }

    private static Person editPerson(Person person) {
        System.out.println("1 for firstname\n2 for last name\n3 for address\n4 for city\n5 for state\n6 for email\n7 for zip code\n8 for phone number\n9 for exit ");
        int input = scanner.nextInt();
        switch(input) {
            case 1 ->{
                System.out.println("Please enter first name");
                String firstName = scanner.next();
                person.setFirstName(firstName);
            }
            case 2 -> {
                System.out.println("Please enter last name");
                String lastName = scanner.next();
                person.setLastName(lastName);
            }
            case 3 -> {
                System.out.println("Please enter address");
                String address = scanner.next();
                person.setAddress(address);
            }
            case 4 -> {
                System.out.println("Please enter city");
                String city = scanner.next();
                person.setCity(city);
            }
            case 5 -> {
                System.out.println("Please enter state");
                String state = scanner.next();
                person.setState(state);
            }
            case 6 -> {
                System.out.println("Please enter phone number");
                long phoneNumber = scanner.nextLong();
                person.setPhoneNumber(phoneNumber);
            }
            case 7 -> {
                System.out.println("Please enter zip code");
                int zipCode = scanner.nextInt();
                person.setZipCode(zipCode);
            }
            case 8 -> {
                System.out.println("Please enter email");
                String email = scanner.next();
                person.setEmail(email);
            }
        }
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
                        System.out.println("Hurray no duplicates are present");
                        System.out.println("Proceed with adding");
                        personList.add(addPerson());
                    }else
                    {
                        System.out.println("Contact is already saved with that name");
                        System.out.println("Please enter with different credentials or update the existing one");
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
        System.out.println("Checking for duplicates");
        System.out.println("Please enter first name");
        return scanner.next();
    }


    private static String getLName() {
        System.out.println("Please enter last name");
        return scanner.next();
    }


    private boolean duplicateCheck(String firstname, String lastname){
        return personList.stream().anyMatch(element -> element.getFirstName().equals(firstname) &&
                element.getLastName().equals(lastname));
    }

    public ArrayList<Person> getContactsData() {
        return personList;
    }

    @Override
    public String toString() {
        return "AddressBookSource{" +
                "personList=" + personList +
                '}';
    }
}
