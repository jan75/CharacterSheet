package fx;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Jan on 07.01.2016.
 */
public class TableWeapon {

    private final SimpleStringProperty weaponTblName = new SimpleStringProperty("");
    private final SimpleStringProperty weaponTblAtk = new SimpleStringProperty("");
    private final SimpleStringProperty weaponTblDmgType = new SimpleStringProperty("");

    public TableWeapon() {
        this("","","");
    }

    public TableWeapon(String weaponTblName, String weaponTblAtk, String weaponTblDmgType) {
        setWeaponTblName(weaponTblName);
        setWeaponTblAtk(weaponTblAtk);
        setWeaponTblDmgType(weaponTblDmgType);
    }

    public void setWeaponTblName(String fName) {
        weaponTblName.set(fName);
    }

    public void setWeaponTblAtk(String fName) {
        weaponTblAtk.set(fName);
    }

    public void setWeaponTblDmgType(String fName) {
        weaponTblDmgType.set(fName);
    }

    public String getWeaponTblName() {
        return weaponTblName.get();
    }

    public String getWeaponTblAtk() {
        return weaponTblAtk.get();
    }

    public String getWeaponTblDmgType() {
        return weaponTblDmgType.get();
    }
}
