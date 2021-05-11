package com.addressbookpackageservices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class AddressBookDBSystem {
    private static AddressBookDBSystem addressBookDBSystem;


    public static AddressBookDBSystem getInstance()
    {
        if(addressBookDBSystem == null)
            addressBookDBSystem = new AddressBookDBSystem();
        return addressBookDBSystem;
    }

    private Connection getConnection() throws SQLException
    {
        String jdbcURL = "jdbc:mysql://localhost:3306/addressbook_service?useSSL=false";
        String userName = "root";
        String password = "Sainath@8801";
        Connection connection;
        System.out.println("Connecting to database:" + jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }

    public List<Person> readData()
    {
        String sql = "SELECT * FROM  address_book;";
        return this.getPersonDataFromDatabase(sql);
    }

    private List<Person> getPersonDataFromDatabase(String query)
    {
        List<Person> personList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            personList = this.getAddressBookContactData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private List<Person> getAddressBookContactData(ResultSet resultSet)
    {
        List<Person> addressBookContactArrayList = new ArrayList<>();
        try{
            while (resultSet.next()) {
                String firstName = resultSet.getString("Name");
                String lastName = resultSet.getString("lastname");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zipCode = resultSet.getInt("zip");
                long phoneNumber = resultSet.getLong("PhoneNumber");
                String email = resultSet.getString("email");
                addressBookContactArrayList.add(new Person(firstName, lastName, address, city, state, email,  phoneNumber ,zipCode));
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
        return addressBookContactArrayList;
    }
}
