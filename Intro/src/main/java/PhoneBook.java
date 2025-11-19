import java.util.*;

public class PhoneBook {

    // Print all contacts
    private static void printContacts(HashMap<String, String> book) {
        System.out.println("-------Phone Book-------");
        System.out.println("------------------------");

        int index = 1;
        for (String name : book.keySet()) {
            String number = book.get(name);
            System.out.println("%d. %s - %s".formatted(index, name, number));
            index++;
        }
        System.out.println();
    }

    // Add a contact
    private static void addContact(HashMap<String, String> book, String name, String number) {
        book.put(name, number);
    }

    // Look up a contact
    private static void lookupContact(HashMap<String, String> book, String name) {
        if (book.containsKey(name)) {
            System.out.println(name + "'s number: " + book.get(name));
        } else {
            System.out.println("That contact does not exist.");
        }
        System.out.println();
    }

    // Delete a contact
    private static void deleteContact(HashMap<String, String> book, String name) {
        if (book.containsKey(name)) {
            book.remove(name);
            System.out.println(name + " removed.");
        } else {
            System.out.println("That contact is not in the phone book.");
        }
        System.out.println();
    }

    // Menu / User interface
    private static void userInterface(HashMap<String, String> book) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1) Add New Contact");
            System.out.println("2) Look Up Contact");
            System.out.println("3) Delete Contact");
            System.out.println("4) View All Contacts");
            System.out.println("5) Exit");

            int input = scanner.nextInt();

            if (input == 1) {
                String holder = scanner.nextLine(); // consume leftover newline
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter phone number: ");
                String number = scanner.nextLine();

                addContact(book, name, number);
                printContacts(book);
            }
            else if (input == 2) {
                String holder = scanner.nextLine();
                System.out.print("Enter name to look up: ");
                String name = scanner.nextLine();

                lookupContact(book, name);
            }
            else if (input == 3) {
                String holder = scanner.nextLine();
                System.out.print("Enter name to delete: ");
                String name = scanner.nextLine();

                deleteContact(book, name);
                printContacts(book);
            }
            else if (input == 4) {
                printContacts(book);
            }
            else if (input == 5) {
                loop = false;
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        printContacts(phoneBook);
        userInterface(phoneBook);
    }
}
