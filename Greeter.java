import java.util.Scanner;
public class Greeter {
	
	public static void main(String [] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = input.nextLine();

		System.out.println(" Hi " + name + ", welcome to Java and Git!");

		// 1. javac compiles the code so that you're able to run it
		// 2. java Greeter runs the compiled code
		// 3. Git is helpful because it allows everything to be organized in your git account
		// 4. The user input goes in the next line rather than the coder already having a name there, it asks the person running the code not nesessarily the person who creates it

	}
}