package com.addressbookpackageservices;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
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
}