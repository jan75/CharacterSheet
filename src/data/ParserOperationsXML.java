package data;

import characterClass.CharacterClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import race.DNDCharacter;
import race.Race;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ParserOperationsXML {
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
					String tmpModifier = eElement.getElementsByTagName("modifier").item(0).getTextContent();
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
					//
					// Creating a Weapon object and adding the weapon to the Map, which will later be returned
					Weapon tmpWeaponObject = new Weapon(tmpWeapon, tmpDamage, tmpPrice, tmpWeight, arrayWeaponProperties, tmpGroup, tmpModifier);
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
	public static void saveCharacterToXML(DNDCharacter tmpCharacter, String path) {
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
			/* ::::: BEGINNING OF LEVEL BLOCK :::::
			* This is already handled by ExperiencePoints and initialize class
			Element level = document.createElement("level");
			level.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getLevel())));
			character.appendChild(level);
			*/
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
			ArrayList<String> tmpSpells = tmpCharacter.getSpellKeysList();
			//
			if(tmpSpells.size() != 0) {
				Element spells = document.createElement("spells");
				//
				for(int i = 0; i < tmpSpells.size(); i++) {
					Element spell = document.createElement("spell");
					spells.appendChild(spell);
					spell.appendChild(document.createTextNode(tmpSpells.get(i)));
				}
				character.appendChild(spells);
			}
			//
			//
			// ::::: BEGINNING OF WEAPONS BLOCK :::::
			ArrayList<String> tmpWeapons = tmpCharacter.getItemKeysList(true);
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
			// ::::: BEGINNING OF ITEMS BLOCK :::::
			ArrayList<String> tmpItem = tmpCharacter.getItemKeysList(false);
			//
			if(tmpItem.size() != 0) {
				Element equipment = document.createElement("equipment");
				//

				for (int i = 0; i < tmpItem.size(); i++) {
					Element item = document.createElement("item");
					equipment.appendChild(item);
					item.appendChild(document.createTextNode(tmpItem.get(i)));
					//System.out.println("Method: saveCharacterToXML: " + tmpItem.get(i));
				}
				character.appendChild(equipment);
			}
			//
			//
			// ::::: BEGINNING OF PERSONALITYTRAITS BLOCK :::::
			ArrayList<String> tmpPersonalityTraits = tmpCharacter.getLists("personalityTraits");
			//
			if(tmpPersonalityTraits.size() != 0) {
				Element personalityTraits = document.createElement("personalityTraits");
				//
				for (int i = 0; i < tmpPersonalityTraits.size(); i++) {
					Element personalityTrait = document.createElement("personalityTrait");
					personalityTraits.appendChild(personalityTrait);
					personalityTrait.appendChild(document.createTextNode(tmpPersonalityTraits.get(i)));
				}
				//
				character.appendChild(personalityTraits);
			}
			//
			// ::::: BEGINNING OF IDEALS BLOCK :::::
			ArrayList<String> tmpIdeals = tmpCharacter.getLists("ideals");
			//
			if(tmpIdeals.size() != 0) {
				Element ideals = document.createElement("ideals");
				//
				for (int i = 0; i < tmpIdeals.size(); i++) {
					Element ideal = document.createElement("ideal");
					ideals.appendChild(ideal);
					ideal.appendChild(document.createTextNode(tmpIdeals.get(i)));
				}
				//
				character.appendChild(ideals);
			}
			//
			// ::::: BEGINNING OF BONDS BLOCK :::::
			ArrayList<String> tmpBonds = tmpCharacter.getLists("bonds");
			//
			if(tmpBonds.size() != 0) {
				Element bonds = document.createElement("bonds");
				//
				for (int i = 0; i < tmpBonds.size(); i++) {
					Element bond = document.createElement("bond");
					bonds.appendChild(bond);
					bond.appendChild(document.createTextNode(tmpBonds.get(i)));
				}
				//
				character.appendChild(bonds);
			}
			//
			// ::::: BEGINNING OF FLAWS BLOCK :::::
			ArrayList<String> tmpFlaws = tmpCharacter.getLists("flaws");
			//
			if(tmpFlaws.size() != 0) {
				Element flaws = document.createElement("flaws");
				//
				for (int i = 0; i < tmpFlaws.size(); i++) {
					Element flaw = document.createElement("flaw");
					flaws.appendChild(flaw);
					flaw.appendChild(document.createTextNode(tmpFlaws.get(i)));
				}
				//
				character.appendChild(flaws);
			}
			//
			// ::::: BEGINNING OF FEATURESTRAITS BLOCK :::::
			ArrayList<String> tmpFeaturesTraits = tmpCharacter.getLists("featuresTraits");
			//
			if(tmpFeaturesTraits.size() != 0) {
				Element featuresTraits = document.createElement("featuresTraits");
				//
				for (int i = 0; i < tmpFeaturesTraits.size(); i++) {
					Element featureTrait = document.createElement("featureTrait");
					featuresTraits.appendChild(featureTrait);
					featureTrait.appendChild(document.createTextNode(tmpFeaturesTraits.get(i)));
				}
				//
				character.appendChild(featuresTraits);
			}
			//
			//
			/* ::::: BEGINNING OF ARMOR BLOCK :::::
			* armor was removed, but the code has been left in, as it worked previously, but was unfinished
			if(!tmpCharacter.getArmorKey().isEmpty()) {
				Element armor = document.createElement("armor");
				armor.appendChild(document.createTextNode(tmpCharacter.getArmorKey()));
				//
				character.appendChild(armor);
			}
			*/
			//
			// ::::: BEGINNING OF RACE BLOCK :::::
			Element race = document.createElement("race");
			race.appendChild(document.createTextNode(tmpCharacter.getRaceName()));
			character.appendChild(race);
			//
			// ::::: BEGINNING OF CLASS BLOCK :::::
			Element charClass = document.createElement("charClass");
			charClass.appendChild(document.createTextNode(tmpCharacter.getCharClassName()));
			character.appendChild(charClass);
			//
			// ::::: BEGINNING OF BACKGROUND BLOCK :::::
			Element background = document.createElement("background");
			background.appendChild(document.createTextNode(tmpCharacter.getBackground()));
			character.appendChild(background);
			//
			// ::::: BEGINNING OF PLAYERNAME BLOCK :::::
			Element playerName = document.createElement("playerName");
			playerName.appendChild(document.createTextNode(tmpCharacter.getPlayerName()));
			character.appendChild(playerName);
			//
			// ::::: BEGINNING OF FACTION BLOCK :::::
			Element faction = document.createElement("faction");
			faction.appendChild(document.createTextNode(tmpCharacter.getFaction()));
			character.appendChild(faction);
			//
			// ::::: BEGINNING OF ALIGNMENT BLOCK :::::
			Element alignment = document.createElement("alignment");
			alignment.appendChild(document.createTextNode(tmpCharacter.getAlignment()));
			character.appendChild(alignment);
			//
			// ::::: BEGINNING OF EXPERIENCEPOINTS BLOCK :::::
			Element experiencePoints = document.createElement("experiencePoints");
			experiencePoints.appendChild(document.createTextNode(Integer.toString(tmpCharacter.getExperiencePoints())));
			character.appendChild(experiencePoints);


			// ::::: BEGINNING OF PROFICIENCIES BLOCK :::::
			ArrayList<String> tmpProficiencies = tmpCharacter.getLists("proficiencies");
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
			// ::::: BEGINNING OF SKILLS BLOCK :::::
			//
			Element skills = document.createElement("skills");
			//
			Element acrobatics = document.createElement("acrobatics");
			Element animalHandling = document.createElement("animalHandling");
			Element arcana = document.createElement("arcana");
			Element athletics = document.createElement("athletics");
			Element deception = document.createElement("deception");
			Element history = document.createElement("history");
			Element insight = document.createElement("insight");
			Element intimidation = document.createElement("intimidation");
			Element investigation = document.createElement("investigation");
			Element medicine = document.createElement("medicine");
			Element nature = document.createElement("nature");
			Element perception = document.createElement("perception");
			Element performance = document.createElement("performance");
			Element persuasion = document.createElement("persuasion");
			Element religion = document.createElement("religion");
			Element sleightOfHand = document.createElement("sleightOfHand");
			Element stealth = document.createElement("stealth");
			Element survival = document.createElement("survival");
			Element strengthProf = document.createElement("strength");
			Element dexterityProf = document.createElement("dexterity");
			Element constitutionProf = document.createElement("constitution");
			Element intelligenceProf = document.createElement("intelligence");
			Element wisdomProf = document.createElement("wisdom");
			Element charismaProf = document.createElement("charisma");
			
			skills.appendChild(acrobatics);
			skills.appendChild(animalHandling);
			skills.appendChild(arcana);
			skills.appendChild(athletics);
			skills.appendChild(deception);
			skills.appendChild(history);
			skills.appendChild(insight);
			skills.appendChild(intimidation);
			skills.appendChild(investigation);
			skills.appendChild(medicine);
			skills.appendChild(nature);
			skills.appendChild(perception);
			skills.appendChild(performance);
			skills.appendChild(persuasion);
			skills.appendChild(religion);
			skills.appendChild(sleightOfHand);
			skills.appendChild(stealth);
			skills.appendChild(survival);
			skills.appendChild(strengthProf);
			skills.appendChild(dexterityProf);
			skills.appendChild(constitutionProf);
			skills.appendChild(intelligenceProf);
			skills.appendChild(wisdomProf);
			skills.appendChild(charismaProf);
			if(tmpCharacter.getSkills().isAcrobatics()) {
				acrobatics.appendChild(document.createTextNode("true"));
			} else {
				acrobatics.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isAnimalHandling()) {
				animalHandling.appendChild(document.createTextNode("true"));
			} else {
				animalHandling.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isArcana()) {
				arcana.appendChild(document.createTextNode("true"));
			} else {
				arcana.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isAthletics()) {
				athletics.appendChild(document.createTextNode("true"));
			} else {
				athletics.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isDeception()) {
				deception.appendChild(document.createTextNode("true"));
			} else {
				deception.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isHistory()) {
				history.appendChild(document.createTextNode("true"));
			} else {
				history.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isInsight()) {
				insight.appendChild(document.createTextNode("true"));
			} else {
				insight.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isIntimidation()) {
				intimidation.appendChild(document.createTextNode("true"));
			} else {
				intimidation.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isInvestigation()) {
				investigation.appendChild(document.createTextNode("true"));
			} else {
				investigation.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isMedicine()) {
				medicine.appendChild(document.createTextNode("true"));
			} else {
				medicine.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isNature()) {
				nature.appendChild(document.createTextNode("true"));
			} else {
				nature.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isPerception()) {
				perception.appendChild(document.createTextNode("true"));
			} else {
				perception.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isPerformance()) {
				performance.appendChild(document.createTextNode("true"));
			} else {
				performance.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isPersuasion()) {
				persuasion.appendChild(document.createTextNode("true"));
			} else {
				persuasion.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isReligion()) {
				religion.appendChild(document.createTextNode("true"));
			} else {
				religion.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isSleightOfHand()) {
				sleightOfHand.appendChild(document.createTextNode("true"));
			} else {
				sleightOfHand.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isStealth()) {
				stealth.appendChild(document.createTextNode("true"));
			} else {
				stealth.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isSurvival()) {
				survival.appendChild(document.createTextNode("true"));
			} else {
				survival.appendChild(document.createTextNode("false"));
			}
			if(tmpCharacter.getSkills().isStrength()) {
				strengthProf.appendChild(document.createTextNode("true"));
			} else {
				strengthProf.appendChild(document.createTextNode("false"));
			}			
			if(tmpCharacter.getSkills().isDexterity()) {
				dexterityProf.appendChild(document.createTextNode("true"));
			} else {
				dexterityProf.appendChild(document.createTextNode("false"));
			}			
			if(tmpCharacter.getSkills().isConstitution()) {
				constitutionProf.appendChild(document.createTextNode("true"));
			} else {
				constitutionProf.appendChild(document.createTextNode("false"));
			}			
			if(tmpCharacter.getSkills().isIntelligence()) {
				intelligenceProf.appendChild(document.createTextNode("true"));
			} else {
				intelligenceProf.appendChild(document.createTextNode("false"));
			}			
			if(tmpCharacter.getSkills().isWisdom()) {
				wisdomProf.appendChild(document.createTextNode("true"));
			} else {
				wisdomProf.appendChild(document.createTextNode("false"));
			}			
			if(tmpCharacter.getSkills().isCharisma()) {
				charismaProf.appendChild(document.createTextNode("true"));
			} else {
				charismaProf.appendChild(document.createTextNode("false"));
			}
			character.appendChild(skills);
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
			StreamResult result = new StreamResult(new File(path));
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

	/**
	 * The Method "parseSpells" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Spell).
	 * @param path
	 * @return Map
	 */
	public static DNDCharacter loadCharacterFromXML(String path, Map<String, Equipment> weaponMap, Map<String, Spell> spellMap) {
		DNDCharacter tmpCharacter = null;
		//
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document document = dBuilder.parse(path);
			//
			document.getDocumentElement().normalize();
			//
			NodeList nList = document.getElementsByTagName("dndcharacter");
			//
			for (int i = 0; i < nList.getLength(); i++) {
				Node nNode = nList.item(i);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					//
					String tmpName = eElement.getAttribute("name");
					//int tmpLevel = Integer.parseInt(eElement.getElementsByTagName("level").item(0).getTextContent()); this is already handled via "ExperiencePoints" and the initialize class
					Race tmpRace = Race.createRace(eElement.getElementsByTagName("race").item(0).getTextContent());
					CharacterClass tmpCharClass = CharacterClass.createCharClass(eElement.getElementsByTagName("charClass").item(0).getTextContent());
					//Equipment tmpArmor = armorMap.get(eElement.getElementsByTagName("armor").item(0).getTextContent()); Armor has been removed
					String tmpBackground = eElement.getElementsByTagName("background").item(0).getTextContent();
					String tmpPlayerName = eElement.getElementsByTagName("playerName").item(0).getTextContent();
					String tmpFaction = eElement.getElementsByTagName("faction").item(0).getTextContent();
					String tmpAlignment = eElement.getElementsByTagName("alignment").item(0).getTextContent();
					int tmpExperiencePoints = Integer.parseInt(eElement.getElementsByTagName("experiencePoints").item(0).getTextContent());

					// The following code block parses the sub elements under "stats"
					NodeList nListStats = eElement.getElementsByTagName("stats");
					Node nNodeStats = nListStats.item(0);
					Element eElementStats = (Element) nNodeStats;
					//
					int tmpStrength = Integer.parseInt(eElementStats.getElementsByTagName("strength").item(0).getTextContent());
					int tmpDexterity = Integer.parseInt(eElementStats.getElementsByTagName("dexterity").item(0).getTextContent());
					int tmpConstitution = Integer.parseInt(eElementStats.getElementsByTagName("constitution").item(0).getTextContent());
					int tmpIntelligence = Integer.parseInt(eElementStats.getElementsByTagName("intelligence").item(0).getTextContent());
					int tmpWisdom = Integer.parseInt(eElementStats.getElementsByTagName("wisdom").item(0).getTextContent());
					int tmpCharisma = Integer.parseInt(eElementStats.getElementsByTagName("charisma").item(0).getTextContent());
					//
					//
					// The following code block parses the sub elements under "spells"
					NodeList nListSpells = eElement.getElementsByTagName("spells");
					//
					ArrayList<Spell> tmpSpells = new ArrayList();
					tmpSpells.clear();
					//
					if (nListSpells.getLength() != 0) {
						Node nNodeSpells = nListSpells.item(0);
						Element eElementSpells = (Element) nNodeSpells;
						//
						Spell tmpSpell;
						//
						NodeList tmpSpellNodeList = eElementSpells.getElementsByTagName("spell");
						for (int j = 0; j < tmpSpellNodeList.getLength(); j++) {
							tmpSpell = spellMap.get(eElementSpells.getElementsByTagName("spell").item(j).getTextContent());
							tmpSpells.add(tmpSpell);
						}
					} else {
						System.out.println("no spells");
					}
					//
					//
					// The following code block parses the sub elements under "weapons"
					NodeList nListWeapons = eElement.getElementsByTagName("weapons");
					//
					ArrayList<Equipment> tmpWeapons = new ArrayList();
					tmpWeapons.clear();
					//
					if (nListWeapons.getLength() != 0) {
						Node nNodeWeapons = nListWeapons.item(0);
						Element eElementWeapons = (Element) nNodeWeapons;
						//
						Equipment tmpWeapon;
						//
						NodeList tmpWeaponNodeList = eElementWeapons.getElementsByTagName("weapon");
						for (int j = 0; j < tmpWeaponNodeList.getLength(); j++) {
							tmpWeapon = weaponMap.get(eElementWeapons.getElementsByTagName("weapon").item(j).getTextContent());
							tmpWeapons.add(tmpWeapon);
						}
					} else {
						System.out.println("no weapons");
					}
					//
					//
					// The following code block parses the sub elements under "equipment" (items)
					NodeList nListItems = eElement.getElementsByTagName("equipment");
					//
					ArrayList<String> tmpItems = new ArrayList();
					tmpItems.clear();
					//
					if (nListItems.getLength() != 0) {
						Node nNodeItems = nListItems.item(0);
						Element eElementItems = (Element) nNodeItems;
						//
						String tmpItemString;
						//
						NodeList tmpItemNodeList = eElementItems.getElementsByTagName("item");
						for (int j = 0; j < tmpItemNodeList.getLength(); j++) {
							tmpItemString = eElementItems.getElementsByTagName("item").item(j).getTextContent();
							tmpItems.add(tmpItemString);
						}
					} else {
						System.out.println("no items");
					}
					//
					//
					// The following code block parses the sub elements under "proficiencies"
					NodeList nListProficiencies = eElement.getElementsByTagName("proficiencies");
					//
					ArrayList<String> tmpProficiencies = new ArrayList();
					tmpProficiencies.clear();
					//
					if (nListProficiencies.getLength() != 0) {
						Node nNodeProficiency = nListProficiencies.item(0);
						Element eElementProficiencies = (Element) nNodeProficiency;
						//
						String tmpProficiency;
						//
						NodeList tmpProficienciesNodeList = eElementProficiencies.getElementsByTagName("proficiency");
						for (int j = 0; j < tmpProficienciesNodeList.getLength(); j++) {
							tmpProficiency = eElementProficiencies.getElementsByTagName("proficiency").item(j).getTextContent();
							tmpProficiencies.add(tmpProficiency);
						}
					} else {
						System.out.println("no proficiencies");
					}
					//
					// The following code block parses the sub elements under "personalityTraits"
					NodeList nListPersonalityTraits = eElement.getElementsByTagName("personalityTraits");
					//
					ArrayList<String> tmpPersonalityTraits = new ArrayList();
					tmpPersonalityTraits.clear();
					//
					if (nListPersonalityTraits.getLength() != 0) {
						Node nNodePersonalityTrait = nListPersonalityTraits.item(0);
						Element eElementPersonalityTraits = (Element) nNodePersonalityTrait;
						//
						String tmpPersonalityTrait;
						//
						NodeList tmpPersonalityTraitsNodeList = eElementPersonalityTraits.getElementsByTagName("personalityTrait");
						for (int j = 0; j < tmpPersonalityTraitsNodeList.getLength(); j++) {
							tmpPersonalityTrait = eElementPersonalityTraits.getElementsByTagName("personalityTrait").item(j).getTextContent();
							tmpPersonalityTraits.add(tmpPersonalityTrait);
						}
					} else {
						System.out.println("no personalityTraits");
					}
					//
					// The following code block parses the sub elements under "ideals"
					NodeList nListIdeals = eElement.getElementsByTagName("ideals");
					//
					ArrayList<String> tmpIdeals = new ArrayList();
					tmpIdeals.clear();
					//
					if (nListIdeals.getLength() != 0) {
						Node nNodeIdeal = nListIdeals.item(0);
						Element eElementIdeals = (Element) nNodeIdeal;
						//
						String tmpIdeal;
						//
						NodeList tmpIdealsNodeList = eElementIdeals.getElementsByTagName("ideal");
						for (int j = 0; j < tmpIdealsNodeList.getLength(); j++) {
							tmpIdeal = eElementIdeals.getElementsByTagName("ideal").item(j).getTextContent();
							tmpIdeals.add(tmpIdeal);
						}
					} else {
						System.out.println("no ideals");
					}
					//
					// The following code block parses the sub elements under "bonds"
					NodeList nListBonds = eElement.getElementsByTagName("bonds");
					//
					ArrayList<String> tmpBonds = new ArrayList();
					tmpBonds.clear();
					//
					if (nListBonds.getLength() != 0) {
						Node nNodeBond = nListBonds.item(0);
						Element eElementBonds = (Element) nNodeBond;
						//
						String tmpBond;
						//
						NodeList tmpBondsNodeList = eElementBonds.getElementsByTagName("bond");
						for (int j = 0; j < tmpBondsNodeList.getLength(); j++) {
							tmpBond = eElementBonds.getElementsByTagName("bond").item(j).getTextContent();
							tmpBonds.add(tmpBond);
						}
					} else {
						System.out.println("no bonds");
					}
					//
					// The following code block parses the sub elements under "flaws"
					NodeList nListFlaws = eElement.getElementsByTagName("flaws");
					//
					ArrayList<String> tmpFlaws = new ArrayList();
					tmpFlaws.clear();
					//
					if (nListFlaws.getLength() != 0) {
						Node nNodeFlaw = nListFlaws.item(0);
						Element eElementFlaws = (Element) nNodeFlaw;
						//
						String tmpFlaw;
						//
						NodeList tmpFlawsNodeList = eElementFlaws.getElementsByTagName("flaw");
						for (int j = 0; j < tmpFlawsNodeList.getLength(); j++) {
							tmpFlaw = eElementFlaws.getElementsByTagName("flaw").item(j).getTextContent();
							tmpFlaws.add(tmpFlaw);
						}
					} else {
						System.out.println("no flaws");
					}
					//
					// The following code block parses the sub elements under "featureTraits"
					NodeList nListFeatureTraits = eElement.getElementsByTagName("featuresTraits");
					//
					ArrayList<String> tmpFeatureTraits = new ArrayList();
					tmpFeatureTraits.clear();
					//
					if (nListFeatureTraits.getLength() != 0) {
						Node nNodeFeatureTrait = nListFeatureTraits.item(0);
						Element eElementFeatureTraits = (Element) nNodeFeatureTrait;
						//
						String tmpFeatureTrait;
						//
						NodeList tmpFeatureTraitsNodeList = eElementFeatureTraits.getElementsByTagName("featureTrait");
						for (int j = 0; j < tmpFeatureTraitsNodeList.getLength(); j++) {
							tmpFeatureTrait = eElementFeatureTraits.getElementsByTagName("featureTrait").item(j).getTextContent();
							tmpFeatureTraits.add(tmpFeatureTrait);
						}
					} else {
						System.out.println("no featureTraits");
					}
					//
					//
					// The following code block parses the sub elements under "skills"
					Skills tmpSkills = new Skills();
					NodeList nListSkills = eElement.getElementsByTagName("skills");
					Node nNodeSkills = nListSkills.item(0);
					Element eElementSkills = (Element) nNodeSkills;
					//
					tmpSkills.setAcrobatics(Boolean.parseBoolean(eElementSkills.getElementsByTagName("acrobatics").item(0).getTextContent()));
					tmpSkills.setAnimalHandling(Boolean.parseBoolean(eElementSkills.getElementsByTagName("animalHandling").item(0).getTextContent()));
					tmpSkills.setArcana(Boolean.parseBoolean(eElementSkills.getElementsByTagName("arcana").item(0).getTextContent()));
					tmpSkills.setAthletics(Boolean.parseBoolean(eElementSkills.getElementsByTagName("athletics").item(0).getTextContent()));
					tmpSkills.setDeception(Boolean.parseBoolean(eElementSkills.getElementsByTagName("deception").item(0).getTextContent()));
					tmpSkills.setHistory(Boolean.parseBoolean(eElementSkills.getElementsByTagName("history").item(0).getTextContent()));
					tmpSkills.setInsight(Boolean.parseBoolean(eElementSkills.getElementsByTagName("insight").item(0).getTextContent()));
					tmpSkills.setIntimidation(Boolean.parseBoolean(eElementSkills.getElementsByTagName("intimidation").item(0).getTextContent()));
					tmpSkills.setInvestigation(Boolean.parseBoolean(eElementSkills.getElementsByTagName("investigation").item(0).getTextContent()));
					tmpSkills.setMedicine(Boolean.parseBoolean(eElementSkills.getElementsByTagName("medicine").item(0).getTextContent()));
					tmpSkills.setNature(Boolean.parseBoolean(eElementSkills.getElementsByTagName("nature").item(0).getTextContent()));
					tmpSkills.setPerception(Boolean.parseBoolean(eElementSkills.getElementsByTagName("perception").item(0).getTextContent()));
					tmpSkills.setPerformance(Boolean.parseBoolean(eElementSkills.getElementsByTagName("performance").item(0).getTextContent()));
					tmpSkills.setPersuasion(Boolean.parseBoolean(eElementSkills.getElementsByTagName("persuasion").item(0).getTextContent()));
					tmpSkills.setReligion(Boolean.parseBoolean(eElementSkills.getElementsByTagName("religion").item(0).getTextContent()));
					tmpSkills.setSleightOfHand(Boolean.parseBoolean(eElementSkills.getElementsByTagName("sleightOfHand").item(0).getTextContent()));
					tmpSkills.setStealth(Boolean.parseBoolean(eElementSkills.getElementsByTagName("stealth").item(0).getTextContent()));
					tmpSkills.setSurvival(Boolean.parseBoolean(eElementSkills.getElementsByTagName("survival").item(0).getTextContent()));
					tmpSkills.setStrength(Boolean.parseBoolean(eElementSkills.getElementsByTagName("strength").item(0).getTextContent()));
					tmpSkills.setDexterity(Boolean.parseBoolean(eElementSkills.getElementsByTagName("dexterity").item(0).getTextContent()));
					tmpSkills.setConstitution(Boolean.parseBoolean(eElementSkills.getElementsByTagName("constitution").item(0).getTextContent()));
					tmpSkills.setIntelligence(Boolean.parseBoolean(eElementSkills.getElementsByTagName("intelligence").item(0).getTextContent()));
					tmpSkills.setWisdom(Boolean.parseBoolean(eElementSkills.getElementsByTagName("wisdom").item(0).getTextContent()));
					tmpSkills.setCharisma(Boolean.parseBoolean(eElementSkills.getElementsByTagName("charisma").item(0).getTextContent()));
					
					//
					// ::::: The following code block parses the sub elements under "money"
					Money tmpMoney=new Money(0,0,0,0,0);
					NodeList nListMoney = eElement.getElementsByTagName("money");
					Node nNodeMoney = nListMoney.item(0);
					Element eElementMoney = (Element) nNodeMoney;
					//
					int cp = Integer.parseInt(eElementMoney.getElementsByTagName("copper").item(0).getTextContent());
					int sp = Integer.parseInt(eElementMoney.getElementsByTagName("silver").item(0).getTextContent());
					int ep = Integer.parseInt(eElementMoney.getElementsByTagName("eterium").item(0).getTextContent());
					int gp = Integer.parseInt(eElementMoney.getElementsByTagName("gold").item(0).getTextContent());
					int pp = Integer.parseInt(eElementMoney.getElementsByTagName("platin").item(0).getTextContent());
					tmpMoney.updateMoney(cp, sp, ep, gp, pp);
					//
					// ::::: Creating a DNDCharacter object to be returned
					tmpCharacter = new DNDCharacter(tmpName, tmpRace, tmpCharClass, tmpStrength, tmpDexterity, tmpConstitution, tmpIntelligence, tmpWisdom, tmpCharisma, tmpWeapons, tmpSpells, tmpProficiencies, tmpSkills, tmpItems, tmpBackground, tmpPlayerName, tmpFaction, tmpAlignment, tmpExperiencePoints, tmpPersonalityTraits, tmpIdeals, tmpBonds, tmpFlaws, tmpFeatureTraits,tmpMoney);
					tmpCharacter.print();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmpCharacter;
	}

	/*
	/**
	 * The Method "parseArmor" parses an input file (XML, specified via parameter "path") and fills its contents into a HashMap (String, Armor).
	 * @param path
	 * @return Map
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
	*/
}
