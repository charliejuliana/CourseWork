import java.util.Scanner;
public class PetGame {
	
	public static void main(String [] args) {

		Scanner input = new Scanner(System.in);
		
        VirtualPet myPet = new VirtualPet("Woody");

        boolean run = true;

        while(run) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1: Feed " + myPet.getName());
            System.out.println("2: Play with " + myPet.getName());
            System.out.println("3: Pass time while doing nothing with " + myPet.getName());
            System.out.println("4: Quit");
            System.out.print("Choose an option: ");
            
            int decision;
            if (input.hasNextInt()){
                decision = input.nextInt();
            }
            else {
                System.out.println("Invalid choice. please enter a number 1-4.");
                input.next();
                continue;
            }
            switch (decision) {
                case 1:
                    myPet.feed();
                    System.out.println("You fed " + myPet.getName() + ".");
                    break;
                case 2:
                    myPet.play();
                    System.out.println("You played with " + myPet.getName() + ".");
                    break;
                case 3:
                    myPet.passTime();
                    System.out.println("Time passed...");
                    break;
                case 4:
                    run = false;
                    System.out.println("Thanks for playing!");
                    continue;
                default:
                    System.out.println("Invalid choice. Please enter a number 1-4.");
                    continue;
            }

            System.out.println(myPet);

            if (myPet.getHappiness() == 0 && myPet.getHunger() == 10) {
                System.out.println("Oh no! " + myPet.getName() + " became too sad and too hungry. Game over.");
                run = false;
            }
            else if (myPet.getHappiness() == 0) {
                System.out.println("Oh no! " + myPet.getName() + " became too sad. Game over.");
                run = false;
            }
            else if (myPet.getHunger() == 10) {
                System.out.println("Oh no! " + myPet.getName() + " became too hungry. Game over.");
                run = false;
            }
        }
    }
}