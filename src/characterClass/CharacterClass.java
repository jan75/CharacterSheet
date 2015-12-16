package characterClass;

import java.util.List;

public abstract class CharacterClass {
   String name;
   int hitDie;
   List<String> proficiencies;
	CharacterClass(String name){
	   this.name = name;
   }
}
