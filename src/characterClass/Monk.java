package characterClass;

public class Monk extends CharacterClass{
	public Monk(){
		this.hitDie=8;
		this.name="Monk";
		this.strProf=true;
		this.dexProf=true;
	}

	public String getName() {
		return name;
	}

}
