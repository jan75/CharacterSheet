package fx;

import data.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import race.*;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLController implements Initializable{
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
    @FXML private TextArea txtBoxAttacks;
    @FXML private TextArea txtBoxTraits;
    @FXML private TextArea txtBoxIdeals;
    @FXML private TextArea txtBoxBonds;
    @FXML private TextArea txtBoxFlaws;
    @FXML private TableView<Equipment> tblAttacks;
    @FXML private TableColumn<Equipment, String> tblColumnName;
    @FXML private TableColumn<Equipment, String> tblColumnAtkBonus;
    @FXML private TableColumn<Equipment, String> tblColumnDamage;
    
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
	        updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtWis.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtWis.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updatePerception(CharacterSheetFx.activeCharacter.getStatBonus(z));
	    });
	    txtCha.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>=0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
	    });
	    txtExperiencePoints.textProperty().addListener((observable, oldValue, newValue) -> {
	    	int z = Integer.parseInt(newValue);
	        updateLevel(z);
	    });
	    lblSpeed.setText(CharacterSheetFx.activeCharacter.getSpeed());
	} 

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
    
    private void updateMods(List<Labeled> mods, String mod) {
    	for(Labeled temp: mods){
    		if(temp.getClass().getName()=="javafx.scene.control.CheckBox"){
    			CheckBox chkTmp = (CheckBox) temp;
    			if(chkTmp.isSelected()){
    				int tmp=Integer.parseInt(mod)+CharacterSheetFx.activeCharacter.proficencybonus;
    				mod=tmp>=0?"+"+Integer.toString(tmp):"-"+Integer.toString(tmp*-1);
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
    	txtClassAndLevel.setText(txtClassAndLevel.getText().split(" ")[0]+" "+Integer.toString(level));
	}

	private void updatePerception(int statBonus) {
		int perception=10+statBonus;
		if(chkPerception.isSelected()){
			perception+=CharacterSheetFx.activeCharacter.proficencybonus;
		}
		lblPassivePerception.setText(Integer.toString(perception));
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
    
    @FXML
    private void subtractStr() {
        int z = Integer.parseInt(txtStr.getText());
        if (z > 0) {
            z--;
            txtStr.setText(Integer.toString(z));
        }
        // updateMods(strMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addStr() {
        int z = Integer.parseInt(txtStr.getText());
        if( z < 20 ) {
	        z++;
	        txtStr.setText(Integer.toString(z));
        }
        // updateMods(strMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

	@FXML
    private void subtractDex() {
        int z = Integer.parseInt(txtDex.getText());
        if (z > 0) {
            z--;
            txtDex.setText(Integer.toString(z));
        }
        // updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addDex() {
        int z = Integer.parseInt(txtDex.getText());
        if( z < 20 ) {
	        z++;
	        txtDex.setText(Integer.toString(z));
        }
        // updateMods(dexMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }
    
    @FXML
    private void subtractCon() {
        int z = Integer.parseInt(txtCon.getText());
        if (z > 0) {
            z--;
            txtCon.setText(Integer.toString(z));
        }
        // updateMods(conMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addCon() {
        int z = Integer.parseInt(txtCon.getText());
        if( z < 20 ) {
	        z++;
	        txtCon.setText(Integer.toString(z));
        }
        // updateMods(conMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }
    
    @FXML
    private void subtractInt() {
        int z = Integer.parseInt(txtInt.getText());
        if (z > 0) {
            z--;
            txtInt.setText(Integer.toString(z));
        }
        // updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addInt() {
        int z = Integer.parseInt(txtInt.getText());
        if( z < 20 ) {
	        z++;
	        txtInt.setText(Integer.toString(z));
        }
        // updateMods(intMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }
    
    @FXML
    private void subtractWis() {
        int z = Integer.parseInt(txtWis.getText());
        if (z > 0) {
            z--;
            txtWis.setText(Integer.toString(z));
        }
        // updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addWis() {
        int z = Integer.parseInt(txtWis.getText());
        if( z < 20 ) {
	        z++;
	        txtWis.setText(Integer.toString(z));
        }
        // updateMods(wisMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }
    
    @FXML
    private void subtractCha() {
        int z = Integer.parseInt(txtCha.getText());
        if (z > 0) {
            z--;
            txtCha.setText(Integer.toString(z));
        }
        // updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

    @FXML
    private void addCha() {
        int z = Integer.parseInt(txtCha.getText());
        if( z < 20 ) {
	        z++;
	        txtCha.setText(Integer.toString(z));
        }
        // updateMods(chaMods,CharacterSheetFx.activeCharacter.getStatBonus(z)>0?"+"+Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)):Integer.toString(CharacterSheetFx.activeCharacter.getStatBonus(z)));
    }

 
}