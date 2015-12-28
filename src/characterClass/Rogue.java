package characterClass;

public class Rogue extends CharacterClass{
	
	public Rogue() {
		this.hitDie=8;
		this.name="Rogue";
		this.dexProf=true;
		this.intProf=true;
	}

	public String getName() {
		return name;
	}
}
