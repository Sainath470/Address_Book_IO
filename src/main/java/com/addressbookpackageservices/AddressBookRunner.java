package com.addressbookpackageservices;

import java.util.HashSet;

public class AddressBookRunner {

    static HashSet<AddressBookSource> personDetails = new HashSet<>();

    public static void main(String[] args) {
        System.out.println("WELCOME TO THE ADDRESS BOOK PROGRAM");
        AddressBookSource addPerson = new AddressBookSource();
        addPerson.enterDetails();
        personDetails.add(addPerson);
        System.out.println(personDetails);
    }
}
