package fx;
	
import data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import race.DNDCharacter;

public class CharacterSheetFx extends Application {
	static DNDCharacter activeCharacter;

	@Override
	public void start(Stage primaryStage) {
		DNDCharacter currentCharacter = characterOperations.initializeProgram();

		//System.out.println(this.getClass().getResource("src/fx/javaFxLayout.fxml"));
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
