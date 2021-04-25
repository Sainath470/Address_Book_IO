package com.addressbookpackageservices;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookRunner {

   private final HashMap<String, AddressBookSource> personDetails = new HashMap<>();
   static AddressBookRunner addressBookRunner = new AddressBookRunner();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE ADDRESS BOOK PROGRAM");
        boolean option = true;
        while(option) {

            System.out.println("1 for adding address book\n2 for adding contact\n3 for searching person by city or state\n4 for exit");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("ENTER THE ADDRESS BOOK NAME");
                    addressBookRunner.personDetails.put(scanner.next(), new AddressBookSource());
                }
                case 2 -> {
                    System.out.println("ENTER THE ADDRESS BOOK NAME TO ADD PERSON");
                    String addressBookName = scanner.next();
                    AddressBookSource addressBookSource = new AddressBookSource();
                    if (addressBookRunner.personDetails.containsKey(addressBookName)) {
                        addressBookRunner.personDetails.put(addressBookName, addressBookSource);
                        addressBookSource.createPerson();

                    } else {
                        System.out.println("Address Book is not present");
                    }
                    System.out.println(addressBookRunner.personDetails.values().toString());
                }
                case 3 -> {
                    System.out.println("ENTER THE CITY NAME OR STATE NAME");
                    String cityOrState = scanner.next();
                    addressBookRunner.searchByCityOrState(cityOrState);
                }
                default -> {
                      scanner.close();
                        option = false;
                }

            }
        }
    }

    public void searchByCityOrState(String cityOrState) {
        for (Map.Entry<String, AddressBookSource> addressBookEntry : addressBookRunner.personDetails.entrySet()) {
            List<Person> cityOrStateData = addressBookEntry.getValue().getPersonsData().stream()
                    .filter(person -> person.getCity().equals(cityOrState) || person.getState().equals(cityOrState)).collect(Collectors.toList());
            System.out.println(cityOrStateData);
        }
    }
}


