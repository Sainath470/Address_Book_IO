package com.addressbookpackageservices;

import java.util.List;

public class AddressBookSystem
{
    public enum IOService{DB_IO}

    private List<Person> addressBookContactList;
    private AddressBookDBSystem addressBookDBSystem;

    public AddressBookSystem()
    {
        addressBookDBSystem = addressBookDBSystem.getInstance();

    }

    public AddressBookSystem(List<Person> addressBookContactList)
    {
        this();
        this.addressBookContactList =addressBookContactList;
    }

    public List<Person> readAddressBookData(IOService ioService){
        if(ioService.equals( IOService.DB_IO ))
            this.addressBookContactList =  addressBookDBSystem.readData();
        return this.addressBookContactList;
    }
}
