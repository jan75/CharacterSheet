package data;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Created by Jan on 22.12.2015.
 */
class Player {
    String charName;
    int[] playerStats;
    ArrayList<Equipment> playerEquipment;
    ArrayList<Spell> playerSpells;

    Player(String charName, int[] playerStats, ArrayList<Equipment> playerEquipment, ArrayList<Spell> playerSpells) {
        this.charName = charName;
        this.playerStats = playerStats;
        this.playerEquipment = playerEquipment;
        this.playerSpells = playerSpells;
    }

    String getSpellKeysString() {
        String tmpString = "";
        ListIterator<Spell> tmpIterator = playerSpells.listIterator();
        while(tmpIterator.hasNext()) {
            Spell spell = tmpIterator.next();
            if(tmpIterator.hasNext()) {
                tmpString += spell.getKey() + " | ";
            } else {
                tmpString += spell.getKey();
            }
        }
        return tmpString;
    }

    String getEquipmentKeysString() {
        String tmpString = "";
        ListIterator<Equipment> tmpIterator = playerEquipment.listIterator();
        while(tmpIterator.hasNext()) {
            Equipment equip = tmpIterator.next();
            if(tmpIterator.hasNext()) {
                tmpString += equip.getKey() + " | ";
            } else {
                tmpString += equip.getKey();
            }
        }
        return tmpString;
    }

    String getPlayerStatsString() {
        StringBuilder tmpStringBuilder = new StringBuilder(playerStats.length);
        for(int i = 0; i < playerStats.length; i++) {
            tmpStringBuilder.append(playerStats[i]);
            if(i != (playerStats.length - 1)) {
                tmpStringBuilder.append(", ");
            }
        }
        return tmpStringBuilder.toString();
    }

    String getCharName() {
        return charName;
    }

    void print() {
        System.out.println("Character:\t" + charName + "\nStats:\t\t" + getPlayerStatsString() + "\nEquipment:\t" + getEquipmentKeysString() + "\nSpells:\t\t" + getSpellKeysString());
    }
}
