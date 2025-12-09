import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Long.parseLong;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/Users/charlesjuliana/ComputerScience/CourseWork/Intro/src/main/java/day2.txt");
        Scanner scanner = new Scanner(data);
        String line = scanner.nextLine();
        long sum = 0;
        ArrayList<Long> invalid = new ArrayList<>();
        String[] ids = line.split(",");
        for (int i = 0; i < ids.length; i++) {
            String[] idnums = ids[i].split("-");
            long first = parseLong(idnums[0]);
            long second = parseLong(idnums[1]);
            for (long j = first; j <= second; j++) {
                String check = String.valueOf(j);
                String firsthalf = check.substring(0, check.length()/2);
                String secondhalf = check.substring(check.length()/2);
                if (firsthalf.equals(secondhalf)) {
                    invalid.add(j);
                }
            }
        }
        for (int i = 0; i < invalid.size(); i++) {
            sum += invalid.get(i);
        }
        System.out.println(sum);
    }
}
