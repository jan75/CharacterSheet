package data;

import org.w3c.dom.*;
import race.DNDCharacter;

import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ParserOperationsXML {
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

	/**
	 * The Method "saveCharacterToXML" generates a file(XML) and fills it with the object player. This XML file can be parsed with the method "loadCharacterFromXML"
	 * @param tmpCharacter
	 */
	public static void saveCharacterToXML(DNDCharacter tmpCharacter) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//
			Document document = dBuilder.newDocument();
			Element rootElement = document.createElement("character");
			document.appendChild(rootElement);
			//
			Element character = document.createElement("dndcharacter");
			rootElement.appendChild(character);
			//
			character.setAttribute("name", tmpCharacter.getName());
			//
			// ::::: BEGINNING OF LEVEL BLOCK :::::
			Element level = document.createElement("level");
			Element charLevel = document.createElement("charLevel");
			level.appendChild(charLevel);
			charLevel.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getLevel())));
			//
			character.appendChild(level);
			//
			// ::::: BEGINNING OF STATS BLOCK :::::
			Element stats = document.createElement("stats");
			//
			Element strength = document.createElement("strength");
			Element dexterity = document.createElement("dexterity");
			Element constitution = document.createElement("constitution");
			Element intelligence = document.createElement("intelligence");
			Element wisdom = document.createElement("wisdom");
			Element charisma = document.createElement("charisma");
			stats.appendChild(strength);
			stats.appendChild(dexterity);
			stats.appendChild(constitution);
			stats.appendChild(intelligence);
			stats.appendChild(wisdom);
			stats.appendChild(charisma);
			strength.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getStrength())));
			dexterity.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getDexterity())));
			constitution.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getConstitution())));
			intelligence.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getIntelligence())));
			wisdom.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getWisdom())));
			charisma.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getCharisma())));
			//
			character.appendChild(stats);
			//
			// ::::: BEGINNING OF SPELLS BLOCK :::::
			Element spells = document.createElement("spells");
			//
			ArrayList<String> tmpSpells = tmpCharacter.getSpellKeysList();
			for(int i = 0; i < tmpSpells.size(); i++) {
				Element spell = document.createElement("spell");
				spells.appendChild(spell);
				spell.appendChild(document.createTextNode(tmpSpells.get(i)));
			}
			character.appendChild(spells);
			//
			// ::::: BEGINNING OF WEAPONS BLOCK :::::
			ArrayList<String> tmpWeapons = tmpCharacter.getEquipmentKeysList(true);
			//
			if(tmpWeapons.size() != 0) {
				Element weapons = document.createElement("weapons");
				//
				for (int i = 0; i < tmpWeapons.size(); i++) {
					Element weapon = document.createElement("weapon");
					weapons.appendChild(weapon);
					weapon.appendChild(document.createTextNode(tmpWeapons.get(i)));
				}
				character.appendChild(weapons);
			}
			//
			// ::::: BEGINNING OF EQUIPMENT BLOCK :::::
			ArrayList<String> tmpEquipment = tmpCharacter.getEquipmentKeysList(false);
			//
			if(tmpEquipment.size() != 0) {
				Element equipment = document.createElement("equipment");
				//

				for (int i = 0; i < tmpEquipment.size(); i++) {
					Element item = document.createElement("item");
					equipment.appendChild(item);
					item.appendChild(document.createTextNode(tmpEquipment.get(i)));
				}
				character.appendChild(equipment);
			}
			//
			// ::::: BEGINNING OF ARMOR BLOCK :::::
			if(!tmpCharacter.getEquipmentKey().isEmpty()) {
				Element armor = document.createElement("armor");
				Element armorItem = document.createElement("armorItem");
				armor.appendChild(armorItem);
				armorItem.appendChild(document.createTextNode(tmpCharacter.getEquipmentKey()));
				//
				character.appendChild(armor);
			}
			//
			// ::::: BEGINNING OF RACE BLOCK :::::
			Element race = document.createElement("race");
			Element raceName = document.createElement("raceName");
			race.appendChild(raceName);
			raceName.appendChild(document.createTextNode(tmpCharacter.getRaceName()));
			//
			character.appendChild(race);
			//
			// ::::: BEGINNING OF CLASS BLOCK :::::
			Element charClass = document.createElement("charClass");
			Element charClassName = document.createElement("charClassName");
			charClass.appendChild(charClassName);
			charClassName.appendChild(document.createTextNode(tmpCharacter.getRaceName()));
			//
			character.appendChild(charClass);
			//
			// ::::: BEGINNING OF PROFICIENCIES BLOCK :::::
			ArrayList<String> tmpProficiencies = tmpCharacter.getProficiencies();
			//
			if(tmpProficiencies.size() != 0) {
				Element proficiencies = document.createElement("proficiencies");
				//
				for (int i = 0; i < tmpProficiencies.size(); i++) {
					Element proficiency = document.createElement("proficiency");
					proficiencies.appendChild(proficiency);
					proficiency.appendChild(document.createTextNode(tmpProficiencies.get(i)));
				}
				//
				character.appendChild(proficiencies);
			}
			//
			//
			//
			//
			//
			//
			// ::::: BEGINNING OF FINISHING BLOCK :::::
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("src/files/" + tmpCharacter.getName() + ".xml"));
			//StreamResult result = new StreamResult(System.out);
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			//
			transformer.transform(source, result);
			//
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
