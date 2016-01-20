package race;

import characterClass.CharacterClass;
import data.Equipment;
import data.Money;
import data.Skills;
import data.Spell;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DNDCharacter {
	private final static Logger LOGGER = Logger.getLogger("charSheetLogger");

	private String name;
	private Race race;
	private CharacterClass characterClass;
	private int strength;
	private int dexterity;
	private int charisma;
	private int intelligence;
	private int wisdom;
	private int constitution;
	private int level;
	private List<Equipment> weapons;
	private List<Spell> spells;
	//private Equipment armor; Armor has been removed
	private List<String> proficiencies;
	private Skills skills;
	private List<String> items;
	private String background;
	private String playerName;
	private String faction;
	private String alignment;
	private int experiencePoints;
	private List<String> personalityTraits;
	private List<String> ideals;
	private List<String> bonds;
	private List<String> flaws;
	private List<String> featuresTraits;
	private int armorClass;
	private Money money;
	private int maxHitPoints;
	private int hitPoints;
	private int tmpHitPoints;
	public int proficencybonus;
	private int hitDie;
	


	public DNDCharacter(String name, Race race, CharacterClass characterClass, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, List<Equipment> weapons, List<Spell> spells, List<String> proficiencies, Skills skills, List<String> items, String background, String playerName, String faction, String alignment, int experiencePoints, List<String> personalityTraits, List<String> ideals, List<String> bonds, List<String> flaws, List<String> featuresTraits, Money money, int maxHitPoints, int hitPoints, int tmpHitPoints, int hitDie, int armorClass) {
		this.name = name;
		this.race = race;
		this.characterClass = characterClass;
		this.strength = strength;
		this.dexterity = dexterity;
		this.constitution = constitution;
		this.intelligence = intelligence;
		this.wisdom = wisdom;
		this.charisma = charisma;
		this.weapons = weapons;
		this.spells = spells;
		//this.armor = armor; Armor has been removed
		this.proficiencies = proficiencies;
		this.skills = skills;
		this.items = items;
		this.background  = background;
		this.playerName = playerName;
		this.faction = faction;
		this.alignment = alignment;
		this.experiencePoints = experiencePoints;
		this.personalityTraits = personalityTraits;
		this.ideals = ideals;
		this.bonds = bonds;
		this.flaws = flaws;
		this.featuresTraits = featuresTraits;
		this.money=money;
		this.maxHitPoints=maxHitPoints;
		this.hitPoints=hitPoints;
		this.tmpHitPoints=tmpHitPoints;
		this.hitDie=hitDie;
		this.armorClass=armorClass;
		
	}

	public int getStatBonus(int stat){
		return Math.floorDiv(stat, 2) -5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		LOGGER.log(Level.INFO, "Name has been set to " + name);
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

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public String getRaceName() {
		return race.getName();
	}

	public void setRace(String race) {
		this.race = Race.createRace(race);
	}

	public String getCharClassName() {
		return characterClass.getName();
	}
	
	public CharacterClass getCharacterClass(){
		return characterClass;
	}

	public void setClass(String charClass) {
		this.characterClass = CharacterClass.createCharClass(charClass);
	}

	public String getBackground() {
		return background;
	}

	public void setBackground(String background) {
		this.background = background;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getFaction() {
		return faction;
	}

	public void setFaction(String faction) {
		this.faction = faction;
	}

	public String getAlignment() {
		return alignment;
	}

	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}

	public Skills getSkills() {
		return skills;
	}
	
	public String getSpeed(){
		return Integer.toString(race.speed);
	}

	public List<Equipment> getWeapons() {
		return weapons;
	}

	public ArrayList<String> getLists(String listToReturn) {
		ArrayList<String> tmpList = new ArrayList<String>();
		tmpList.clear();
		switch (listToReturn) {
			case "proficiencies": tmpList.addAll(proficiencies);
				break;
			case "personalityTraits": tmpList.addAll(personalityTraits);
				break;
			case "equipment": tmpList.addAll(items);
				break;
			case "ideals": tmpList.addAll(ideals);
				break;
			case "bonds": tmpList.addAll(bonds);
				break;
			case "flaws": tmpList.addAll(flaws);
				break;
			case "featuresTraits": tmpList.addAll(featuresTraits);
				break;
			default:
				LOGGER.log(Level.SEVERE, "No lists to return found, wrong parameter?");
				break;
		}
		return tmpList;
	}

	public void setLists(String listToStore, List<CharSequence> list) {
		LOGGER.log(Level.INFO, "Method setLists called with parameter " + listToStore);
		ArrayList<String> tmpList = new ArrayList<String>();
		tmpList.clear();
		//
		String tmpString;
		//
		for(Object currentListItem: list) {
			if(currentListItem instanceof CharSequence) {
				tmpString = currentListItem.toString();
				if(tmpString.length() >= 3) {
					tmpList.add(tmpString);
				} else {
					LOGGER.log(Level.INFO, "Input too short");
				}
			}
		}
		//
		switch (listToStore) {
			case "proficiencies":
				proficiencies.clear();
				proficiencies.addAll(tmpList);
				break;
			case "personalityTraits":
				personalityTraits.clear();
				personalityTraits.addAll(tmpList);
				break;
			case "equipment": // equipment represents items
				items.clear();
				items.addAll(tmpList);
				break;
			case "ideals":
				ideals.clear();
				ideals.addAll(tmpList);
				break;
			case "bonds":
				bonds.clear();
				bonds.addAll(tmpList);
				break;
			case "flaws":
				flaws.clear();
				flaws.addAll(tmpList);
				break;
			case "featuresTraits":
				featuresTraits.clear();
				featuresTraits.addAll(tmpList);
				break;
			default:
				LOGGER.log(Level.SEVERE, "No lists to return found, wrong parameter?");
				break;
		}
	}

	public ArrayList<String> getSpellKeysList() {
		ArrayList<String> tmpList = new ArrayList<String>();
		tmpList.clear();
		ListIterator<Spell> tmpIterator = spells.listIterator();
		while(tmpIterator.hasNext()) {
			Spell spell = tmpIterator.next();
			tmpList.add(spell.getKey());
		}
		return tmpList;
	}

	public void addSpell(Spell spell) {
		this.spells.add(spell);
	}

	public void setSpells(List<Spell> spells) {
		this.spells = spells;
	}

	public ArrayList<String> getItemKeysList(boolean isWeapon) {
		ArrayList<String> tmpList = new ArrayList<String>();
		tmpList.clear();
		//
		if(isWeapon && weapons.size() != 0) {
			ListIterator<Equipment> tmpIterator = weapons.listIterator();
			while(tmpIterator.hasNext()) {
				Equipment equip = tmpIterator.next();
				tmpList.add(equip.getName());
				if(!tmpIterator.hasNext()) {
					return tmpList;
				}
			}
		} else if (!isWeapon && items.size() != 0) {
			tmpList.addAll(items);
			return tmpList;
		}
		return tmpList;
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
		LOGGER.log(Level.INFO, "Character '" + name + "' has been generated.");
	}

	public void setLevel(int level) {
		this.level=level;	
	}
	
	public Money getMoney(){
		return this.money;
	}
	
	public void setMoney(Money money){
		this.money=money;
	}

	public void setStrength(int str) {
		this.strength=str;
	}
	public void setDexterity(int dex) {
		this.dexterity=dex;
	}
	public void setConstitution(int con) {
		this.constitution=con;
	}
	public void setIntelligence(int intel) {
		this.intelligence=intel;
	}
	public void setWisdom(int wis) {
		this.wisdom=wis;
	}
	public void setCharisma(int cha) {
		this.charisma=cha;
	}
	
	public int getArmorClass(){
		return armorClass;
	}
	
	public void setArmorClass(int armorClass){
		this.armorClass=armorClass;
	}

	public int getHitDie() {
		return hitDie;
	}

	public void setHitDie(int hitDie) {
		this.hitDie = hitDie;
	}

	public int getTmpHitPoints() {
		return tmpHitPoints;
	}

	public void setTmpHitPoints(int tmpHitPoints) {
		this.tmpHitPoints = tmpHitPoints;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getMaxHitPoints() {
		return maxHitPoints;
	}

	public void setMaxHitPoints(int maxHitPoints) {
		this.maxHitPoints = maxHitPoints;
	}
}
