package equipment;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ParserOperationsXML {
	
    public static void main(String[] args) {        
        Map<String, Equipment> weaponMap = parseWeapons("src/data/weapons.xml");
		Map<String, Armor> armorMap = parseArmor("src/data/armour.xml");
		Map<String, Spell> spellMap = parseSpells("src/data/spells.xml");
		//
		Equipment testWeapon = weaponMap.get("Crossbow, Light");
		Equipment testArmor = armorMap.get("Leather");
		Equipment testSpell = spellMap.get("Animate Objects");
		testWeapon.print();
		testArmor.print();
		testSpell.print();
    }

	/**
	 * The Method "parseWeapons" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Weapon).
	 * @param path
	 * @return Map
	 */
    public static Map parseWeapons(String path) {
		Map<String, Weapon> weaponMap = new HashMap<>();
		ArrayList<String> arrayWeaponProperties = new ArrayList(); //used for sub node "property" of "properties"
		ArrayList<String> arrayWeaponModifiers = new ArrayList(); //used for sub node "modifier" of "modifiers"
		//
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(path);
			//
			document.getDocumentElement().normalize(); // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//
			//
			NodeList nList = document.getElementsByTagName("name");
			//
			for(int i = 0; i < nList.getLength(); i++) {
				arrayWeaponProperties.clear();
				arrayWeaponModifiers.clear();
				//
				Node nNode = nList.item(i);
				//
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//
					String tmpWeapon = eElement.getAttribute("weaponname");
					String tmpPrice = eElement.getElementsByTagName("price").item(0).getTextContent();
					String tmpDamage = eElement.getElementsByTagName("damage").item(0).getTextContent();
					String tmpWeight = eElement.getElementsByTagName("weight").item(0).getTextContent();
					String tmpGroup = eElement.getElementsByTagName("group").item(0).getTextContent();
					//
					// The following code block parses the sub elements "property" under "properties"
					NodeList nListProperties = eElement.getElementsByTagName("properties");
					Node nNodeProperties = nListProperties.item(0);
					Element eElementProperties = (Element) nNodeProperties;
					//
					NodeList weaponProperties = eElementProperties.getElementsByTagName("property");
					for (int j = 0; j < weaponProperties.getLength(); j++) {
						arrayWeaponProperties.add(weaponProperties.item(j).getTextContent());
					}
					//
					// The following code block parses the sub elements "modifier" under "modifiers"
					NodeList nListModifiers = eElement.getElementsByTagName("modifiers");
					Node nNodeModifiers = nListModifiers.item(0);
					Element eElementModifiers = (Element) nNodeModifiers;
					//
					NodeList weaponModifiers = eElementModifiers.getElementsByTagName("modifier");
					for (int k = 0; k < weaponModifiers.getLength(); k++) {
						arrayWeaponModifiers.add(weaponModifiers.item(k).getTextContent());
					}
					//
					// Creating a Weapon object and adding the weapon to the Map, which will later be returned
					Weapon tmpWeaponObject = new Weapon(tmpWeapon, tmpPrice, tmpDamage, tmpWeight, arrayWeaponProperties, tmpGroup, arrayWeaponModifiers);
					//tmpWeaponObject.print();
					weaponMap.put(tmpWeapon, tmpWeaponObject);
					//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return weaponMap;
	}
	/**
	 * The Method "parseArmor" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Armor).
	 * @param path
	 * @return Map
	 */
	public static Map parseArmor(String path) {
		Map<String, Armor> armorMap = new HashMap<>();
		//
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(path);
			//
			document.getDocumentElement().normalize(); // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//
			//
			NodeList nList = document.getElementsByTagName("name");
			//
			for(int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				//
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//
					String tmpArmor = eElement.getAttribute("armorname");
					String tmpPrice = eElement.getElementsByTagName("price").item(0).getTextContent();
					String tmpModifier = eElement.getElementsByTagName("modifier").item(0).getTextContent();
					String tmpSpeed = eElement.getElementsByTagName("speed").item(0).getTextContent();
					String tmpStealth = eElement.getElementsByTagName("stealth").item(0).getTextContent();
					String tmpWeight = eElement.getElementsByTagName("weight").item(0).getTextContent();
					String tmpClass = eElement.getElementsByTagName("class").item(0).getTextContent();

					Armor tmpArmorObject = new Armor(tmpArmor, tmpPrice, tmpModifier, tmpSpeed, tmpStealth, tmpWeight, tmpClass);
					//tmpArmorObject.print();
					armorMap.put(tmpArmor, tmpArmorObject);
					//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return armorMap;
	}

	/**
	 * The Method "parseSpells" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Spell).
	 * @param path
	 * @return Map
	 */
	public static Map parseSpells(String path) {
		Map<String, Spell> spellMap = new HashMap<>();
		ArrayList<String> arraySpellClasses = new ArrayList(); //used for sub node "property" of "properties"
		//
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(path);
			//
			document.getDocumentElement().normalize(); // http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			//
			//
			NodeList nList = document.getElementsByTagName("name");
			//
			for(int i = 0; i < nList.getLength(); i++) {
				arraySpellClasses.clear();
				String[] allClasses = {"barbarian","bard","cleric","druid","fighter","monk","paladin","ranger","rogue","sorcerer","warlock","wizard"};
				//
				Node nNode = nList.item(i);
				//
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//
					String tmpSpell = eElement.getAttribute("spellname");
					String tmpLevel = eElement.getElementsByTagName("level").item(0).getTextContent();
					String tmpSchool = eElement.getElementsByTagName("school").item(0).getTextContent();
					String tmpRitual = eElement.getElementsByTagName("ritual").item(0).getTextContent();
					String tmpPage = eElement.getElementsByTagName("page").item(0).getTextContent();
					//
					// The following code block parses the sub elements under "classes"
					NodeList nListClasses = eElement.getElementsByTagName("classes");
					Node nNodeClasses = nListClasses.item(0);
					Element eElementClasses = (Element) nNodeClasses;
					//
					 //getTagName());
					for(int j = 0; j < allClasses.length; j++) {
						if (eElementClasses.getElementsByTagName(allClasses[j]).item(0) != null) {
							arraySpellClasses.add(allClasses[j]);
						}
					}
					//
					// Creating a Spell object and adding the Object to the Map, which will later be returned
					Spell tmpSpellObject = new Spell(tmpSpell, tmpLevel, tmpSchool, tmpRitual, tmpPage, arraySpellClasses);
					//tmpSpellObject.print();
					spellMap.put(tmpSpell, tmpSpellObject);
					//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		return spellMap;
	}
}
