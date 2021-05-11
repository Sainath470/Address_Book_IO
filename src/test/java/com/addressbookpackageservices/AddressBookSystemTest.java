package com.addressbookpackageservices;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AddressBookSystemTest {
    @Test
    public void givenCSVFile_WhenRead_ShouldReturn_True() throws IOException, CsvException {
        boolean result = OpenCSVFile.readCSV();
        Assertions.assertTrue(result);
    }

    @Test
    public void givenCSVFile_WhenWritten_ShouldReturn_True() throws IOException
    {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.csv";
        List<String[]> contacts = new ArrayList<>();
        String[] contact1 =
                {
                        "sai",
                        "nath",
                        "some colony",
                        "hyd",
                        "tel",
                        "sa@gmail.com",
                        "12345",
                        "1234"
                };


        contacts.add(contact1);
        boolean result = OpenCSVFile.writeCSVFile(contacts);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenObject_WhenStoredInTheJson_ShouldReturn_TRUE() throws IOException
    {
        String ADDRESS_BOOK_CSV_FILE_PATH = ".src/test/resources/AddressBook.Json";
        List<String[]> contacts = new ArrayList<>();
        String[] contact1 =
                {
                        "sai",
                        "nath",
                        "some colony",
                        "hyd",
                        "tel",
                        "sa@gmail.com",
                        "12345",
                        "1234"
                };


        contacts.add(contact1);
        JSONFile jsonFile = new JSONFile();
        boolean result = jsonFile.jsonWriteData(contacts);
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAddressBookContactsInDB_WhenRetrieved_ShouldMatchContactsCount()
    {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Person> addressBookContactList = addressBookSystem.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        System.out.println(addressBookContactList);
        Assertions.assertEquals(2,addressBookContactList.size());
    }

    @Test
    public void givenNewMobileNumberForEmployee_WhenUpdated_ShouldSyncWithDB()
    {
        AddressBookSystem addressBookService = new AddressBookSystem();
        List<Person> personList = addressBookService.readAddressBookData(AddressBookSystem.IOService.DB_IO);
        addressBookService.updateMobileNumber("sai",708326675);
        System.out.println(personList);
        boolean result = addressBookService.checkAddressBookInSyncWithDB("sai");
        Assertions.assertTrue(result);
    }

    @Test
    public void givenState_WhenRetrieved_ShouldMatchEntryCount()
    {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Person> addressBookDataList = addressBookSystem.countPeopleFromGivenCity(AddressBookSystem.IOService.DB_IO, "hyderabad");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenState_WhenRetrieved_ShouldMatchEntryCountBYState()
    {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        List<Person> addressBookDataList = addressBookSystem.countPeopleFromGivenState(AddressBookSystem.IOService.DB_IO, "telangana");
        Assertions.assertEquals(2, addressBookDataList.size());
    }

    @Test
    public void givenDateRangeWhenRetrieved_ShouldMatchEntryCount() {
        AddressBookSystem addressBookSystem = new AddressBookSystem();
        LocalDate startDate = LocalDate.of(2005, 1, 1);
        LocalDate endDate = LocalDate.now();
        List<Person> addressBookDataList = addressBookSystem.readAddressBookForDateRange(AddressBookSystem
                .IOService.DB_IO, startDate, endDate);
        Assertions.assertEquals(2, addressBookDataList.size());
    }
}