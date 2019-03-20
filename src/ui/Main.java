package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main  extends Application {
	@Override 
	public void start(Stage stage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pacman.fxml"));
		Parent root = fxmlLoader.load();
		PacmanController pacmanC = fxmlLoader.getController();
		pacmanC.setStage(stage);
		
		Scene scene = new Scene(root);
		stage.setTitle("Catch pacman!");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		

	}

}
