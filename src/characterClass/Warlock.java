package characterClass;

public class Warlock extends CharacterClass{

	public Warlock() {
		this.hitDie=8;
		this.name="Warlock";
		this.wisProf=true;
		this.chaProf=true;
	}

	public String getName() {
		return name;
	}
}
