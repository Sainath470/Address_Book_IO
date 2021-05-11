package com.addressbookpackageservices;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class FileIOServices {
    /**
     * File path is declared and initialized
     */
    public static String ADDRESS_BOOK_FILE_PATH = "AddressBook.txt";

    /**
     * created writeToFile method to write the data into the File
     * added try catch for exceptions
     * @param fileAddressBookDictionary where data is present
     */
    public void writeToFile(HashMap<String, AddressBookSource> fileAddressBookDictionary){
        StringBuffer contactsDetailsBuffer = new StringBuffer();
        fileAddressBookDictionary.forEach((key, addressBookSource) -> {
            String contact = addressBookSource.toString().concat("\n");
            contactsDetailsBuffer.append(contact);
        });
        try{
            Files.write(Paths.get(ADDRESS_BOOK_FILE_PATH), contactsDetailsBuffer.toString().getBytes(StandardCharsets.UTF_8));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * created readAddressBookData method to read data from a file
     * @return contactList
     */
    public HashMap<String, AddressBookSource> readAddressBookData() {
        HashMap<String, AddressBookSource> contactList = new HashMap<>();
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_PATH).toPath()).map(String::trim).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contactList;
    }
}
