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
                    2. show Address book
                    3. Exit""");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> addressBookMain.addPerson();
                case 2 -> addressBookMain.showAddressBook();
                case 3 -> isExit = true;
                default -> System.out.println("Please enter valid details");
            }
        }
    }
}
