package fx;

import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import race.*;

import java.io.File;
import java.util.Map;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLController {
    @FXML private TextField txtExperiencePoints;
    @FXML private TextField txtDex;
    @FXML private TextField txtCon;
    @FXML private TextField txtInt;
    @FXML private TextField txtWis;
    @FXML private TextField txtCha;
    @FXML private TextField txtStr;

    @FXML
    private void createNewCharacter() {
        System.out.println("MenuButton: New");
        //
    }

    @FXML
    private void openCharacter() {
        System.out.println("MenuButton: Open");

        Map<String, Equipment> weaponMap = ParserOperationsXML.parseWeapons("src/files/weapons.xml");
        Map<String, Armor> armorMap = ParserOperationsXML.parseArmor("src/files/armour.xml");
        Map<String, Spell> spellMap = ParserOperationsXML.parseSpells("src/files/spells.xml");

        String path = null;

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(txtDex.getScene().getWindow());
        if(selectedFile != null) {
            System.out.println("hi");
            path = selectedFile.getAbsolutePath();
        }

        DNDCharacter tmpCharacter = ParserOperationsXML.loadCharacterFromXML(path, weaponMap, spellMap, armorMap);
        System.out.println("bla");
        txtDex.setText(Integer.toString(tmpCharacter.getDexterity()));
        txtCha.setText(Integer.toString(tmpCharacter.getCharisma()));
        txtCon.setText(Integer.toString(tmpCharacter.getConstitution()));
        txtInt.setText(Integer.toString(tmpCharacter.getIntelligence()));
        txtStr.setText(Integer.toString(tmpCharacter.getStrength()));
        txtWis.setText(Integer.toString(tmpCharacter.getWisdom()));
    }

    @FXML
    private void saveCharacter() {
        System.out.println("MenuButton: Save");
    }

    @FXML
    private void exitApplication() {
        System.exit(0);
    }

    @FXML
    private void subtractExp() {
        int z = Integer.parseInt(txtExperiencePoints.getText());
        if (z > 0) {
            z--;
            txtExperiencePoints.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addExp() {
        int z = Integer.parseInt(txtExperiencePoints.getText());
        z++;
        txtExperiencePoints.setText(Integer.toString(z));
    }
}