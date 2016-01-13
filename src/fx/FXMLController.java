package fx;

import data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import race.*;

import javax.swing.event.DocumentEvent.EventType;
import javax.swing.text.html.parser.Parser;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLController implements Initializable{
    static Map<String, Equipment> weaponMap = ParserOperationsXML.parseWeapons("src/files/weapons.xml");
    //static Map<String, Armor> armorMap = ParserOperationsXML.parseArmor("src/files/armour.xml"); // Armor has been removed
    static Map<String, Spell> spellMap = ParserOperationsXML.parseSpells("src/files/spells.xml");

    @FXML private TextField txtExperiencePoints;
    @FXML private TextField txtDex;
    @FXML private TextField txtCon;
    @FXML private TextField txtInt;
    @FXML private TextField txtWis;
    @FXML private TextField txtCha;
    @FXML private TextField txtStr;
    @FXML private Label lblDexMod;
    @FXML private Label lblStrMod;
    @FXML private Label lblConMod;
    @FXML private Label lblIntMod;
    @FXML private Label lblWisMod;
    @FXML private Label lblChaMod;
    @FXML private Label lblInitiative;
    @FXML private Label lblSpeed;
    @FXML private Label lblPassivePerception;
	@FXML private Label lblProficencyMod;
    @FXML private TextField txtCopper;
    @FXML private TextField txtSilver;
    @FXML private TextField txtEterium;
    @FXML private TextField txtGold;
    @FXML private TextField txtPlatin;
    @FXML private TextField txtName;
    @FXML private TextField txtLevel;
    @FXML private TextField txtBackground;
    @FXML private TextField txtPlayerName;
    @FXML private TextField txtFaction;
    @FXML private TextField txtAlignment;
    @FXML private CheckBox chkDex;
    @FXML private CheckBox chkCon;
    @FXML private CheckBox chkInt;
    @FXML private CheckBox chkWis;
    @FXML private CheckBox chkCha;
    @FXML private CheckBox chkStr;
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
    @FXML private TextArea txtBoxSpells;
    @FXML private TextArea txtBoxTraits;
    @FXML private TextArea txtBoxIdeals;
    @FXML private TextArea txtBoxBonds;
    @FXML private TextArea txtBoxFlaws;
    @FXML private TableView<TableWeapon> tblAttacks;
    @FXML private TableColumn<Equipment, String> tblWeaponNameId;
    @FXML private TableColumn<Equipment, String> tblWeaponAtkBonusId;
    @FXML private TableColumn<Equipment, String> tblWeaponDmgTypeId;
    @FXML private ComboBox<String> cbAddWeapon;
    @FXML private Button btnDeleteWeapons;
    @FXML private ComboBox<String> cbRace;
    @FXML private ComboBox<String> cbClass;
    @FXML private Button btnAddMoney;
    @FXML private ComboBox<String> cbAddSpell;
    @FXML private Button btnDeleteSpells;
    
    List<Labeled> strMods;
    List<Labeled> dexMods;
    List<Labeled> conMods;
    List<Labeled> intMods;
    List<Labeled> wisMods;
    List<Labeled> chaMods;
    List<Integer> levelRange=Arrays.asList(300,900,2700,6500,14000,23000,34000,48000,64000,85000,100000,120000,140000,165000,195000,225000,265000,305000,355000);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		strMods=Arrays.asList(lblStrMod,chkStr,chkAthletics);
	    dexMods=Arrays.asList(lblDexMod,chkDex,lblInitiative,chkAcrobatics,chkSleightOfHand, chkStealth);
	    conMods=Arrays.asList(lblConMod,chkCon);
	    intMods=Arrays.asList(lblIntMod,chkInt,chkArcana, chkHistory, chkInvestigation, chkNature, chkReligion);
	    wisMods=Arrays.asList(lblWisMod,chkWis,chkAnimalHandling, chkInsight, chkMedicine, chkPerception, chkSurvival);
	    chaMods=Arrays.asList(lblChaMod,chkCha,chkDeception,chkIntimidation, chkPerformance, chkPersuasion);
	    txtStr.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(strMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtDex.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtCon.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(conMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtInt.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(intMods, CharacterSheetFx.activeCharacter.getStatBonus(z) >= 0 ? "+" + Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)) : Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtWis.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(wisMods, CharacterSheetFx.activeCharacter.getStatBonus(z) >= 0 ? "+" + Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)) : Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtWis.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updatePerception(CharacterSheetFx.activeCharacter.getStatBonus(z));
	    });
	    txtCha.textProperty().addListener((observable, oldValue, newValue) -> {
            int z = Integer.parseInt(newValue);
            updateMods(chaMods, CharacterSheetFx.activeCharacter.getStatBonus(z) >= 0 ? "+" + Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)) : Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
	    txtExperiencePoints.textProperty().addListener((observable, oldValue, newValue) -> {
            int z = Integer.parseInt(newValue);
            updateLevel(z);
        });
	    lblSpeed.setText(CharacterSheetFx.activeCharacter.getSpeed());
        //
        // ::::: Initiating ComboBoxes :::::
        ObservableList<String> races =
                FXCollections.observableArrayList(
                    "Hill Dwarf",
                    "Mountain Dwarf",
                    "Drow",
                    "High Elf",
                    "Wood Elf",
                    "Forest Gnome",
                    "Rock Gnome",
                    "Lightfoot Halfling",
                    "Stout Halfling",
                    "Dragonborn",
                    "Halfelf",
                    "Halforc",
                    "Human",
                    "Tiefling"
                );
        cbRace.setItems(races);
        //
        ObservableList<String> classes =
                FXCollections.observableArrayList(
                        "Barbarian",
                        "Bard",
                        "Cleric",
                        "Druid",
                        "Fighter",
                        "Monk",
                        "Paladin",
                        "Ranger",
                        "Rogue",
                        "Sorcerer",
                        "Warlock",
                        "Wizard"
                );
        cbClass.setItems(classes);

        ObservableList<String> weapons = FXCollections.observableArrayList(weaponMap.keySet());
        Collections.sort(weapons);
        cbAddWeapon.setItems(weapons);

        ObservableList<String> spells = FXCollections.observableArrayList(spellMap.keySet());
        Collections.sort(spells);
        cbAddSpell.setItems(spells);

        ObservableList<TableWeapon> data = tblAttacks.getItems();
        data.clear();

        openCharacter("src/files/DefaultCharacter.xml");
    }

	@FXML
    private void createNewCharacter() {
        System.out.println("MenuButton: New");
        //
        openCharacter("src/files/DefaultCharacter.xml");
    }

    private void openCharacter(String path) {
        DNDCharacter tmpCharacter;

        tmpCharacter = ParserOperationsXML.loadCharacterFromXML(path, weaponMap, spellMap);
        //
        txtDex.setText(Integer.toString(tmpCharacter.getDexterity()));
        txtCha.setText(Integer.toString(tmpCharacter.getCharisma()));
        txtCon.setText(Integer.toString(tmpCharacter.getConstitution()));
        txtInt.setText(Integer.toString(tmpCharacter.getIntelligence()));
        txtStr.setText(Integer.toString(tmpCharacter.getStrength()));
        txtWis.setText(Integer.toString(tmpCharacter.getWisdom()));
        //
        //txtLevel.setText(Integer.toString(tmpCharacter.getLevel())); handled by ExperiencePoints and events (which get called on change)
        cbClass.setValue(tmpCharacter.getCharClassName());
        txtBackground.setText(tmpCharacter.getBackground());
        txtPlayerName.setText(tmpCharacter.getPlayerName());
        txtFaction.setText(tmpCharacter.getFaction());
        cbRace.setValue(tmpCharacter.getRaceName());
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
        
        chkDex.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getDexterity();
	        updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkWis.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkInt.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkStr.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getStrength();
	        updateMods(strMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkCha.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkCon.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        
        chkAcrobatics.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getDexterity();
	        updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkAnimalHandling.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkArcana.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkAthletics.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getStrength();
	        updateMods(strMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkDeception.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkHistory.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkInsight.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkIntimidation.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkInvestigation.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkMedicine.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkNature.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkPerception.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkPerformance.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkPersuasion.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getCharisma();
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkReligion.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getIntelligence();
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkSleightOfHand.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getDexterity();
	        updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkStealth.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getDexterity();
	        updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });
        chkSurvival.selectedProperty().addListener((observable,oldValue,newValue)->{
        	int z = CharacterSheetFx.activeCharacter.getWisdom();
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
        });

        ArrayList<String> tmpWeaponKeyList = tmpCharacter.getItemKeysList(true);
        //System.out.println("tmpWeaponkeyList size: " + tmpWeaponKeyList.size());
        //
        ObservableList<TableWeapon> data = tblAttacks.getItems();
        data.clear();
        if(tmpWeaponKeyList.size() != 0) {
            for(String currentKey: tmpWeaponKeyList) {
                Equipment tmpWeapon = weaponMap.get(currentKey);
                System.out.println(tmpWeapon.getName());
                data.add(new TableWeapon(tmpWeapon.getName(), tmpWeapon.getName(), tmpWeapon.getName()));
                //System.out.println(currentKey);
                tblWeaponNameId.setText("");
                tblWeaponAtkBonusId.setText("");
                tblWeaponDmgTypeId.setText("");
            }
        }

        if(tmpCharacter.getSpellKeysList().size() != 0) {
            for(String currentKey: tmpCharacter.getSpellKeysList()) {
                txtBoxSpells.appendText(currentKey + "\n");
            }
        }

        if(!tmpCharacter.getLists("proficiencies").isEmpty()) {
            for(String currentProficiency: tmpCharacter.getLists("proficiencies")) {
                txtBoxProficiencies.appendText(currentProficiency + "\n");
            }
        }

        if(!tmpCharacter.getLists("equipment").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("equipment")) {
                txtBoxEquipment.appendText(currentItem + "\n");
            }
        }

        if(!tmpCharacter.getLists("personalityTraits").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("personalityTraits")) {
                txtBoxTraits.appendText(currentItem + "\n");
            }
        }

        if(!tmpCharacter.getLists("ideals").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("ideals")) {
                txtBoxIdeals.appendText(currentItem + "\n");
            }
        }

        if(!tmpCharacter.getLists("bonds").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("bonds")) {
                txtBoxBonds.appendText(currentItem + "\n");
            }
        }

        if(!tmpCharacter.getLists("flaws").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("flaws")) {
                txtBoxFlaws.appendText(currentItem + "\n");
            }
        }

        if(!tmpCharacter.getLists("featuresTraits").isEmpty()) {
            for(String currentItem: tmpCharacter.getLists("featuresTraits")) {
                txtBoxFeatures.appendText(currentItem + "\n");
            }
        }
        CharacterSheetFx.activeCharacter = tmpCharacter;
        updateMoney();
        updateProficiencyBonus();
    }

    @FXML
    private void openCharacterFileChooser() {
        System.out.println("MenuButton: Open");

        String path = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("XML Files", "*.xml"));
        File selectedFile = fileChooser.showOpenDialog(txtDex.getScene().getWindow());
        if(selectedFile != null) {
            path = selectedFile.getAbsolutePath();
        }
        //
        openCharacter(path);
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
    private void updateProficiencies() {
        CharacterSheetFx.activeCharacter.setLists("proficiencies", txtBoxProficiencies.getParagraphs());
    }

    @FXML
    private void updateEquipment() {
        CharacterSheetFx.activeCharacter.setLists("equipment", txtBoxEquipment.getParagraphs());
    }

    @FXML
    private void updatePersonalityTraits() {
        CharacterSheetFx.activeCharacter.setLists("personalityTraits", txtBoxTraits.getParagraphs());
    }

    @FXML
    private void updateIdeals() {
        CharacterSheetFx.activeCharacter.setLists("ideals", txtBoxIdeals.getParagraphs());
    }

    @FXML
    private void updateBonds() {
        CharacterSheetFx.activeCharacter.setLists("bonds", txtBoxBonds.getParagraphs());
    }

    @FXML
    private void updateFlaws() {
        CharacterSheetFx.activeCharacter.setLists("flaws", txtBoxFlaws.getParagraphs());
    }

    @FXML
    private void updateFeaturesTraits() {
        CharacterSheetFx.activeCharacter.setLists("featuresTraits", txtBoxTraits.getParagraphs());
    }

    @FXML
    private void addWeapon() {
        System.out.println("Add weapon");
        String placeholder = "???";
        //
        Weapon tmpTblWeapon = (Weapon) weaponMap.get(cbAddWeapon.getValue());
        CharacterSheetFx.activeCharacter.getWeapons().add(weaponMap.get(cbAddWeapon.getValue()));

        ObservableList<TableWeapon> data = tblAttacks.getItems();
        data.add(new TableWeapon(tmpTblWeapon.getName(), placeholder, tmpTblWeapon.getWeaponDamage()));

        tblWeaponNameId.setText("");
        tblWeaponAtkBonusId.setText("");
        tblWeaponDmgTypeId.setText("");
    }

    @FXML
    private void deleteWeapons() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Weapons");
        alert.setHeaderText("This action will delete all currently equipped Weapons!");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            ObservableList<TableWeapon> data = tblAttacks.getItems();
            data.clear();
            CharacterSheetFx.activeCharacter.getWeapons().clear();
            System.out.println(CharacterSheetFx.activeCharacter.getWeapons());
        }
    }

    @FXML
    private void addSpell() {
        System.out.println("Add spell");
        //
        txtBoxSpells.appendText(cbAddSpell.getValue() + "\n");
        //
        CharacterSheetFx.activeCharacter.addSpell(spellMap.get(cbAddSpell.getValue()));
    }

    @FXML
    private void deleteSpells() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Spells");
        alert.setHeaderText("This action will delete all Spells!");

        Optional<ButtonType> result = alert.showAndWait();
        if(result.get() == ButtonType.OK) {
            txtBoxSpells.setText("");
            //
            List<Spell> tmpSpellsNull = new ArrayList();
            tmpSpellsNull.clear();
            CharacterSheetFx.activeCharacter.setSpells(tmpSpellsNull);
        }
    }


    private void updateMods(List<Labeled> mods, String mod) {
    	for(Labeled temp: mods){
    		if(temp.getClass().getName()=="javafx.scene.control.CheckBox"){
    			CheckBox chkTmp = (CheckBox) temp;
    			if(chkTmp.isSelected()){
    				int tmp=Integer.parseInt(mod)+Integer.parseInt(lblProficencyMod.getText());
            		temp.setText(tmp>=0?"+"+Integer.toString(tmp):"-"+Integer.toString(tmp*-1));
            		continue;
    			}
    		}
        	temp.setText(mod);
    	}
	}
    
    private void updateLevel(int z) {
    	int level=1;
    	for(Integer tmp: levelRange){
    		if(z>=tmp.intValue()){
    			level+=1;
    		} else{
    			break;
    		}
    	}
    	CharacterSheetFx.activeCharacter.setLevel(level);
    	txtLevel.setText(Integer.toString(level));
        updateProficiencyBonus();
	}
    
    private void updateProficiencyBonus(){
    	String tmp;
    	switch(CharacterSheetFx.activeCharacter.getLevel()){
    	case 0:
    	case 1:
    	case 2:
    	case 3:
    	case 4:
    		tmp="+2";
    		break;
    	case 5:
    	case 6:
    	case 7:
    	case 8:
    		tmp="+3";
    		break;
    	case 9:
    	case 10:
    	case 11:
    	case 12:
    		tmp="+4";
    		break;
    	case 13:
    	case 14:
    	case 15:
    	case 16:
    		tmp="+5";
    		break;
    	case 17:
    	case 18:
    	case 19:
    	case 20:
    		tmp="+5";
    		break;
    	default:
    		tmp="+2";
    	}
    	lblProficencyMod.setText(tmp);
    }

	private void updatePerception(int statBonus) {
		int perception=10+statBonus;
		if(chkPerception.isSelected()){
			perception+=Integer.parseInt(lblProficencyMod.getText());
		}
		lblPassivePerception.setText(Integer.toString(perception));
	}
	
    @FXML
    private void exitApplication() {
        System.exit(0);
    }

    @FXML
    private void addMoney() {
        //System.out.println("add money");
        try{
            Stage stageMoney = new Stage();
            Parent root = FXMLLoader.load(FXMLController.class.getResource("/fx/javaFxLayoutMoney.fxml"));
            stageMoney.setScene(new Scene(root));
            stageMoney.setTitle("Add Money");
            stageMoney.initModality(Modality.WINDOW_MODAL);
            stageMoney.initOwner(tblAttacks.getScene().getWindow());
            stageMoney.setOnHiding((observable)-> {
                    updateMoney();
                });
            stageMoney.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void updateMoney() {
    	Money money=CharacterSheetFx.activeCharacter.getMoney();
        txtCopper.setText(Integer.toString(money.getCopper()));
        txtSilver.setText(Integer.toString(money.getSilver()));
        txtEterium.setText(Integer.toString(money.getEterium()));
        txtGold.setText(Integer.toString(money.getGold()));
        txtPlatin.setText(Integer.toString(money.getPlatin()));
	}

	@FXML
    private void subtractExp() {
        int z = Integer.parseInt(txtExperiencePoints.getText());
        if (z > 0) {
            z -= 50;
            txtExperiencePoints.setText(Integer.toString(z));
            CharacterSheetFx.activeCharacter.setExperiencePoints(z);
        }
    }

    @FXML
    private void addExp() {
        int z = Integer.parseInt(txtExperiencePoints.getText());
        z += 50;
        txtExperiencePoints.setText(Integer.toString(z));
        CharacterSheetFx.activeCharacter.setExperiencePoints(z);
    }
    
    @FXML
    private void subtractStr() {
        int z = Integer.parseInt(txtStr.getText());
        if (z > 0) {
            z--;
            txtStr.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addStr() {
        int z = Integer.parseInt(txtStr.getText());
        if( z < 20 ) {
	        z++;
	        txtStr.setText(Integer.toString(z));
        }
    }

	@FXML
    private void subtractDex() {
        int z = Integer.parseInt(txtDex.getText());
        if (z > 0) {
            z--;
            txtDex.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addDex() {
        int z = Integer.parseInt(txtDex.getText());
        if( z < 20 ) {
	        z++;
	        txtDex.setText(Integer.toString(z));
        }
    }
    
    @FXML
    private void subtractCon() {
        int z = Integer.parseInt(txtCon.getText());
        if (z > 0) {
            z--;
            txtCon.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addCon() {
        int z = Integer.parseInt(txtCon.getText());
        if( z < 20 ) {
	        z++;
	        txtCon.setText(Integer.toString(z));
        }
    }
    
    @FXML
    private void subtractInt() {
        int z = Integer.parseInt(txtInt.getText());
        if (z > 0) {
            z--;
            txtInt.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addInt() {
        int z = Integer.parseInt(txtInt.getText());
        if( z < 20 ) {
	        z++;
	        txtInt.setText(Integer.toString(z));
        }
    }
    
    @FXML
    private void subtractWis() {
        int z = Integer.parseInt(txtWis.getText());
        if (z > 0) {
            z--;
            txtWis.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addWis() {
        int z = Integer.parseInt(txtWis.getText());
        if( z < 20 ) {
	        z++;
	        txtWis.setText(Integer.toString(z));
        }
    }
    
    @FXML
    private void subtractCha() {
        int z = Integer.parseInt(txtCha.getText());
        if (z > 0) {
            z--;
            txtCha.setText(Integer.toString(z));
        }
    }

    @FXML
    private void addCha() {
        int z = Integer.parseInt(txtCha.getText());
        if( z < 20 ) {
	        z++;
	        txtCha.setText(Integer.toString(z));
        }
    }

 
}