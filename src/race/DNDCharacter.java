package race;

import characterClass.CharacterClass;
import data.Equipment;
import data.Skills;
import data.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class DNDCharacter {
	public int dexterity;
	public int strength;
	public int charisma;
	public int intelligence;
	public int wisdom;
	public int constitution;
	public int level;
	public String name;
	public Race race;
	public CharacterClass characterClass;
	public List<Equipment> equipment;
	public List<Equipment> weapons;
	public List<Spell> spells;
	public Equipment armor;
	public int armorClass;
	public List<String> proficiencies;
	public List<String> personalityTraits;
	public List<String> ideals;
	public List<String> bonds;
	public List<String> flaws;
	public List<String> featuresTraits;
	public int proficencybonus;
	public Skills skills;

	public DNDCharacter(String name, Race race, CharacterClass characterClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int level, List<Equipment> equipment, List<Equipment> weapons, List<Spell> spells, Equipment armor, List<String> proficiencies, Skills skills) {
		this.name = name;
		this.race = race;
		this.characterClass = characterClass;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.level = level;
		this.equipment = equipment;
		this.weapons = weapons;
		this.spells = spells;
		this.armor = armor;
		this.proficiencies = proficiencies;
		this.skills = skills;
	}

	public int getStatBonus(int stat){
		return Math.floorDiv(stat, 2) -5;
	}

	public String getName() {
		return name;
	}

	public int getStrength() {
		return strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public int getConstitution() {
		return constitution;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public int getWisdom() {
		return wisdom;
	}

	public int getCharisma() {
		return charisma;
	}

	public int getLevel() {
		return level;
	}

	public String getRaceName() {
		return race.getName();
	}

	public String getCharClassName() {
		return characterClass.getName();
	}

	public ArrayList<String> getProficiencies() {
		ArrayList<String> tmpList = new ArrayList();
		tmpList.addAll(proficiencies);
		return tmpList;
	}

	public ArrayList<String> getSpellKeysList() {
		ArrayList<String> tmpList = new ArrayList();
		tmpList.clear();
		ListIterator<Spell> tmpIterator = spells.listIterator();
		while(tmpIterator.hasNext()) {
			Spell spell = tmpIterator.next();
			tmpList.add(spell.getKey());
		}
		return tmpList;
	}

	public ArrayList<String> getEquipmentKeysList(boolean isWeapon) {
		ArrayList<String> tmpList = new ArrayList();
		tmpList.clear();
		//
		if(isWeapon && weapons.size() != 0) {
			ListIterator<Equipment> tmpIterator = weapons.listIterator();
			while(tmpIterator.hasNext()) {
				Equipment equip = tmpIterator.next();
				tmpList.add(equip.getKey());
			}
		} else if (!isWeapon && equipment.size() != 0) {
			ListIterator<Equipment> tmpIterator = equipment.listIterator();
			while(tmpIterator.hasNext()) {
				Equipment equip = tmpIterator.next();
				tmpList.add(equip.getKey());
			}
		}
		return tmpList;
	}

	public String getEquipmentKey() {
		return armor.getKey();
	}

	public int getStatSavingThrow(String stat, int val){
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

	public void print() {
		System.out.println("We made a damn XML, check it out!");
	}
}
