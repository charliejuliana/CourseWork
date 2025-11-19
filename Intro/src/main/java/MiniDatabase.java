import java.util.*;

public class MiniDatabase {

    // Print all students and their grade lists
    private static void printDatabase(HashMap<String, ArrayList<Integer>> db) {
        System.out.println("------- Student Grades Database -------");
        System.out.println("---------------------------------------");

        int index = 1;
        for (String student : db.keySet()) {
            ArrayList<Integer> grades = db.get(student);
            System.out.println("%d. %s: %s".formatted(index, student, grades.toString()));
            index++;
        }
        System.out.println();
    }

    // Add a new student entry OR add grades to existing student
    private static void addGrade(HashMap<String, ArrayList<Integer>> db, String name, int grade) {
        if (!db.containsKey(name)) {
            db.put(name, new ArrayList<>());
        }
        db.get(name).add(grade);
    }

    // Search for a student's grades
    private static void searchStudent(HashMap<String, ArrayList<Integer>> db, String name) {
        if (db.containsKey(name)) {
            System.out.println(name + "'s grades: " + db.get(name));
        } else {
            System.out.println("Student not found.");
        }
        System.out.println();
    }

    // Remove a student entirely
    private static void removeStudent(HashMap<String, ArrayList<Integer>> db, String name) {
        if (db.containsKey(name)) {
            db.remove(name);
            System.out.println(name + " removed from database.");
        } else {
            System.out.println("That student is not in the database.");
        }
        System.out.println();
    }

    // User menu + interface
    private static void userInterface(HashMap<String, ArrayList<Integer>> db) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1) Add Grade");
            System.out.println("2) Search Student");
            System.out.println("3) Remove Student");
            System.out.println("4) View All Students");
            System.out.println("5) Exit");

            int input = scanner.nextInt();

            // Add a grade
            if (input == 1) {
                String holder = scanner.nextLine(); // consume newline
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();
                System.out.print("Enter grade (integer): ");
                int grade = scanner.nextInt();

                addGrade(db, name, grade);
                printDatabase(db);
            }

            // Search student
            else if (input == 2) {
                String holder = scanner.nextLine();
                System.out.print("Enter student name: ");
                String name = scanner.nextLine();

                searchStudent(db, name);
            }

            // Remove student
            else if (input == 3) {
                String holder = scanner.nextLine();
                System.out.print("Enter student name to remove: ");
                String name = scanner.nextLine();

                removeStudent(db, name);
                printDatabase(db);
            }

            // View all
            else if (input == 4) {
                printDatabase(db);
            }

            // Exit
            else if (input == 5) {
                loop = false;
            }

            else {
                System.out.println("Invalid input.");
            }
        }
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Integer>> studentDB = new HashMap<>();
        printDatabase(studentDB);
        userInterface(studentDB);
    }
}
