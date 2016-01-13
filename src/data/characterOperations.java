package data;

import race.DNDCharacter;

import java.util.Map;



/**
 * Created by Jan on 22.12.2015.
 */
public class characterOperations {

    public static DNDCharacter initializeProgram() {
        Map<String, Equipment> weaponMap = ParserOperationsXML.parseWeapons("src/files/weapons.xml");
        Map<String, Spell> spellMap = ParserOperationsXML.parseSpells("src/files/spells.xml");
        //
        DNDCharacter defaultCharacter = ParserOperationsXML.loadCharacterFromXML("src/files/DefaultCharacter.xml", weaponMap, spellMap);
        //
        return defaultCharacter;
    }


}
