package characterClass;

public abstract class CharacterClass {
   String name;
   int hitDie;
   public boolean isStrProf() {
	return strProf;
}
public void setStrProf(boolean strProf) {
	this.strProf = strProf;
}
public boolean isConProf() {
	return conProf;
}
public void setConProf(boolean conProf) {
	this.conProf = conProf;
}
public boolean isIntProf() {
	return intProf;
}
public void setIntProf(boolean intProf) {
	this.intProf = intProf;
}
public boolean isChaProf() {
	return chaProf;
}
public void setChaProf(boolean chaProf) {
	this.chaProf = chaProf;
}
public boolean isDexProf() {
	return dexProf;
}
public void setDexProf(boolean dexProf) {
	this.dexProf = dexProf;
}
public boolean isWisProf() {
	return wisProf;
}
public void setWisProf(boolean wisProf) {
	this.wisProf = wisProf;
}
boolean strProf=false;
   boolean conProf=false;
   boolean intProf=false;
   boolean chaProf=false;
   boolean dexProf=false;
   boolean wisProf=false;

	public abstract String getName();

	public static CharacterClass createCharClass(String name) {
		CharacterClass tmpCharClass;
		switch (name) {
			case "Barbarian": tmpCharClass = new Barbarian();
				break;
			case "Bard": tmpCharClass = new Bard();
				break;
			case "Cleric": tmpCharClass = new Cleric();
				break;
			case "Druid": tmpCharClass = new Druid();
				break;
			case "Fighter": tmpCharClass = new Fighter();
				break;
			case "Monk": tmpCharClass = new Monk();
				break;
			case "Paladin": tmpCharClass = new Paladin();
				break;
			case "Ranger": tmpCharClass = new Ranger();
				break;
			case "Rogue": tmpCharClass = new Rogue();
				break;
			case "Sorcerer": tmpCharClass = new Sorcerer();
				break;
			case "Warlock": tmpCharClass = new Warlock();
				break;
			case "Wizard": tmpCharClass = new Wizard();
				break;
			default:
				tmpCharClass = new Barbarian(); // to be defined: exception
				System.out.println("Default CharacterClass!");
				break;
		}
		return tmpCharClass;
	}
	public int getHitDie() {
		// TODO Auto-generated method stub
		return hitDie;
	}
}
