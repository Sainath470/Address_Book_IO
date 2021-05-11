package com.addressbookpackageservices;

import java.util.List;

public class AddressBookSystem
{
    public enum IOService{DB_IO}

    private List<Person> addressBookContactlist;
    private AddressBookDBSystem addressBookDBSystem;

    public AddressBookSystem()
    {
        addressBookDBSystem = addressBookDBSystem.getInstance();

    }

    public AddressBookSystem(List<Person> addressBookContactList)
    {
        this();
        this.addressBookContactlist=addressBookContactList;
    }

    public List<Person> readAddressBookData(IOService ioService){
        if(ioService.equals( IOService.DB_IO ))
            this.addressBookContactlist =  addressBookDBSystem.readData();
        return this.addressBookContactlist;
    }
}
