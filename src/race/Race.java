package race;

import race.dwarf.*;
import race.elf.*;
import race.gnome.*;
import race.halfling.*;

import java.util.List;

public abstract class Race {
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
				tmpRace = new Human(); // to be defined: exception
				System.out.println("Default Race!");
				break;
		}
		return tmpRace;
	}
}
