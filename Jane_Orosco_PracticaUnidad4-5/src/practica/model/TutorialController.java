package practica.model;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

public class TutorialController {
	@FXML
	private MenuBar menu;

	@FXML
	void exitApp(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void exitTutorial(ActionEvent event) {
		Stage stage = (Stage) menu.getScene().getWindow();
		stage.close();
	}
}
