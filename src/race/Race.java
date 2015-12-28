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
			case "HillDwarf": tmpRace = new HillDwarf();
				break;
			case "MountainDwarf": tmpRace = new MountainDwarf();
				break;
			case "Drow": tmpRace = new Drow();
				break;
			case "HighElf": tmpRace = new HighElf();
				break;
			case "WoodElf": tmpRace = new WoodElf();
				break;
			case "ForestGnome": tmpRace = new ForestGnome();
				break;
			case "RockGnome": tmpRace = new RockGnome();
				break;
			case "LightfootHalfling": tmpRace = new LightfootHalfling();
				break;
			case "Dragonborn": tmpRace = new Dragonborn();
				break;
			case "HalfElf": tmpRace = new HalfElf();
				break;
			case "HalfOrc": tmpRace = new HalfOrc();
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
