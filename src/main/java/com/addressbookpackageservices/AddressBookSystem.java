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


    public void updateMobileNumber(String firstName, long mobileNo)
    {
        int result = addressBookDBSystem.updateMobileNumber(firstName,mobileNo);
        if (result == 0) return;
        Person person = this.getAddressBookData(firstName);
        if (person != null) person.phoneNumber = mobileNo;
    }


    private Person getAddressBookData(String firstName)
    {
        return this.addressBookContactList.stream()
                .filter(addressBookDataItem -> addressBookDataItem.firstName.equals(firstName))
                .findFirst()
                .orElse(null);
    }

    public boolean checkAddressBookInSyncWithDB(String name) {
        List<Person> addressBookDataList = addressBookDBSystem.getAddressbookContactData(name);
        return addressBookDataList.get(0).equals(getEmployeePayrollData(name));
    }

    private Person getEmployeePayrollData(String name) {
        return this.addressBookContactList.stream().filter(employeePayrollDataItem -> employeePayrollDataItem.firstName.equals(name)).findFirst().orElse(null);
    }

}
