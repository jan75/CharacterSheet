package race;

import java.util.List;

public class Dragonborn extends Race{
	public Dragonborn() {
		this.name="Dragonborn";
		//this.languages.add("Dragonborn"); // to be corrected, gives NullPointerException
		this.speed=30;
		}

	String getName() {
		return name;
	}
}
