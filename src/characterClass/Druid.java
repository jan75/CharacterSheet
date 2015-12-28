package characterClass;

public class Druid extends CharacterClass{

	public Druid() {
		this.hitDie=8;
		this.name="Druid";
		this.wisProf=true;
		this.intProf=true;
	}

	public String getName() {
		return name;
	}

}
