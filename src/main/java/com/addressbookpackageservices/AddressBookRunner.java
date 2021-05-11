package com.addressbookpackageservices;
import java.util.*;
import java.util.stream.Collectors;

public class AddressBookRunner {

   public final HashMap<String, AddressBookSource> personDetails = new HashMap<>();
   static AddressBookRunner addressBookRunner = new AddressBookRunner();
   private HashMap<String, List<List<Person>>> statePersonDetails = new HashMap<>();
   private HashMap<String, List<List<Person>>> cityPersonDetails = new HashMap<>();
   FileIOServices fileIOServices = new FileIOServices();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO THE ADDRESS BOOK PROGRAM");
        boolean option = true;
        while(option) {

            System.out.println("""
                    1 for adding address book
                    2 for adding contact
                    3 search persons using state
                    4 search persons using city
                    5 enter the state or city name to get count\s
                    6 Sorting details Alphabetically\s
                    7 sort Details by city:
                    8 for exit""");
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> {
                    System.out.println("ENTER THE ADDRESS BOOK NAME");
                    addressBookRunner.personDetails.put(scanner.next(), new AddressBookSource());
                }
                case 2 -> {
                    System.out.println("ENTER THE ADDRESS BOOK NAME TO ADD PERSON");
                    String addressBookName = scanner.next();
                    AddressBookSource addressBookSource = new AddressBookSource();
                    if (addressBookRunner.personDetails.containsKey(addressBookName)) {
                        addressBookRunner.personDetails.put(addressBookName, addressBookSource);
                        addressBookSource.createPerson();
                    } else {
                        System.out.println("Address Book is not present");
                    }
                    addressBookRunner.fileIOServices.writeToFile(addressBookRunner.personDetails);
                }

                case 3 ->{
                    System.out.println("Enter the State Name");
                    Scanner stateName = new Scanner(System.in);
                    String state = stateName.nextLine();
                    addressBookRunner.displayPersonsByState(state);
                }

                case 4 ->{
                    System.out.println("Enter the City Name");
                    Scanner cityName = new Scanner(System.in);
                    String city = cityName.nextLine();
                    addressBookRunner.displayPersonsByCity(city);
                }

                case 5 ->{
                    System.out.println("Enter City or State name to get count");
                    Scanner getCityCount = new Scanner(System.in);
                    String cityOrState = getCityCount.nextLine();
                    addressBookRunner.getCountOfContactDetailsByStateOrCity(cityOrState);
                }

                case 6->{
                    addressBookRunner.sortDetailsAlphabetically();
                }

                case 7 -> {
                    addressBookRunner.sortDetailsByCity();
                }
                default -> {
                      scanner.close();
                        option = false;
                }

            }

        }
        addressBookRunner.personDetails.forEach((key, value)-> System.out.println("Key" +key+ "Value "+value));
        System.out.print(addressBookRunner.fileIOServices.readAddressBookData());

    }


    public void displayPersonsByState(String state){
        List<List<Person>> personsByStateDetails = new ArrayList<>();
        for(Map.Entry<String, AddressBookSource> addressBookSourceEntry : addressBookRunner.personDetails.entrySet()){
            List<Person> byState = addressBookSourceEntry.getValue().getContactsData()
                    .stream().filter(person -> person.getState().equals(state))
                    .collect(Collectors.toList());
                    personsByStateDetails.add(byState);
        }
        statePersonDetails.put(state,personsByStateDetails);
        System.out.println(statePersonDetails.toString());
    }

    private void displayPersonsByCity(String city) {
        List<List<Person>> personsByCityDetails = new ArrayList<>();
        for(Map.Entry<String, AddressBookSource> addressBookSourceEntry : addressBookRunner.personDetails.entrySet()){
            List<Person> byCity = addressBookSourceEntry.getValue().getContactsData()
                    .stream().filter(person -> person.getCity().equals(city))
                    .collect(Collectors.toList());
            personsByCityDetails.add(byCity);
        }
        cityPersonDetails.put(city,personsByCityDetails);
        System.out.println(cityPersonDetails.toString());
    }

    private void getCountOfContactDetailsByStateOrCity(String cityOrState){
        int count = 0 ;
        for(Map.Entry<String, AddressBookSource> addressBookSourceEntry : personDetails.entrySet()){
            for(int i = 0; i<(addressBookSourceEntry.getValue()).getContactsData().size(); i++){
                Person personDetails = addressBookSourceEntry.getValue().getContactsData().get(i);
                if(personDetails.getState().equals(cityOrState) ||
                personDetails.getCity().equals(cityOrState)){
                    count++;
                }
                else{
                    System.out.println("No contact found to display the count");
                }
            }
        }
        System.out.println("Total number of details available in: " +cityOrState+ " is "+count);
    }

    private void sortDetailsAlphabetically(){
        personDetails.forEach((key, value)->
                System.out.println("Sorted contacts by First name: "
                +value.getContactsData().stream()
                .sorted(Comparator.comparing(Person::getFirstName)).collect(Collectors.toList())));
    }

    private void sortDetailsByCity(){
        personDetails.forEach((key,value)->
                System.out.println("Sorting contacts by city: "
                +value.getContactsData().stream()
                        .sorted(Comparator.comparing(Person::getCity)).sorted()
                        .collect(Collectors.toList())));
    }

}


