package com.addressbookpackageservices;
import java.util.*;

public class AddressBookRunner {

    static ArrayList<AddressBookSource> personDetails = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("WELCOME TO THE ADDRESS BOOK PROGRAM");
        boolean option = true;
        while(option) {
            System.out.println("1 for adding\n2 for editing\n3 for exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("ENTER THE NUMBER OF CONTACTS TO ADD");
                    int choice = scanner.nextInt();
                    for (int j = 0; j < choice; j++) {
                        AddressBookSource person = new AddressBookSource();
                        person.enterDetails();
                        personDetails.add(person);
                    }
                    System.out.println(personDetails);
                }
                case 2 -> {
                    System.out.println("Please enter the first name of the contact");
                    String input1 = scanner.next();
                    for (AddressBookSource i : personDetails) {
                        if (i.getFirstName().equals(input1)) {
                            i.editDetails();
                        }else System.out.println("not found");
                        System.out.println(personDetails);
                    }
                }
                default -> option = false;
            }
        }
    }
}
