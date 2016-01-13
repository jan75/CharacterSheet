package data;

import java.util.ArrayList;

public class Weapon extends Equipment {

	String weaponName, weaponDamage, weaponPrice, weaponWeight, weaponGroup, weaponModifier;
	ArrayList<String> weaponProperties;
	//
	Weapon(String weaponName, String weaponDamage, String weaponPrice, String weaponWeight, ArrayList weaponProperties, String weaponGroup, String weaponModifier) {
		this.weaponName = weaponName;
		this.weaponDamage = weaponDamage;
		this.weaponWeight = weaponWeight;
		this.weaponPrice = weaponPrice;
		this.weaponGroup = weaponGroup;
		this.weaponProperties = weaponProperties;
		this.weaponModifier = weaponModifier;
	}
	
	void print() {
		System.out.println("Weapon:\t\t" + weaponName + "\nDamage:\t\t" + weaponDamage + "\nWeight:\t\t" + weaponWeight + "\nPrice:\t\t" + weaponPrice + "\nGroup:\t\t" + weaponGroup+ "\nProperties:\t" + weaponProperties + "\nModifiers:\t" + weaponModifier);
		System.out.println("\n------------------------------------\n");
	}

	public String getName() {
		return weaponName;
	}

	public String getWeaponDamage() {
		return weaponDamage;
	}

	public String getWeaponModifier() {
		return weaponModifier;
	}

}
