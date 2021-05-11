package com.addressbookpackageservices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class JSONFile {

    private static final String HOME = System.getProperty("user.dir");
    private static final String fileName = "AddressBook.json";
    private static final Path homePath = Paths.get(HOME);

    private static final Gson gson = new GsonBuilder().create();

    public boolean jsonWriteData(List<String[]> contactInfo)
    {
        if (Files.exists(homePath))
        {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {

                if (Files.exists(filePath))
                {
                    String s = gson.toJson(contactInfo);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                } else {
                    Files.createFile(filePath);
                    String s = gson.toJson(contactInfo);
                    FileWriter fileWriter = new FileWriter(String.valueOf(filePath));
                    fileWriter.write(s);
                    fileWriter.close();
                    return true;
                }
            } catch (IOException e)
            {
                return false;
            }
        }
        return true;
    }

    public boolean jsonReadData()
    {
        if (Files.exists(homePath))
        {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath))
                {
                    BufferedReader br = new BufferedReader(new FileReader(String.valueOf(filePath)));
                    Person contactReader = gson.fromJson(br, Person.class);
                    System.out.println("contactReader{" +
                            "firstName='" + contactReader.firstName + '\'' +
                            ", lastName='" + contactReader.lastName + '\'' +
                            ", address='" + contactReader.address + '\'' +
                            ", city='" + contactReader.city + '\'' +
                            ", state='" + contactReader.state + '\'' +
                            ", zip=" + contactReader.zipCode +
                            ", MobileNo.='" + contactReader.phoneNumber + '\'' +
                            ", email='" + contactReader.email + '\'' +
                            '}' );
                    return true;
                }
            } catch (IOException e)
            {
                return false;
            }
        }
        return true;
    }
}