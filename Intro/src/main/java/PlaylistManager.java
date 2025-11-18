import java.util.*;

public class PlaylistManager {
    private static void printArray(List<String> list) {
        int index = 1;
        System.out.println("-------Playlist-------");
        System.out.println("----------------------");
        for (String s : list) {
            System.out.println("%d. %s".formatted(index, s));
            index += 1;
        }
        System.out.println();
    }
    private static void addSong(List<String> list, String songName){
        list.add(songName);
    }

    private static void removeSong(List<String> list, String songName){
        if (list.contains(songName)){
            list.remove(songName);
        }
        else {
            System.out.println("That song is not currently in the playlist.");
        }
    }

    private static void userInterface(List<String> list){
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while(loop){
            System.out.println("1) Add Song");
            System.out.println("2) Remove Song");
            System.out.println("3) View Playlist");
            System.out.println("4) Exit");
            int input = scanner.nextInt();
            if (input == 1){
                String holder = scanner.nextLine();
                String songName = scanner.nextLine();
                addSong(list, songName);
                printArray(list);
            }
            else if (input == 2){
                String holder = scanner.nextLine();
                String songName = scanner.nextLine();
                removeSong(list, songName);
                printArray(list);
            }
            else if (input == 3){
                printArray(list);
            }
            else if (input == 4){
                loop = false;
            }
            else {
                System.out.println("Invalid input");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<String> songs = new ArrayList<>();
        printArray(songs);
        userInterface(songs);
    }
}