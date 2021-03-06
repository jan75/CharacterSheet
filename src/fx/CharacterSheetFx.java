package fx;

import com.sun.media.jfxmedia.track.Track;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import race.DNDCharacter;
import sun.util.calendar.BaseCalendar;
import sun.util.resources.cldr.en.CalendarData_en_UM;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.*;

public class CharacterSheetFx extends Application {
	private final static Logger LOGGER = Logger.getLogger("charSheetLogger");
	static DNDCharacter activeCharacter;


	@Override
	public void start(Stage primaryStage) {
		initLoggers();
		//
		try{
			FXMLLoader loader= new FXMLLoader();
			AnchorPane root = loader.load(this.getClass().getResource("/fx/javaFxLayout.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("CharacterSheet");
			primaryStage.getIcons().add(new Image(CharacterSheetFx.class.getResourceAsStream("/fx/ApplicationIcon.png")));
			primaryStage.show();
		} catch(Exception e) {
			LOGGER.log(Level.SEVERE, "Exception " + e.getMessage(), e);
		}
	}


	private void initLoggers() {
		String datum = new SimpleDateFormat("yyyy.MM.dd").format(new Date());
		//
		try {
			System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tc %2$s%n%4$s: %5$s%6$s%n");
			//
			new File(System.getProperty("user.home") + "/CharacterSheetLogs").mkdir();
			Handler fileHandlerSevere = new FileHandler(System.getProperty("user.home") + "/CharacterSheetLogs/" + datum + "_severe.log", true);
			Handler fileHandlerInfo = new FileHandler(System.getProperty("user.home") + "/CharacterSheetLogs/" + datum + "_info.log", true);
			fileHandlerSevere.setLevel(Level.SEVERE);
			fileHandlerInfo.setFilter(record -> record.getLevel().equals(Level.INFO));
			Formatter singleLineFormat = new SimpleFormatter();
			fileHandlerInfo.setFormatter(singleLineFormat);
			fileHandlerSevere.setFormatter(singleLineFormat);
			//
			LOGGER.addHandler(fileHandlerSevere);
			LOGGER.addHandler(fileHandlerInfo);
			//
			LOGGER.log(Level.INFO, "Info Log initiated");
			LOGGER.log(Level.SEVERE, "Severe Log Initiated");
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Exception " + e.getMessage(), e);
		}
	}
}