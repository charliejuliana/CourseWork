import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import static java.lang.Long.parseLong;

public class Day2Part2 {

    public static boolean isInvalid(int interval, String check, Set<String> place) {
        if (check.length() % interval == 0 && check.length() > interval) {
            for (int i = 0; i < check.length() - interval; i+=interval) {
                place.add(check.substring(i, i + interval));
            }
            place.add(check.substring(check.length() - interval));
            if (place.size() == 1) {
                return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException {
        File data = new File("/Users/charlesjuliana/ComputerScience/CourseWork/Intro/src/main/java/day2.txt");
        Scanner scanner = new Scanner(data);
        String line = scanner.nextLine();
        long sum = 0;
        Set<Long> invalidset = new HashSet<>();
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();
        Set<String> three = new HashSet<>();
        Set<String> four = new HashSet<>();
        Set<String> five = new HashSet<>();
        Set<String> six = new HashSet<>();
        Set<String> seven = new HashSet<>();
        Set<String> eight = new HashSet<>();

        String[] ids = line.split(",");
        for (int i = 0; i < ids.length; i++) {
            String[] idnums = ids[i].split("-");
            long first = parseLong(idnums[0]);
            long second = parseLong(idnums[1]);
            for (long j = first; j <= second; j++) {
                String check = String.valueOf(j);
                if (isInvalid(1,check,one)){
                    invalidset.add(j);
                }
                else if (isInvalid(2,check,two)){
                    invalidset.add(j);
                }
                else if (isInvalid(3,check,three)){
                    invalidset.add(j);
                }
                else if (isInvalid(4,check,four)){
                    invalidset.add(j);
                }
                else if (isInvalid(5,check,five)){
                    invalidset.add(j);
                }
                else if (isInvalid(6,check,six)){
                    invalidset.add(j);
                }
                else if (isInvalid(7,check,seven)){
                    invalidset.add(j);
                }
                else if (isInvalid(8,check,eight)){
                    invalidset.add(j);
                }
                one.clear();
                two.clear();
                three.clear();
                four.clear();
                five.clear();
                six.clear();
                seven.clear();
                eight.clear();
            }
        }
        List<Long> invalid = new ArrayList<>(invalidset);
        for (int i = 0; i < invalid.size(); i++) {
            sum += invalid.get(i);
        }
        System.out.println(sum);
    }
}
