import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// answer: 17427
public class Day3 {
    public static boolean isHighestNumber(int num, ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {
                return true;
            }
        }
        return false;
    }

    public static int findNumber(int num, ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) == num) {
                return i;
            }
        }
        return -1;
    }

    public static int findHighestNumber(int num, ArrayList<Integer> numbersTwo) {
        num = num * 10;
        for (int i = 9; i > 1; i--) {
            if (isHighestNumber(i, numbersTwo)) {
                return num + i;
            }
        }
        return num + 1;
    }

    public static int process(int num, ArrayList<Integer> numbersOne,  ArrayList<Integer> numbersTwo) {
        if (isHighestNumber(num, numbersOne) && findNumber(num,  numbersOne) != numbersOne.size() - 1) {
            int firstNum = findNumber(num,  numbersOne);
            for (int k = firstNum + 1; k < numbersOne.size(); k++) {
                numbersTwo.add(numbersOne.get(k));
            }
            return (findHighestNumber(num, numbersTwo));
        }
        return -1;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/Users/charlesjuliana/ComputerScience/CourseWork/Intro/src/main/java/day3.txt");
        Scanner scanner = new Scanner(data);
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<Integer> numbersOne = new ArrayList<>();
        ArrayList<Integer> numbersTwo = new ArrayList<>();
        int sum = 0;
        ArrayList<Integer> joltages = new ArrayList<>();
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        for (int i = 0; i < lines.size(); i++) {
            numbersOne.clear();
            numbersTwo.clear();
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                 numbersOne.add(Character.getNumericValue(line.charAt(j)));
            }
            for (int k = 9; k > 1; k--) {
                int x = process(k, numbersOne, numbersTwo);
                if (x != -1) {
                    joltages.add(x);
                    break;
                }
            }
        }
        for (int i = 0; i < joltages.size(); i++) {
            sum += joltages.get(i);
        }
        System.out.println(sum);
    }
}