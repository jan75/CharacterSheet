package data;

import race.*;

import race.DNDCharacter;

public class Skills {

	boolean acrobatics;
	boolean animalHandling;
	boolean arcana;
	boolean athletics;
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
	boolean religion;
	boolean sleightOfHand;
	boolean stealth;
	boolean survival;
	
	boolean strength;
	boolean dexterity;
	boolean constitution;
	boolean intelligence;
	boolean wisdom;
	boolean charisma;

	public Skills() {

	}

	public boolean isAcrobatics() {
		return acrobatics;
	}

	public void setAcrobatics(boolean acrobatics) {
		this.acrobatics = acrobatics;
	}

	public int getAcrobatics(DNDCharacter DNDCharacter) {
		return acrobatics? DNDCharacter.getStatBonus(DNDCharacter.getDexterity())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getDexterity());
	}

	public boolean isAnimalHandling() {
		return animalHandling;
	}

	public void setAnimalHandling(boolean animalHandling) {
		this.animalHandling = animalHandling;
	}

	public int getAnimalHandling(DNDCharacter DNDCharacter) {
		return animalHandling? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}

	public boolean isArcana() {
		return arcana;
	}

	public void setArcana(boolean arcana) {
		this.arcana = arcana;
	}

	public int getArcana(DNDCharacter DNDCharacter) {
		return arcana? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}

	public boolean isAthletics() {
		return athletics;
	}

	public void setAthletics(boolean athletics) {
		this.athletics = athletics;
	}

	public int getAthletics(DNDCharacter DNDCharacter) {
		return athletics? DNDCharacter.getStatBonus(DNDCharacter.getStrength())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getStrength());
	}

	public boolean isDeception() {
		return deception;
	}

	public void setDeception(boolean deception) {
		this.deception = deception;
	}

	public int getDeception(DNDCharacter DNDCharacter) {
		return deception? DNDCharacter.getStatBonus(DNDCharacter.getCharisma())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getCharisma());
	}

	public boolean isHistory() {
		return history;
	}

	public void setHistory(boolean history) {
		this.history = history;
	}

	public int getHistory(DNDCharacter DNDCharacter) {
		return history? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}

	public boolean isInsight() {
		return insight;
	}

	public void setInsight(boolean insight) {
		this.insight = insight;
	}

	public int getInsight(DNDCharacter DNDCharacter) {
		return insight? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}

	public boolean isIntimidation() {
		return intimidation;
	}

	public void setIntimidation(boolean intimidation) {
		this.intimidation = intimidation;
	}

	public int getIntimidation(DNDCharacter DNDCharacter) {
		return intimidation? DNDCharacter.getStatBonus(DNDCharacter.getCharisma())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getCharisma());
	}

	public boolean isInvestigation() {
		return investigation;
	}

	public void setInvestigation(boolean investigation) {
		this.investigation = investigation;
	}

	public int getInvestigation(DNDCharacter DNDCharacter) {
		return investigation? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}

	public boolean isMedicine() {
		return medicine;
	}

	public void setMedicine(boolean medicine) {
		this.medicine = medicine;
	}

	public int getMedicine(DNDCharacter DNDCharacter) {
		return medicine? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}

	public boolean isNature() {
		return nature;
	}

	public void setNature(boolean nature) {
		this.nature = nature;
	}

	public int getNature(DNDCharacter DNDCharacter) {
		return nature? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}

	public boolean isPerception() {
		return perception;
	}

	public void setPerception(boolean perception) {
		this.perception = perception;
	}

	public int getPerception(DNDCharacter DNDCharacter) {
		return perception? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}

	public boolean isPerformance() {
		return performance;
	}

	public void setPerformance(boolean performance) {
		this.performance = performance;
	}

	public int getPerformance(DNDCharacter DNDCharacter) {
		return performance? DNDCharacter.getStatBonus(DNDCharacter.getCharisma())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getCharisma());
	}

	public boolean isPersuasion() {
		return persuasion;
	}

	public void setPersuasion(boolean persuasion) {
		this.persuasion = persuasion;
	}

	public int getPersuasion(DNDCharacter DNDCharacter) {
		return persuasion? DNDCharacter.getStatBonus(DNDCharacter.getCharisma())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getCharisma());
	}

	public boolean isReligion() {
		return religion;
	}

	public void setReligion(boolean religion) {
		this.religion = religion;
	}

	public int getReligion(DNDCharacter DNDCharacter) {
		return religion? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}

	public boolean isSleightOfHand() {
		return sleightOfHand;
	}

	public void setSleightOfHand(boolean sleightOfHand) {
		this.sleightOfHand = sleightOfHand;
	}

	public int getSleightOfHand(DNDCharacter DNDCharacter) {
		return sleightOfHand? DNDCharacter.getStatBonus(DNDCharacter.getDexterity())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getDexterity());
	}

	public boolean isStealth() {
		return stealth;
	}

	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}

	public int getStealth(DNDCharacter DNDCharacter) {
		return stealth? DNDCharacter.getStatBonus(DNDCharacter.getDexterity())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getDexterity());
	}

	public boolean isSurvival() {
		return survival;
	}

	public void setSurvival(boolean survival) {
		this.survival = survival;
	}

	public int getSurvival(DNDCharacter DNDCharacter) {
		return survival? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}

	public boolean isStrength() {
		return strength;
	}

	public void setStrength(boolean strength) {
		this.strength = strength;
	}

	public int getStrength(DNDCharacter DNDCharacter) {
		return strength? DNDCharacter.getStatBonus(DNDCharacter.getStrength())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getStrength());
	}
	
	public boolean isDexterity() {
		return dexterity;
	}

	public void setDexterity(boolean dexterity) {
		this.dexterity = dexterity;
	}

	public int getDexterity(DNDCharacter DNDCharacter) {
		return dexterity? DNDCharacter.getStatBonus(DNDCharacter.getDexterity())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getDexterity());
	}
	
	public boolean isConstitution() {
		return constitution;
	}

	public void setConstitution(boolean constitution) {
		this.constitution = constitution;
	}

	public int getConstitution(DNDCharacter DNDCharacter) {
		return constitution? DNDCharacter.getStatBonus(DNDCharacter.getConstitution())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getConstitution());
	}
	
	public boolean isIntelligence() {
		return intelligence;
	}

	public void setIntelligence(boolean intelligence) {
		this.intelligence = intelligence;
	}

	public int getIntelligence(DNDCharacter DNDCharacter) {
		return intelligence? DNDCharacter.getStatBonus(DNDCharacter.getIntelligence())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getIntelligence());
	}
	
	public boolean isWisdom() {
		return wisdom;
	}

	public void setWisdom(boolean wisdom) {
		this.wisdom = wisdom;
	}

	public int getWisdom(DNDCharacter DNDCharacter) {
		return wisdom? DNDCharacter.getStatBonus(DNDCharacter.getWisdom())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getWisdom());
	}
	
	public boolean isCharisma() {
		return charisma;
	}

	public void setCharisma(boolean constitution) {
		this.charisma = constitution;
	}

	public int getCharisma(DNDCharacter DNDCharacter) {
		return charisma? DNDCharacter.getStatBonus(DNDCharacter.getCharisma())+ DNDCharacter.proficencybonus: DNDCharacter.getStatBonus(DNDCharacter.getCharisma());
	}
}