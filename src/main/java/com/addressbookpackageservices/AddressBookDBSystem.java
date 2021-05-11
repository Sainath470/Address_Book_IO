package com.addressbookpackageservices;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDBSystem {
    private static AddressBookDBSystem addressBookDBSystem;
    private PreparedStatement addressBookDataStatement;

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
        Connection connection = null;
        try{
            //calling class for mysql driver
            //loading drivers using forName() method
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded!");
        }catch (ClassNotFoundException e){
            throw new IllegalStateException("Cannot find the driver in the classpath!", e);
        }
        try{
            System.out.println("Connecting to database:"+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL,userName,password);

            System.out.println("Connection is successful!!!"+connection);
        }catch (Exception e){
            e.printStackTrace();
        }
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
            personList = this.getAddressbookContactData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private List<Person> getAddressbookContactData(ResultSet resultSet)
    {
        List<Person> addressBookContactArrayList = new ArrayList<>();
        try{
            while (resultSet.next()) {
                String firstName = resultSet.getString("firstname");
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
    public int updateMobileNumber(String firstName, long mobileNumber)
    {
        return this.updateAddressBookDataUsingStatement(firstName, mobileNumber);
    }

    private int updateAddressBookDataUsingStatement(String firstName, long mobileNumber)
    {
        String sql = String.format("update address_book set PhoneNumber = '%s' where firstname = '%s';", mobileNumber, firstName);
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Person>getAddressbookContactData(String firstName)
    {
        List<Person> personList = null;
        if (this.addressBookDataStatement == null)
            this.prepareStatementForAddressBookData();
        try {
            addressBookDataStatement.setString(1, firstName);
            ResultSet resultSet = addressBookDataStatement.executeQuery();
            personList = this.getAddressbookContactData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    private void prepareStatementForAddressBookData() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE firstname = ?";
            addressBookDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
