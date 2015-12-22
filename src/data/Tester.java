package data;

import javax.swing.text.html.parser.Parser;
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
        Spell testSpell = spellMap.get("Animate Objects");
        Spell testSpell2 = spellMap.get("Aid");

        ArrayList<Equipment> tmpPlayerEquipment = new ArrayList();
        tmpPlayerEquipment.add(testWeapon);
        tmpPlayerEquipment.add(testArmor);

        ArrayList<Spell> tmpPlayerSpells = new ArrayList();
        tmpPlayerSpells.add(testSpell);
        tmpPlayerSpells.add(testSpell2);

        String tmpCharName = "Haudrauf";
        int[] tmpPlayerStats = {4,5,7,6,4,2};

        Player tmpPlayer = new Player(tmpCharName, tmpPlayerStats, tmpPlayerEquipment, tmpPlayerSpells);
        //tmpPlayer.print();
        //
        ParserOperationsXML.saveCharacterToXML(tmpPlayer);
    }

}
