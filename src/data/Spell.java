package data;

import java.util.ArrayList;

public class Spell {
	String spellName, spellSchool, spellRitual, spellLevel, spellPage;
	ArrayList<String> spellClasses;
	//
	Spell(String spellName, String spellLevel, String spellSchool, String spellRitual, String spellPage, ArrayList spellClasses) {
		this.spellName = spellName;
		this.spellLevel = spellLevel;
		this.spellSchool = spellSchool;
		this.spellRitual = spellRitual;
		this.spellPage = spellPage;
		this.spellClasses = spellClasses;
	}
	
	void print() {
		System.out.println("Spell:\t\t" + spellName + "\nLevel:\t\t" + spellLevel + "\nSchool:\t\t" + spellSchool + "\nRitual:\t\t" + spellRitual + "\nPage:\t\t" + spellPage + "\nClasses:\t" + spellClasses);
		System.out.println("\n------------------------------------\n");
	}

	public String getKey() {
		return spellName;
	}
}
