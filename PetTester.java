public class PetTester {

	public static void main(String [] args) {
		
		VirtualPet myPet = new VirtualPet("Woody");

        System.out.println("Before any action taken: \n" + myPet + "\n");

        myPet.feed();
        System.out.println("After feeding him: \n" + myPet + "\n");

        myPet.play();
        System.out.println("After playing with him: \n" + myPet + "\n");

        myPet.passTime();
        System.out.println("After time passes: \n" + myPet + "\n");

        myPet.play();
        myPet.feed();
        System.out.println("After playing with and feeding him: \n" + myPet + "\n");

        myPet.passTime();
        myPet.passTime();
        myPet.passTime();
        System.out.println("After a lot of time passes: \n" + myPet + "\n");

	}
}