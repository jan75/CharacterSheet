package fx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by Jan on 02.01.2016.
 */
public class FXMLController {
    @FXML
    private TextField txtExperiencePoints;


    @FXML
    private void createNewCharacter() {
        System.out.println("MenuButton: New");
        //

    }

    @FXML
    private void openCharacter() {
        System.out.println("MenuButton: Open");
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