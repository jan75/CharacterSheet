package data;

import race.*;

import race.DNDCharacter;

public class Skills {

	boolean acrobatics;
	boolean animalHandling;
	boolean arcana;
	boolean atheltics;
	boolean deception;
	boolean history;
	boolean insight;
	boolean intimidation;
	boolean investigation;
	boolean medicine;
	boolean nature;
	boolean perception;
	boolean performance;
	boolean persuasion;
	boolean religon;
	boolean sleightOfHand;
	boolean stealth;
	boolean survival;

	public Skills() {

	}

	public boolean isAcrobatics() {
		return acrobatics;
	}

	public void setAcrobatics(boolean acrobatics) {
		this.acrobatics = acrobatics;
	}

	public int getAcrobatics(DNDCharacter DNDCharacter) {
		return acrobatics? DNDCharacter.getStatBonus(DNDCharacter.dexterity)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.dexterity);
	}

	public boolean isAnimalHandling() {
		return animalHandling;
	}

	public void setAnimalHandling(boolean animalHandling) {
		this.animalHandling = animalHandling;
	}

	public int getAnimalHandling(DNDCharacter DNDCharacter) {
		return animalHandling? DNDCharacter.getStatBonus(DNDCharacter.wisdom)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.wisdom);
	}

	public boolean isArcana() {
		return arcana;
	}

	public void setArcana(boolean arcana) {
		this.arcana = arcana;
	}

	public int getArcana(DNDCharacter DNDCharacter) {
		return arcana? DNDCharacter.getStatBonus(DNDCharacter.intelligence)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.intelligence);
	}

	public boolean isAtheltics() {
		return atheltics;
	}

	public void setAtheltics(boolean atheltics) {
		this.atheltics = atheltics;
	}

	public int getAthletics(DNDCharacter DNDCharacter) {
		return atheltics? DNDCharacter.getStatBonus(DNDCharacter.strength)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.strength);
	}

	public boolean isDeception() {
		return deception;
	}

	public void setDeception(boolean deception) {
		this.deception = deception;
	}

	public int getDeception(DNDCharacter DNDCharacter) {
		return deception? DNDCharacter.getStatBonus(DNDCharacter.charisma)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.charisma);
	}

	public boolean isHistory() {
		return history;
	}

	public void setHistory(boolean history) {
		this.history = history;
	}

	public int getHistory(DNDCharacter DNDCharacter) {
		return history? DNDCharacter.getStatBonus(DNDCharacter.intelligence)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.intelligence);
	}

	public boolean isInsight() {
		return insight;
	}

	public void setInsight(boolean insight) {
		this.insight = insight;
	}

	public int getInsight(DNDCharacter DNDCharacter) {
		return insight? DNDCharacter.getStatBonus(DNDCharacter.wisdom)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.wisdom);
	}

	public boolean isIntimidation() {
		return intimidation;
	}

	public void setIntimidation(boolean intimidation) {
		this.intimidation = intimidation;
	}

	public int getIntimidation(DNDCharacter DNDCharacter) {
		return intimidation? DNDCharacter.getStatBonus(DNDCharacter.charisma)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.charisma);
	}

	public boolean isInvestigation() {
		return investigation;
	}

	public void setInvestigation(boolean investigation) {
		this.investigation = investigation;
	}

	public int getInvestigation(DNDCharacter DNDCharacter) {
		return intimidation? DNDCharacter.getStatBonus(DNDCharacter.intelligence)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.intelligence);
	}

	public boolean isMedicine() {
		return medicine;
	}

	public void setMedicine(boolean medicine) {
		this.medicine = medicine;
	}

	public int getMedicine(DNDCharacter DNDCharacter) {
		return intimidation? DNDCharacter.getStatBonus(DNDCharacter.wisdom)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.wisdom);
	}

	public boolean isNature() {
		return nature;
	}

	public void setNature(boolean nature) {
		this.nature = nature;
	}

	public int getNature(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.intelligence)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.intelligence);
	}

	public boolean isPerception() {
		return perception;
	}

	public void setPerception(boolean perception) {
		this.perception = perception;
	}

	public int getPerception(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.wisdom)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.wisdom);
	}

	public boolean isPerformance() {
		return performance;
	}

	public void setPerformance(boolean performance) {
		this.performance = performance;
	}

	public int getPerformance(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.charisma)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.charisma);
	}

	public boolean isPersuasion() {
		return persuasion;
	}

	public void setPersuasion(boolean persuasion) {
		this.persuasion = persuasion;
	}

	public int getPersuasion(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.charisma)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.charisma);
	}

	public boolean isReligon() {
		return religon;
	}

	public void setReligon(boolean religon) {
		this.religon = religon;
	}

	public int getReligion(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.intelligence)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.intelligence);
	}

	public boolean isSleightOfHand() {
		return sleightOfHand;
	}

	public void setSleightOfHand(boolean sleightOfHand) {
		this.sleightOfHand = sleightOfHand;
	}

	public int getSleightOfHand(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.dexterity)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.dexterity);
	}

	public boolean isStealth() {
		return stealth;
	}

	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}

	public int getStealth(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.dexterity)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.dexterity);
	}

	public boolean isSurvival() {
		return survival;
	}

	public void setSurvival(boolean survival) {
		this.survival = survival;
	}

	public int getSurvival(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.wisdom)+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.wisdom);
	}
}