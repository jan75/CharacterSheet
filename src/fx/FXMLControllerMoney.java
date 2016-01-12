package fx;

import data.Equipment;
import data.ParserOperationsXML;
import data.Spell;
import data.Weapon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import race.DNDCharacter;

import javax.xml.soap.Node;
import java.io.File;
import java.net.URL;
import java.util.*;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLControllerMoney {

    @FXML private Button btnCancelMoney;
    @FXML private ToggleGroup toggleGroupMoney;
    @FXML private TextField txtMoney;
    
    int cp;
	int sp;
	int ep;
	int gp;
	int pp;
	
    @FXML
    private void cancelMoney() {
        Stage closeStage = (Stage) btnCancelMoney.getScene().getWindow();
        closeStage.close();
    }

    @FXML
    private void confirmMoney() {
        if (toggleGroupMoney.getSelectedToggle() != null && txtMoney.getText() != "") {
            RadioButton selectedToggleMoney = (RadioButton) toggleGroupMoney.getSelectedToggle();
            String selectedToggleMoneyText = selectedToggleMoney.getText();
            cp=0;
            sp=0;
            ep=0;
            gp=0;
            pp=0;
            //
            try{
                int valueMoney = Integer.parseInt(txtMoney.getText());
                switch (selectedToggleMoneyText) {
                    case "CP":
                        System.out.println("Added " + valueMoney + " Copper");
                        cp=valueMoney;
                        break;
                    case "SP":
                        System.out.println("Added " + valueMoney + " Silver");
                        sp=valueMoney;
                        break;
                    case "EP":
                        System.out.println("Added " + valueMoney + " Eterium");
                        ep=valueMoney;
                        break;
                    case "GP":
                        System.out.println("Added " + valueMoney + " Gold");
                        gp=valueMoney;
                        break;
                    case "PP":
                        System.out.println("Added " + valueMoney + " Platinum");
                        pp=valueMoney;
                        break;
                    default:
                        System.out.println("Enter a number and choose an entity");
                        break;
                }
				CharacterSheetFx.activeCharacter.setMoney(CharacterSheetFx.activeCharacter.getMoney().updateMoney(cp, sp, ep, gp, pp));
				cancelMoney();
            } catch(Exception e){
                System.out.println("Enter a number (only numeric values)");
                //e.printStackTrace();
            }
        } else {
            System.out.println("Enter a number and choose an entity");
        }
    }
 
}