package fx;
	
import data.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import race.DNDCharacter;

public class CharacterSheetFx extends Application {
	static DNDCharacter activeCharacter;

	@Override
	public void start(Stage primaryStage) {
		DNDCharacter currentCharacter = characterOperations.initializeProgram();
		setActiveCharacter(currentCharacter);
		//System.out.println(this.getClass().getResource("src/fx/javaFxLayout.fxml"));
		try{
			FXMLLoader loader= new FXMLLoader();
			AnchorPane root = loader.load(this.getClass().getResource("/fx/javaFxLayout.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("CharacterSheet");
			//primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("file:/src/fx/DnDLogo.png")));
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void setActiveCharacter(DNDCharacter dndchar){
		activeCharacter = dndchar;
	}
}
