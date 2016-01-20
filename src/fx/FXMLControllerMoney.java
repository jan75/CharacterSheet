package fx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLControllerMoney {
    private final static Logger LOGGER = Logger.getLogger("charSheetLogger");

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
                        LOGGER.log(Level.INFO, "Added " + valueMoney + " Copper");
                        cp=valueMoney;
                        break;
                    case "SP":
                        LOGGER.log(Level.INFO, "Added " + valueMoney + " Silver");
                        sp=valueMoney;
                        break;
                    case "EP":
                        LOGGER.log(Level.INFO, "Added " + valueMoney + " Eterium");
                        ep=valueMoney;
                        break;
                    case "GP":
                        LOGGER.log(Level.INFO, "Added " + valueMoney + " Gold");
                        gp=valueMoney;
                        break;
                    case "PP":
                        LOGGER.log(Level.INFO, "Added " + valueMoney + " Platinum");
                        pp=valueMoney;
                        break;
                    default:
                        LOGGER.log(Level.INFO, "Enter a number and choose an entity before clicking on confirm");
                        break;
                }
				CharacterSheetFx.activeCharacter.setMoney(CharacterSheetFx.activeCharacter.getMoney().updateMoney(cp, sp, ep, gp, pp));
				cancelMoney();
            } catch(Exception e){
                LOGGER.log(Level.SEVERE, "Enter a number (only numeric values)");
            }
        } else {
            LOGGER.log(Level.INFO, "Enter a number and choose an entity");
        }
    }
 
}