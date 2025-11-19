import java.util.*;

public class UndoRedoSimulator {

    // Print the current text (words in undoStack)
    private static void printText(Stack<String> undoStack) {
        System.out.println("-------Current Text-------");
        System.out.println("--------------------------");
        int index = 1;

        for (String word : undoStack) {
            System.out.println("%d. %s".formatted(index, word));
            index++;
        }
        System.out.println();
    }

    // Type a word → push to undo, clear redo
    private static void typeWord(Stack<String> undo, Stack<String> redo, String word) {
        undo.push(word);
        redo.clear();
    }

    // Undo → move from undo → redo
    private static void undo(Stack<String> undo, Stack<String> redo) {
        if (!undo.isEmpty()) {
            redo.push(undo.pop());
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    // Redo → move from redo → undo
    private static void redo(Stack<String> undo, Stack<String> redo) {
        if (!redo.isEmpty()) {
            undo.push(redo.pop());
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    // User menu + interface
    private static void userInterface(Stack<String> undo, Stack<String> redo) {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            System.out.println("1) Type Word");
            System.out.println("2) Undo");
            System.out.println("3) Redo");
            System.out.println("4) View Current Text");
            System.out.println("5) Exit");

            int input = scanner.nextInt();

            if (input == 1) {
                String holder = scanner.nextLine(); // consume newline
                String word = scanner.nextLine();
                typeWord(undo, redo, word);
                printText(undo);
            }
            else if (input == 2) {
                undo(undo, redo);
                printText(undo);
            }
            else if (input == 3) {
                redo(undo, redo);
                printText(undo);
            }
            else if (input == 4) {
                printText(undo);
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
        Stack<String> undoStack = new Stack<>();
        Stack<String> redoStack = new Stack<>();

        printText(undoStack);
        userInterface(undoStack, redoStack);
    }
}
