import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
//	Datenfelder fuer Steuerelemente
	@FXML
	private TextField txtFieldEingabe;
	@FXML
	private Button btnBerechnen;
	@FXML
	private Label lblAusgabe;
	@FXML
	private Button btnQuatsch;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		S T A R T

//		Eventhandler fuer Buttons
		btnBerechnen.setOnAction(event -> {

			try {
//		1. Zahl einlesen aus Textfeld
				txtFieldEingabe.setStyle("");
				long n = Long.parseLong(txtFieldEingabe.getText());

//		2. Fibonacci berechnen
				lblAusgabe.setText("Ich rechne ... ");
				btnBerechnen.setDisable(true);

				FibonacciTask task = new FibonacciTask(n);

				task.setOnSucceeded(evt -> {
					long erg = task.getValue();
					lblAusgabe.setText(String.format("Fibonacci(%d) = %d", n, erg));
//					Button wieder aktivieren
					btnBerechnen.setDisable(false);
				});

//		2. Thread starten
				Thread thread = new Thread(task);
				thread.start();

//				

			} catch (NumberFormatException e) {
//			Fehlermeldung
				lblAusgabe.setText("Bitte nur ganze Zahlen eingeben!");
				txtFieldEingabe.setStyle("-fx-background-color: red");
			}
		});

		btnQuatsch.setOnAction(event -> {
			if (btnQuatsch.getText().equals("Quatsch")) {
				btnQuatsch.setText("Quitsch");
			} else {
				btnQuatsch.setText("Quatsch");
			}
		});

	}

}
