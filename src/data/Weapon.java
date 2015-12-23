package data;

import java.util.ArrayList;

class Weapon extends Equipment {
	String weaponName, weaponDamage, weaponPrice, weaponWeight, weaponGroup;
	ArrayList<String> weaponProperties, weaponModifiers;
	//
	Weapon(String weaponName, String weaponDamage, String weaponWeight, String weaponPrice, ArrayList weaponProperties, String weaponGroup, ArrayList weaponModifiers) {
		this.weaponName = weaponName;
		this.weaponDamage = weaponDamage;
		this.weaponWeight = weaponWeight;
		this.weaponPrice = weaponPrice;
		this.weaponGroup = weaponGroup;
		this.weaponProperties = weaponProperties;
		this.weaponModifiers = weaponModifiers;
	}
	
	void print() {
		System.out.println("Weapon:\t\t" + weaponName + "\nDamage:\t\t" + weaponDamage + "\nWeight:\t\t" + weaponWeight + "\nPrice:\t\t" + weaponPrice + "\nGroup:\t\t" + weaponGroup+ "\nProperties:\t" + weaponProperties + "\nModifiers:\t" + weaponModifiers);
		System.out.println("\n------------------------------------\n");
	}

	public String getKey() {
		return weaponName;
	}
}
