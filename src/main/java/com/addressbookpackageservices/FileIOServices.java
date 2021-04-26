package com.addressbookpackageservices;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileIOServices {

    public static String ADDRESS_BOOK_FILE_NAME = "contacts.txt";


    public void writeToFile(List<Person> personList){
        StringBuffer contactsDetailsBuffer = new StringBuffer();
        personList.forEach(contacts -> {
            String contact = contacts.toString().concat("\n");
            contactsDetailsBuffer.append(contact);
        });
        try{
            Files.write(Paths.get(ADDRESS_BOOK_FILE_NAME), contactsDetailsBuffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printData() {
        try {
            Files.lines(new File(ADDRESS_BOOK_FILE_NAME).toPath()).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
