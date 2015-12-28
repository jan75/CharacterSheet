package characterClass;

public class Ranger extends CharacterClass{
	
	public Ranger() {
		this.hitDie=10;
		this.name="Ranger";
		this.strProf=true;
		this.dexProf=true;
	}

	public String getName() {
		return name;
	}
}
