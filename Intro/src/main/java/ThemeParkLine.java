import java.util.*;

public class ThemeParkLine {

    // Print the entire queue
    private static void printQueue(Queue<String> line) {
        System.out.println("-------Current Line-------");
        System.out.println("--------------------------");

        int index = 1;
        for (String person : line) {
            System.out.println("%d. %s".formatted(index, person));
            index++;
        }
        System.out.println();
    }

    // Add a person to the queue
    private static void addPerson(Queue<String> line, String name) {
        line.add(name);
    }

    // Remove the next person in line
    private static void removePerson(Queue<String> line) {
        if (!line.isEmpty()) {
            String removed = line.remove();
            System.out.println(removed + " has boarded the ride.");
        } else {
            System.out.println("No one is currently in line.");
        }
        System.out.println();
    }

    // User menu and interface
    private static void userInterface(Queue<String> line) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1) Add Person to Line");
            System.out.println("2) Remove Next Person");
            System.out.println("3) View Entire Line");
            System.out.println("4) Exit");

            int input = scanner.nextInt();

            if (input == 1) {
                String holder = scanner.nextLine(); // consume newline
                String name = scanner.nextLine();
                addPerson(line, name);
                printQueue(line);
            }
            else if (input == 2) {
                removePerson(line);
                printQueue(line);
            }
            else if (input == 3) {
                printQueue(line);
            }
            else if (input == 4) {
                loop = false;
            }
            else {
                System.out.println("Invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        Queue<String> line = new LinkedList<>();
        printQueue(line);  // initial empty line
        userInterface(line);
    }
}
