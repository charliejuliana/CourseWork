import java.util.*;

public class HighScoreTracker {
    private static void printArray(int [] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
    private static void printHighScore(int [] array){
        int high = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] > high){
                high = array[i];
            }
        }
        System.out.println("High Score: " + high);
    }

    private static void printAverageScore(int [] array){
        int sum = 0;
        int amount = 0;
        for (int i = 0; i < array.length; i++){
            sum = sum + array[i];
            amount = amount + 1;
        }
        double average = sum / amount;
        System.out.println("Average Score: " + average);
    }

    private static void userInterface(int [] array){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("\n1) Print all scores");
            System.out.println("2) Print highest score");
            System.out.println("3) Print average score");
            System.out.println("4) Enter new score");
            System.out.println("5) Exit");
            int input = scanner.nextInt();
            if (input == 1){
                printArray(array);
            }
            else if (input == 2){
                printHighScore(array);
            }
            else if (input == 3){
                printAverageScore(array);
            }
            else if (input == 4){
                int score = scanner.nextInt();
                int tempnum = array[0];
                int tempindex = 0;
                // finds the lowest number in the array
                for (int i = 0; i < array.length; i++){
                    if (array[i] < tempnum){
                        tempnum = array[i];
                        tempindex = i;
                    }
                }
                // replaces the lowest number with the score the user entered
                if (score > tempnum) {
                    array[tempindex] = score;
                }
            }
            else if (input == 5){
                loop = false;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {100, 56, 76, 87, 93, 34, 67, 88, 45, 93};
        printArray(array);
        userInterface(array);
    }
}