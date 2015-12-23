public class Skills {
	public boolean isAcrobatics() {
		return acrobatics;
	}
	public int getAcrobatics(Character character) {
		return acrobatics?character.getStatBonus(character.dexterity)+character.proficencybonus:character.getStatBonus(character.dexterity);
	}
	public void setAcrobatics(boolean acrobatics) {
		this.acrobatics = acrobatics;
	}
	public boolean isAnimalHandling() {
		return animalHandling;
	}
	public int getAnimalHandling(Character character) {
		return animalHandling?character.getStatBonus(character.wisdom)+character.proficencybonus:character.getStatBonus(character.wisdom);
	}
	public void setAnimalHandling(boolean animalHandling) {
		this.animalHandling = animalHandling;
	}
	public boolean isArcana() {
		return arcana;
	}
	public int getArcana(Character character) {
		return arcana?character.getStatBonus(character.intelligence)+character.proficencybonus:character.getStatBonus(character.intelligence);
	}
	public void setArcana(boolean arcana) {
		this.arcana = arcana;
	}
	public boolean isAtheltics() {
		return atheltics;
	}
	public int getAthletics(Character character) {
		return atheltics?character.getStatBonus(character.strength)+character.proficencybonus:character.getStatBonus(character.strength);
	}
	public void setAtheltics(boolean atheltics) {
		this.atheltics = atheltics;
	}
	public boolean isDeception() {
		return deception;
	}
	public int getDeception(Character character) {
		return deception?character.getStatBonus(character.charisma)+character.proficencybonus:character.getStatBonus(character.charisma);
	}
	public void setDeception(boolean deception) {
		this.deception = deception;
	}
	public boolean isHistory() {
		return history;
	}
	public int getHistory(Character character) {
		return history?character.getStatBonus(character.intelligence)+character.proficencybonus:character.getStatBonus(character.intelligence);
	}
	public void setHistory(boolean history) {
		this.history = history;
	}
	public boolean isInsight() {
		return insight;
	}
	public int getInsight(Character character) {
		return insight?character.getStatBonus(character.wisdom)+character.proficencybonus:character.getStatBonus(character.wisdom);
	}
	public void setInsight(boolean insight) {
		this.insight = insight;
	}
	public boolean isIntimidation() {
		return intimidation;
	}
	public int getIntimidation(Character character) {
		return intimidation?character.getStatBonus(character.charisma)+character.proficencybonus:character.getStatBonus(character.charisma);
	}
	public void setIntimidation(boolean intimidation) {
		this.intimidation = intimidation;
	}
	public boolean isInvestigation() {
		return investigation;
	}
	public int getInvestigation(Character character) {
		return intimidation?character.getStatBonus(character.intelligence)+character.proficencybonus:character.getStatBonus(character.intelligence);
	}
	public void setInvestigation(boolean investigation) {
		this.investigation = investigation;
	}
	public boolean isMedicine() {
		return medicine;
	}	
	public int getMedicine(Character character) {
		return intimidation?character.getStatBonus(character.wisdom)+character.proficencybonus:character.getStatBonus(character.wisdom);
	}
	public void setMedicine(boolean medicine) {
		this.medicine = medicine;
	}
	public boolean isNature() {
		return nature;
	}
	public int getNature(Character character) {
		return nature?character.getStatBonus(character.intelligence)+character.proficencybonus:character.getStatBonus(character.intelligence);
	}
	public void setNature(boolean nature) {
		this.nature = nature;
	}
	public boolean isPerception() {
		return perception;
	}
	public int getPerception(Character character) {
		return nature?character.getStatBonus(character.wisdom)+character.proficencybonus:character.getStatBonus(character.wisdom);
	}
	public void setPerception(boolean perception) {
		this.perception = perception;
	}
	public boolean isPerformance() {
		return performance;
	}
	public int getPerformance(Character character) {
		return nature?character.getStatBonus(character.charisma)+character.proficencybonus:character.getStatBonus(character.charisma);
	}
	public void setPerformance(boolean performance) {
		this.performance = performance;
	}
	public boolean isPersuasion() {
		return persuasion;
	}
	public int getPersuasion(Character character) {
		return nature?character.getStatBonus(character.charisma)+character.proficencybonus:character.getStatBonus(character.charisma);
	}
	public void setPersuasion(boolean persuasion) {
		this.persuasion = persuasion;
	}
	public boolean isReligon() {
		return religon;
	}
	public int getReligion(Character character) {
		return nature?character.getStatBonus(character.intelligence)+character.proficencybonus:character.getStatBonus(character.intelligence);
	}
	public void setReligon(boolean religon) {
		this.religon = religon;
	}
	public boolean isSleightOfHand() {
		return sleightOfHand;
	}
	public int getSleightOfHand(Character character) {
		return nature?character.getStatBonus(character.dexterity)+character.proficencybonus:character.getStatBonus(character.dexterity);
	}
	public void setSleightOfHand(boolean sleightOfHand) {
		this.sleightOfHand = sleightOfHand;
	}
	
	public boolean isStealth() {
		return stealth;
	}
	public int getStealth(Character character) {
		return nature?character.getStatBonus(character.dexterity)+character.proficencybonus:character.getStatBonus(character.dexterity);
	}
	public void setStealth(boolean stealth) {
		this.stealth = stealth;
	}
	public boolean isSurvival() {
		return survival;
	}
	public int getSurvival(Character character) {
		return nature?character.getStatBonus(character.wisdom)+character.proficencybonus:character.getStatBonus(character.wisdom);
	}
	public void setSurvival(boolean survival) {
		this.survival = survival;
	}
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
}