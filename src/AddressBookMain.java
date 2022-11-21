import java.util.*;

public class AddressBookMain {

    private final List<personDetails> addressBook = new ArrayList<>();

    private static final Scanner sc = new Scanner(System.in);

    private void addPerson() {
        personDetails person = new personDetails();
        System.out.println("Enter First Name");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name");
        String lastName = sc.nextLine();
        System.out.println("Enter Address");
        String address = sc.nextLine();
        System.out.println("Enter City");
        String city = sc.nextLine();
        System.out.println("Enter State");
        String state = sc.nextLine();
        System.out.println("Enter Zip code");
        int zipcode = Integer.parseInt(sc.nextLine());
        System.out.println("Enter Phone Number");
        long phoneNumber = Long.parseLong(sc.nextLine());

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setAddress(address);
        person.setCity(city);
        person.setState(state);
        person.setZipCode(zipcode);
        person.setPhoneNumber(phoneNumber);

        addressBook.add(person);
    }

    private void editPerson() {
        System.out.println("Enter the Name");
        String personName = sc.nextLine();
        personDetails personDetails = null;
        for (personDetails details : addressBook) {
            if (personName.equals(details.getFirstName()) || personName.equals(details.getLastName())) {
                personDetails = details;
                break;
            }
        }
        if (personDetails != null) {
            System.out.println("Enter Address");
            String address = sc.nextLine();
            System.out.println("Enter City");
            String city = sc.nextLine();
            System.out.println("Enter State");
            String state = sc.nextLine();
            System.out.println("Enter Zip code");
            int zipcode = Integer.parseInt(sc.nextLine());
            System.out.println("Enter Phone Number");
            long phoneNumber = Long.parseLong(sc.nextLine());
            personDetails.setAddress(address);
            personDetails.setCity(city);
            personDetails.setState(state);
            personDetails.setZipCode(zipcode);
            personDetails.setPhoneNumber(phoneNumber);
        } else {
            System.out.println("No contacts details found");
        }
    }

    private void deletePerson() {
        System.out.println("Enter the Name");
        String personName = sc.nextLine();
        for (int i = 0; i < addressBook.size(); i++) {
            if (personName.equals(addressBook.get(i).getFirstName()) || personName.equals(addressBook.get(i).getLastName())) {
                addressBook.remove(i);
                System.out.println("Deleting contact......");
            } else {
                System.out.println("No contact found");
            }
        }
    }

    private void showAddressBook() {
        for (personDetails personDetails : addressBook) {
            System.out.println(personDetails);
        }
    }


    public static void main(String[] args) {
        System.out.println("Welcome to Address Book");
        boolean isExit = false;
        AddressBookMain addressBookMain = new AddressBookMain();

        while (!isExit) {
            System.out.println("""
                     Select below
                    1. Add Person details
                    2. Edit person
                    3. Delete Person
                    4. show Address book
                    5. Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addressBookMain.addPerson();
                case 2 -> addressBookMain.editPerson();
                case 3 -> addressBookMain.deletePerson();
                case 4 -> addressBookMain.showAddressBook();
                case 5 -> isExit = true;
                default -> System.out.println("Please enter valid details");
            }
        }
    }
}
