public class VirtualPet {

	public String name;
	public int hunger;
	public int happiness;

	public VirtualPet(String name) {
    	this.name = name;
        this.hunger = 5;
    	this.happiness = 5;
	}
		
	public void feed() {
    	hunger -= 2;
    	if (hunger < 0) {
        	hunger = 0;
        }
    }

	public void play() {
        happiness += 2;
       	if (happiness > 10) {
        	hunger = 10;
        }
		hunger += 1;
       	if (hunger > 10) {
          	hunger = 10;
    	}
    }

	public void passTime() {
    	happiness -= 1;
    	if (happiness < 0) {
        	hunger = 0;
    	}
		hunger += 1;
    	if (hunger > 10) {
        	hunger = 10;
     	}
    }

	public String toString() {
        return "Name: " + name + "\nHunger: " + hunger + "\nHappiness " + happiness;
    }
}