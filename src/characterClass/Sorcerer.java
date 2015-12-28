package characterClass;

public class Sorcerer extends CharacterClass{

	public Sorcerer() {
		this.hitDie=6;
		this.name="Sorcerer";
		this.chaProf=true;
		this.conProf=true;
	}

	public String getName() {
		return name;
	}
}
