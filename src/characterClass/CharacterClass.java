package characterClass;

import java.util.List;

public abstract class CharacterClass {
   String name;
   int hitDie;
   public boolean isStrProf() {
	return strProf;
}
public void setStrProf(boolean strProf) {
	this.strProf = strProf;
}
public boolean isConProf() {
	return conProf;
}
public void setConProf(boolean conProf) {
	this.conProf = conProf;
}
public boolean isIntProf() {
	return intProf;
}
public void setIntProf(boolean intProf) {
	this.intProf = intProf;
}
public boolean isChaProf() {
	return chaProf;
}
public void setChaProf(boolean chaProf) {
	this.chaProf = chaProf;
}
public boolean isDexProf() {
	return dexProf;
}
public void setDexProf(boolean dexProf) {
	this.dexProf = dexProf;
}
public boolean isWisProf() {
	return wisProf;
}
public void setWisProf(boolean wisProf) {
	this.wisProf = wisProf;
}
boolean strProf=false;
   boolean conProf=false;
   boolean intProf=false;
   boolean chaProf=false;
   boolean dexProf=false;
   boolean wisProf=false;
}
