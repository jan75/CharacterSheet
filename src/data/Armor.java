package data;

public class Armor extends Equipment {
	String armorName, armorPrice, armorModifier, armorSpeed, armorStealth, armorWeight,armorClass;
	// also available: weaponProperty, weaponModifier
	//
	Armor(String armorName, String armorPrice, String armorModifier, String armorSpeed, String armorStealth, String armorWeight, String armorClass) {
		this.armorName = armorName;
		this.armorPrice = armorPrice;
		this.armorModifier = armorModifier;
		this.armorSpeed = armorSpeed;
		this.armorStealth = armorStealth;
		this.armorWeight = armorWeight;
		this.armorClass = armorClass;
	}
	
	void print() {
		System.out.println("Armor:\t\t" + armorName + "\nPrice:\t\t" + armorPrice + "\nWeight:\t\t" + armorWeight + "\nModifier:\t" + armorModifier + "\nSpeed:\t\t" + armorSpeed + "\nStealth:\t" + armorStealth + "\nClass:\t\t" + armorClass);
		System.out.println("\n------------------------------------\n");
	}

	public String getName() {
		return armorName;
	}
}
