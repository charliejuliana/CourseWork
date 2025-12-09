import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/Users/charlesjuliana/ComputerScience/CourseWork/Intro/src/main/java/day1-1.txt");
        Scanner scanner = new Scanner(data);
        ArrayList<String> lines = new ArrayList<>();
        int counter = 0;
        int dial = 50;
        int turns;
        int digits;
        int times;
        int twodig;
        while (scanner.hasNext()) {
            lines.add(scanner.nextLine());
        }
        for (int i = 0; i < lines.size(); i++) {

            if (lines.get(i).contains("R")) {
                String[] temp = lines.get(i).split("R");
                digits = temp[1].length();
                turns = Integer.parseInt(temp[1]);
                if (digits < 3) {
                    if (dial + turns >= 100) {
                        counter++;
                    }
                }
                if (digits == 3) {
                    times = Integer.parseInt(temp[1].substring(0,1));
                    counter += times;
                    twodig = Integer.parseInt(temp[1].substring(1));
                    if (dial + twodig >= 100) {
                        counter++;
                    }
                }
                dial = ((dial + turns) % 100 + 100) % 100;;
            }
            else  {
                String[] temp = lines.get(i).split("L");
                digits = temp[1].length();
                turns = Integer.parseInt(temp[1]);
                if (digits < 3) {
                    if (dial - turns <= 0) {
                        counter++;
                        if (dial == 0) {
                            counter--;
                        }
                    }
                }
                if (digits == 3) {
                    times = Integer.parseInt(temp[1].substring(0,1));
                    counter += times;
                    twodig = Integer.parseInt(temp[1].substring(1));
                    if (dial - twodig <= 0) {
                        counter++;
                        if (dial == 0) {
                            counter--;
                        }
                    }
                }
                dial = ((dial - turns) % 100 + 100) % 100;
                ;
            }
        }
        System.out.println(counter);
    }
}
