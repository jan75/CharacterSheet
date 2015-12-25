package data;

import characterClass.*;
import race.*;

import java.util.ArrayList;
import java.util.Map;



/**
 * Created by Jan on 22.12.2015.
 */
public class Tester {

    public static void main(String[] args) {
        Map<String, Equipment> weaponMap = ParserOperationsXML.parseWeapons("src/files/weapons.xml");
        Map<String, Armor> armorMap = ParserOperationsXML.parseArmor("src/files/armour.xml");
        Map<String, Spell> spellMap = ParserOperationsXML.parseSpells("src/files/spells.xml");

        Equipment testWeapon = weaponMap.get("Crossbow, Light");
        Equipment testArmor = armorMap.get("Leather");
        Spell testSpellAnimateObjects = spellMap.get("Animate Objects");
        Spell testSpellAid = spellMap.get("Aid");

        ArrayList<Equipment> tmpPlayerEquipment = new ArrayList();

        ArrayList<Equipment> tmpPlayerWeapons = new ArrayList();
        tmpPlayerWeapons.add(testWeapon);

        ArrayList<Spell> tmpPlayerSpells = new ArrayList();
        tmpPlayerSpells.add(testSpellAnimateObjects);
        tmpPlayerSpells.add(testSpellAid);

        ArrayList<String> tmpProficiencies = new ArrayList();
        tmpProficiencies.add("Maces");
        tmpProficiencies.add("Swords");
        tmpProficiencies.add("Shields");
        tmpProficiencies.add("Detecting Undead");

        Skills tmpSkills = new Skills();

        Race tmpRace = new Dragonborn();

        CharacterClass tmpClass = new Cleric();

        DNDCharacter tmpCharacter = new DNDCharacter("Haudrauf", tmpRace, tmpClass, 1, 2, 3, 4, 5, 6, 2, tmpPlayerEquipment, tmpPlayerWeapons, tmpPlayerSpells, testArmor, tmpProficiencies, tmpSkills);
        //tmpCharacter.print();
        //
        ParserOperationsXML.saveCharacterToXML(tmpCharacter);
        ParserOperationsXML.loadCharacterFromXML("src/files/Haudrauf.xml", weaponMap, spellMap, armorMap);
        //System.out.println(tmpCharacter.getSpellKeysList());
    }

}
