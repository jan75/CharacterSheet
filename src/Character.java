import java.util.List;

import characterClass.*;
import race.*;
import data.*;

public class Character {
	int dexterity;
	int strength;
	int charisma;
	int intelligence;
	int wisdom;
	int constitution;
	String name;
	Race race;
	CharacterClass characterClass;
	List<Equipment> equipment;
	List<Equipment> weapons;
	Equipment armor;
	int armorClass;
	List<String> proficiencies;
	int proficencybonus;
	Skills skills;
	
	int getStatBonus(int stat){
		return Math.floorDiv(stat, 2)-5;
	}
	int getStatSavingThrow(String stat, int val){
		switch(stat){
		case "strength":
			return characterClass.isStrProf()?getStatBonus(strength)+proficencybonus:getStatBonus(strength);
		case "intelligence":
			return characterClass.isIntProf()?getStatBonus(intelligence)+proficencybonus:getStatBonus(intelligence);
		case "charisma":
			return characterClass.isChaProf()?getStatBonus(charisma)+proficencybonus:getStatBonus(charisma);
		case "constitution":
			return characterClass.isConProf()?getStatBonus(constitution)+proficencybonus:getStatBonus(constitution);
		case "dexterity":
			return characterClass.isDexProf()?getStatBonus(dexterity)+proficencybonus:getStatBonus(dexterity);
		case "wisdom":
			return characterClass.isWisProf()?getStatBonus(wisdom)+proficencybonus:getStatBonus(wisdom);
		default:
			return 0;
		}
	}
}
