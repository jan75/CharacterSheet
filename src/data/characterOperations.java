package data;

import characterClass.*;
import race.*;
import fx.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by Jan on 22.12.2015.
 */
public class characterOperations {

    public static DNDCharacter initializeProgram() {
        Map<String, Equipment> weaponMap = ParserOperationsXML.parseWeapons("src/files/weapons.xml");
        Map<String, Armor> armorMap = ParserOperationsXML.parseArmor("src/files/armour.xml");
        Map<String, Spell> spellMap = ParserOperationsXML.parseSpells("src/files/spells.xml");
        /*
        Spell testSpellAnimateObjects = spellMap.get("Animate Objects");
        Spell testSpellAid = spellMap.get("Aid");
        Equipment tmpShovel = new Item("Shovel", "5", "1s");
        Equipment tmpRope = new Item("Rope", "1", "2b", "7m long");

        Equipment testWeapon = weaponMap.get("Crossbow, Light");

        ArrayList<Equipment> tmpPlayerEquipment = new ArrayList();
        ArrayList<Equipment> tmpPlayerWeapons = new ArrayList();
        ArrayList<Spell> tmpPlayerSpells = new ArrayList();
        ArrayList<String> tmpProficiencies = new ArrayList();
        ArrayList<Equipment> tmpItems = new ArrayList();
        ArrayList<String> tmpPersonalityTraits = new ArrayList();
        ArrayList<String> tmpIdeals = new ArrayList();
        ArrayList<String> tmpBonds = new ArrayList();
        ArrayList<String> tmpFlaws = new ArrayList();
        ArrayList<String> tmpFeaturesTraits = new ArrayList();

        Equipment testArmor = armorMap.get("Leather");

        Skills tmpSkills = new Skills();
        Race tmpRace = new Dragonborn();
        CharacterClass tmpClass = new Cleric();

        tmpPlayerWeapons.add(testWeapon);

        tmpItems.add(tmpRope);
        tmpItems.add(tmpShovel);
        tmpPlayerSpells.add(testSpellAnimateObjects);
        tmpPlayerSpells.add(testSpellAid);
        tmpProficiencies.add("Maces");
        tmpProficiencies.add("Swords");
        tmpProficiencies.add("Shields");
        tmpPersonalityTraits.add("personalityTrait");
        tmpIdeals.add("ideal");
        tmpBonds.add("bond");
        tmpFlaws.add("flaw");
        tmpFeaturesTraits.add("featureTrait");
        */

        //DNDCharacter defaultCharacter = new DNDCharacter("DefaultCharacter", tmpRace, tmpClass, 5, 5, 5, 5, 5, 5, 0, tmpPlayerWeapons, tmpPlayerSpells, testArmor, tmpProficiencies, tmpSkills, tmpItems, "DefaultBackground", "DefaultPlayer", "DefaultFaction", "DefaultAlignment", 0, tmpPersonalityTraits, tmpIdeals, tmpBonds, tmpFlaws, tmpFeaturesTraits);
        //tmpCharacter.print();
        //
        //ParserOperationsXML.saveCharacterToXML(defaultCharacter, "src/files/DefaultCharacter.xml");
        DNDCharacter defaultCharacter = ParserOperationsXML.loadCharacterFromXML("src/files/DefaultCharacter.xml", weaponMap, spellMap, armorMap);
        //
        return defaultCharacter;
    }


}
