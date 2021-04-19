package com.addressbookpackageservices;
import java.util.*;

public class AddressBookRunner {

    static Map<String, AddressBookSource> personDetails = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("WELCOME TO THE ADDRESS BOOK PROGRAM");
        boolean option = true;
        while(option) {

            System.out.println("1 for adding address book\n2 for adding contact\n3 for exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1 ->{
                    System.out.println("ENTER THE ADDRESS BOOK NAME");
                    personDetails.put(scanner.next(), new AddressBookSource());
                    System.out.println(personDetails.toString());
                }
                case 2 -> {
                    System.out.println("ENTER THE ADDRESS BOOK NAME TO ADD PERSON");
                    String addressBookName = scanner.next();
                    if (personDetails.containsKey(addressBookName)) {
                        AddressBookSource bookSystem = personDetails.get(addressBookName);
                        bookSystem.createPerson();
                    } else {
                        System.out.println("Address Book is not present");
                    }
                    System.out.println(personDetails.toString());
                }
                default -> {
                      scanner.close();
                        option = false;
                }

            }
        }
    }
}
