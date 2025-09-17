public class VirtualPet {

	public String name;
	public int hunger;
	public int happiness;

	public VirtualPet(String name) {
    	this.name = name;
        this.hunger = 5;
    	this.happiness = 5;
	}

	private void normalizeHappiness() {
		if (happiness > 10) {
        	happiness = 10;
        }
		else if (happiness < 0) {
        	happiness = 0;
    	}
	}

	private void normalizeHunger() {
		if (hunger > 10) {
          	hunger = 10;
    	}
		else if (hunger < 0) {
        	hunger = 0;
        }
	}
	
	private void setHappiness(int amount) {
		happiness = amount;
		normalizeHappiness();
	}

	private void setHunger(int amount) {
		hunger = amount;
		normalizeHunger();
	}

	public void feed() {
    	setHunger(hunger - 2);
    }

	public void play() {
        setHappiness(happiness + 2);
		setHunger(hunger + 1);
    }

	public void passTime() {
    	setHappiness(happiness - 1);
		setHunger(hunger + 1);
    }

	public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappiness() {
        return happiness;
    }

	public String toString() {
        return "Name: " + name + "\nHunger: " + hunger + "\nHappiness " + happiness;
    }
}