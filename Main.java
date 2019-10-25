import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage fenster) throws Exception {

//		 FXML-Datei laden
		final URL url = getClass().getResource("Layout.fxml");
		final FXMLLoader fxmlloader = new FXMLLoader(url);

//		 Controller verbinden
		fxmlloader.setController(new Controller());

//		 Layout laden
		final Parent root = fxmlloader.load();

//		 Layout auf Fensterinhalt setzen
		fenster.setScene(new Scene(root));

//		 sonstige Fenstereigenschaften
		fenster.setTitle("Fibonacci mit Quatschi");
		fenster.setWidth(350.0);
		fenster.setMinWidth(350.0);
		fenster.setMinHeight(200.0);

//		 Fenster anzeigen
		fenster.show();

	}
}
