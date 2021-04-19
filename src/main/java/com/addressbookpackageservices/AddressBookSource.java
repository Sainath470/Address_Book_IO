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

    public  void editDetails(){
        Scanner input = new Scanner(System.in);
        System.out.println("What details you want to edit: ");
        System.out.println("1 for firstname\n2 for last name\n3 for address\n4 for city\n5 for state\n6 for email\n7 for zip code\n8 for phone number\n9 for exit");
        int choice = scanner.nextInt();
        switch(choice){
            case 1:
                System.out.println("first name to be edited to ");
                String fName = input.nextLine();
                this.firstName = fName;
                break;

            case 2:
                System.out.println("last name to be edited to");
                String lName = input.nextLine();
                this.lastName = lName;
                break;
            case 3:
                System.out.println("address to be edited to");
                String newAddress = input.nextLine();
                this.address = newAddress;
                break;
            case 4:
                System.out.println("City to be edited to");
                String newCity = input.nextLine();
                this.city = newCity;
                break;
            case 5:
                System.out.println("State to be edited to");
                String newState = input.nextLine();
                this.state = newState;
                break;
            case 6:
                System.out.println("email to be edited to");
                String newEmail = input.nextLine();
                this.email = newEmail;
                break;
            case 7:
                System.out.println("zip code to be edited to");
                String newZip = input.nextLine();
                this.email = newZip;
                break;
            case 8:
                System.out.println("phone number to be edited to");
                String newPhone = input.nextLine();
                this.email = newPhone;
                break;

            default:
                break;
        }
    }




    @Override
    public String toString() {
        return "AddressBookSource{" +
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
