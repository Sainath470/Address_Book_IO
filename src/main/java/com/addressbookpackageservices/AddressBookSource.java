package com.addressbookpackageservices;

import java.util.Scanner;

public class AddressBookSource {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phoneNumber;

    Scanner scanner = new Scanner(System.in);
    public void enterDetails(){
        System.out.println("ENTER THE DETAILS");
        System.out.println("ENTER THE FIRST NAME :");
        this.firstName= scanner.nextLine();
        System.out.println("ENTER THE LAST NAME :");
        this.lastName= scanner.nextLine();
        System.out.println("ENTER THE ADDRESS :");
        this.address= scanner.nextLine();
        System.out.println("ENTER THE CITY :");
        this.city= scanner.nextLine();
        System.out.println("ENTER THE STATE :");
        this.state= scanner.nextLine();
        System.out.println("ENTER THE ZIPCODE :");
        this.zipCode= scanner.nextLine();
        System.out.println("ENTER THE EMAIL :");
        this.email= scanner.nextLine();
        System.out.println("ENTER THE PHONE NUMBER :");
        this.phoneNumber= scanner.nextLine();
    }
    @Override
    public String toString() {
        return "\nAddressBookSource{" +
                "\nfirstName='" + firstName + '\'' +
                " \nLastName='" + lastName + '\'' +
                " \naddress='" + address + '\'' +
                " \ncity='" + city + '\'' +
                " \nstate='" + state + '\'' +
                " \nzipCode='" + zipCode + '\'' +
                " \nemail='" + email + '\'' +
                " \nphoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
