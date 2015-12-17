package equipment;

class Weapon extends Equipment {
	String weaponName, weaponWeight, weaponPrice, weaponGroup, weaponDamage;
	// also available: weaponProperty, weaponModifier
	//
	Weapon(String weaponName, String weaponDamage, String weaponWeight, String weaponPrice, String weaponGroup) {
		this.weaponName = weaponName;
		this.weaponDamage = weaponDamage;
		this.weaponWeight = weaponWeight;
		this.weaponPrice = weaponPrice;
		this.weaponGroup = weaponGroup;
	}
	
	void print() {
		System.out.println("Weapon:\t\t" + weaponName + "\nDamage:\t\t" + weaponDamage + "\nWeight:\t\t" + weaponWeight + "\nPrice:\t\t" + weaponPrice + "\nGroup:\t\t" + weaponGroup);
		System.out.println("\n------------------------------------\n");
	}
}
