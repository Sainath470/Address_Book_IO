package com.addressbookpackageservices;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class OpenCSVFile {
    private static String HOME = System.getProperty("user.dir");
    private static String fileName = "AddressBook.csv";
    private static Path homePath = Paths.get(HOME);

    public static boolean readCSV() throws IOException , CsvException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            if (Files.exists(filePath)) {
                CSVReader csvreader = new CSVReader(new FileReader(String.valueOf(filePath)));
                String[] line = csvreader.readNext();
                while (line != null) {
                    System.out.println(line);
                    line = csvreader.readNext();
                }
                csvreader.close();
            }
        }
        return true;
    }

    public static boolean writeCSVFile(List<String[]> addContact) throws IOException {
        if (Files.exists(homePath)) {
            Path filePath = Paths.get(HOME + "/" + fileName);
            try {
                if (Files.exists(filePath)) {
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                    return true;
                } else {
                    Files.createFile(filePath);
                    CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)));
                    for (String[] contact : addContact) {
                        writer.writeNext(contact);
                    }
                    writer.flush();
                    return true;
                }
            } catch (IOException e) {
                return false;
            }
        } else return false;

    }
}