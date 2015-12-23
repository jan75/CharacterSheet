package characterClass;

public class Wizard extends CharacterClass{
	
	public Wizard() {
		this.hitDie=6;
		this.name="Wizard";
		this.intProf=true;
		this.wisProf=true;
	}

	public String getName() {
		return name;
	}
}
