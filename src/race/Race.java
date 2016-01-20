package race;

import race.dwarf.HillDwarf;
import race.dwarf.MountainDwarf;
import race.elf.Drow;
import race.elf.HighElf;
import race.elf.WoodElf;
import race.gnome.ForestGnome;
import race.gnome.RockGnome;
import race.halfling.LightfootHalfling;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Race {
	private final static Logger LOGGER = Logger.getLogger("charSheetLogger");

	protected String name;
	int speed;
	List<String> languages;

	abstract String getName();

	public static Race createRace(String name) {
		Race tmpRace;
		switch (name) {
			case "Hill Dwarf": tmpRace = new HillDwarf();
				break;
			case "Mountain Dwarf": tmpRace = new MountainDwarf();
				break;
			case "Drow": tmpRace = new Drow();
				break;
			case "High Elf": tmpRace = new HighElf();
				break;
			case "Wood Elf": tmpRace = new WoodElf();
				break;
			case "Forest Gnome": tmpRace = new ForestGnome();
				break;
			case "Rock Gnome": tmpRace = new RockGnome();
				break;
			case "Lightfoot Halfling": tmpRace = new LightfootHalfling();
				break;
			case "Dragonborn": tmpRace = new Dragonborn();
				break;
			case "Half Elf": tmpRace = new HalfElf();
				break;
			case "Half Orc": tmpRace = new HalfOrc();
				break;
			case "Human": tmpRace = new Human();
				break;
			case "Tiefling": tmpRace = new Tiefling();
				break;
			default:
				tmpRace = new Human();
				LOGGER.log(Level.SEVERE, "Race not found, wrong parameter?\nUsing default race 'Human'");
				break;
		}
		return tmpRace;
	}
}
