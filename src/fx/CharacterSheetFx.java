package fx;
	
import data.Armor;
import data.Equipment;
import data.*;
import data.Spell;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

import java.util.Map;

public class CharacterSheetFx extends Application {

	@Override
	public void start(Stage primaryStage) {
		System.out.println(this.getClass().getResource("src/fx/javaFxLayout.fxml"));
		try{
			AnchorPane root = FXMLLoader.load(this.getClass().getResource("/fx/javaFxLayout.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
