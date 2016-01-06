package fx;

import data.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import race.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
    @FXML private TextField txtCopper;
    @FXML private TextField txtSilver;
    @FXML private TextField txtEterium;
    @FXML private TextField txtGold;
    @FXML private TextField txtPlatin;
    @FXML private TextField txtName;
    @FXML private TextField txtClassAndLevel;
    @FXML private TextField txtBackground;
    @FXML private TextField txtPlayerName;
    @FXML private TextField txtFaction;
    @FXML private TextField txtRace;
    @FXML private TextField txtAlignment;
    @FXML private CheckBox chkAcrobatics;
    @FXML private CheckBox chkAnimalHandling;
    @FXML private CheckBox chkArcana;
    @FXML private CheckBox chkAthletics;
    @FXML private CheckBox chkDeception;
    @FXML private CheckBox chkHistory;
    @FXML private CheckBox chkInsight;
    @FXML private CheckBox chkIntimidation;
    @FXML private CheckBox chkInvestigation;
    @FXML private CheckBox chkMedicine;
    @FXML private CheckBox chkNature;
    @FXML private CheckBox chkPerception;
    @FXML private CheckBox chkPerformance;
    @FXML private CheckBox chkPersuasion;
    @FXML private CheckBox chkReligion;
    @FXML private CheckBox chkSleightOfHand;
    @FXML private CheckBox chkStealth;
    @FXML private CheckBox chkSurvival;
    @FXML private TextArea txtBoxFeatures;
    @FXML private TextArea txtBoxEquipment;
    @FXML private TextArea txtBoxProficiencies;
    @FXML private TextArea txtBoxAttacks;
    @FXML private TextArea txtBoxTraits;
    @FXML private TextArea txtBoxIdeals;
    @FXML private TextArea txtBoxBonds;
    @FXML private TextArea txtBoxFlaws;
    @FXML private TableView<Equipment> tblAttacks;
    @FXML private TableColumn<Equipment, String> tblColumnName;
    @FXML private TableColumn<Equipment, String> tblColumnAtkBonus;
    @FXML private TableColumn<Equipment, String> tblColumnDamage;

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

        DNDCharacter tmpCharacter;

        String path = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(txtDex.getScene().getWindow());
        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();
        }

        tmpCharacter = ParserOperationsXML.loadCharacterFromXML(path, weaponMap, spellMap, armorMap);

        //
        txtDex.setText(Integer.toString(tmpCharacter.getDexterity()));
        txtCha.setText(Integer.toString(tmpCharacter.getCharisma()));
        txtCon.setText(Integer.toString(tmpCharacter.getConstitution()));
        txtInt.setText(Integer.toString(tmpCharacter.getIntelligence()));
        txtStr.setText(Integer.toString(tmpCharacter.getStrength()));
        txtWis.setText(Integer.toString(tmpCharacter.getWisdom()));
        //
        txtClassAndLevel.setText(tmpCharacter.getCharClassName() + " " + Integer.toString(tmpCharacter.getLevel()));
        txtBackground.setText(tmpCharacter.getBackground());
        txtPlayerName.setText(tmpCharacter.getPlayerName());
        txtFaction.setText(tmpCharacter.getFaction());
        txtRace.setText(tmpCharacter.getRaceName());
        txtAlignment.setText(tmpCharacter.getAlignment());
        txtExperiencePoints.setText(Integer.toString(tmpCharacter.getExperiencePoints()));
        //
        chkAcrobatics.setSelected(tmpCharacter.getSkills().isAcrobatics());
        chkAnimalHandling.setSelected(tmpCharacter.getSkills().isAnimalHandling());
        chkArcana.setSelected(tmpCharacter.getSkills().isArcana());
        chkAthletics.setSelected(tmpCharacter.getSkills().isAthletics());
        chkDeception.setSelected(tmpCharacter.getSkills().isDeception());
        chkHistory.setSelected(tmpCharacter.getSkills().isHistory());
        chkInsight.setSelected(tmpCharacter.getSkills().isInsight());
        chkIntimidation.setSelected(tmpCharacter.getSkills().isIntimidation());
        chkInvestigation.setSelected(tmpCharacter.getSkills().isInvestigation());
        chkMedicine.setSelected(tmpCharacter.getSkills().isMedicine());
        chkNature.setSelected(tmpCharacter.getSkills().isNature());
        chkPerception.setSelected(tmpCharacter.getSkills().isPerception());
        chkPerformance.setSelected(tmpCharacter.getSkills().isPerformance());
        chkPersuasion.setSelected(tmpCharacter.getSkills().isPersuasion());
        chkReligion.setSelected(tmpCharacter.getSkills().isReligion());
        chkSleightOfHand.setSelected(tmpCharacter.getSkills().isSleightOfHand());
        chkStealth.setSelected(tmpCharacter.getSkills().isStealth());
        chkSurvival.setSelected(tmpCharacter.getSkills().isSurvival());

        /* to be continued
        ArrayList<String> tmpWeaponKeyList = tmpCharacter.getItemKeysList(true);
        if(tmpWeaponKeyList.size() != 0) {
            for(String currentKey: tmpWeaponKeyList) {
                Equipment tmpWeapon = weaponMap.get(currentKey);



                //System.out.println(currentKey);
            }
        }

        tblColumnName.setCellValueFactory(new PropertyValueFactory<Equipment, String>("name"));
        tblColumnAtkBonus.setCellValueFactory(new PropertyValueFactory<Equipment, String>("atkBonus"));
        tblColumnDamage.setCellValueFactory(new PropertyValueFactory<Equipment, String>("damage"));
        //
        tblAttacks.getItems().setAll(parseWeaponsToTable());
        */






        CharacterSheetFx.activeCharacter = tmpCharacter;

    }


    @FXML
    private void saveCharacter() {
        System.out.println("MenuButton: Save");

        String path = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Character");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
        File selectedFile = fileChooser.showSaveDialog(txtDex.getScene().getWindow());
        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();
        }
        //
        if(path != null) {
            ParserOperationsXML.saveCharacterToXML(CharacterSheetFx.activeCharacter, path);
            System.out.println("File saved under " + path);
        } else {
            System.out.println("File not saved - path not valid");
        }
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