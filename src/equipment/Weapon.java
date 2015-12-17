package equipment;

class Weapon extends Equipment {
	String weaponName, weaponWeight, weaponPrice, weaponProperty, weaponGroup, weaponModifier;
	
	Weapon(String weaponName, String weaponWeight, String weaponPrice, String weaponProperty, String weaponGroup, String weaponModifier) {
		this.weaponName = weaponName;
		this.weaponWeight = weaponWeight;
		this.weaponPrice = weaponPrice;
		this.weaponProperty = weaponProperty;
		this.weaponGroup = weaponGroup;
		this.weaponModifier = weaponModifier;
	}
	
	void print() {
		System.out.println("Weapons:\n Name: " + weaponName + "\nPrice " + weaponPrice);
	}
}
