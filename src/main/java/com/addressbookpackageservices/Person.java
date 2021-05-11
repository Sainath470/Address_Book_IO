package com.addressbookpackageservices;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import java.util.Objects;

public class Person extends AddressBookRunner{

        //Declaring Varaibles
        @CsvBindByName(column = "firstName",required = true)
        @CsvBindByPosition(position = 0)
        public  String firstName;
        @CsvBindByName(column = "lastName",required = true)
        @CsvBindByPosition(position = 1)
        public String lastName;
        @CsvBindByName(column = "address",required = true)
        @CsvBindByPosition(position = 2)
        public String address;
        @CsvBindByName(column = "city",required = true)
        @CsvBindByPosition(position = 3)
        public String city;
        @CsvBindByName(column = "state",required = true)
        @CsvBindByPosition(position = 4)
        public String state;
        @CsvBindByName(column = "zipCode",required = true)
        @CsvBindByPosition(position = 5)
        public int zipCode;
        @CsvBindByName(column = "phoneNumber",required = true)
        @CsvBindByPosition(position = 6)
        public long phoneNumber;
        @CsvBindByName(column = "email",required = true)
        @CsvBindByPosition(position = 7)
        public String email;

        Person(){
        }
        //parameterized Constructor
        public Person(String firstName, String lastName, String address, String city, String state, String email, long phoneNumber,int zipCode) {
            setFirstName(firstName);
            setLastName(lastName);
            setAddress(address);
            setCity(city);
            setState(state);
            setZipCode(zipCode);
            setPhoneNumber(phoneNumber);
            setEmail(email);
        }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return  Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName) ;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
