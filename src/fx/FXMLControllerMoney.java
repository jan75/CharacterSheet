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
            //
            try{
                int valueMoney = Integer.parseInt(txtMoney.getText());
                switch (selectedToggleMoneyText) {
                    case "CP":
                        System.out.println("Added " + valueMoney + " Copper");
                        cancelMoney();
                        break;
                    case "SP":
                        System.out.println("Added " + valueMoney + " Silver");
                        cancelMoney();
                        break;
                    case "EP":
                        System.out.println("Added " + valueMoney + " Eterium");
                        cancelMoney();
                        break;
                    case "GP":
                        System.out.println("Added " + valueMoney + " Gold");
                        cancelMoney();
                        break;
                    case "PP":
                        System.out.println("Added " + valueMoney + " Platinum");
                        cancelMoney();
                        break;
                    default:
                        System.out.println("Enter a number and choose an entity");
                        break;
                }
            } catch(Exception e){
                System.out.println("Enter a number (only numeric values)");
                //e.printStackTrace();
            }
        } else {
            System.out.println("Enter a number and choose an entity");
        }
    }
 
}