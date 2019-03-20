package ui;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.*;
import threads.PacmanThread;

public class PacmanController {

    @FXML
    private AnchorPane ap;
    private Stage stage;
    private Game game;
    @FXML
    private AnchorPane ap2;
    @FXML
    private ArrayList<Arc> arcs;
    @FXML
    private Label rebounds;
    private int score;

public void setStage(Stage stage) {
	this.stage = stage;
}
public double getWidth() {
	return stage.getWidth();
}
@FXML
public void loadGame(ActionEvent event) throws IOException, ClassNotFoundException {
	game = new Game(0);
	game.startGame();
	arcs = new ArrayList<>();
	for(int i = 0; i<game.getPacmans().size(); i++) {
		Arc ar = new Arc(game.getPacmans().get(i).getPosX(),game.getPacmans().get(i).getPosY(),game.getPacmans().get(i).getRadio(),game.getPacmans().get(i).getRadio(),45,270);
		ar.setType(ArcType.ROUND);
		ar.setFill(Color.YELLOW);
		arcs.add(ar);
	}
	ap2.getChildren().addAll(arcs);
	PacmanThread ct = new PacmanThread(this, game);
	ct.start();
	rebounds.setText("" + game.totalRebounds());
	score = score - game.totalRebounds()*10;
}
@FXML
public void stop(MouseEvent event) {
	double x = event.getSceneX();
	double y = event.getSceneY();
	for(int i = 0; i < game.getPacmans().size(); i++) {
		game.getPacmans().get(i).stopPacman(x, y);
	}
	score = score + 50;
}
public void updatePacmans() {
	for(int i = 0; i < game.getPacmans().size(); i++) {
		arcs.get(i).setLayoutX(game.getPacmans().get(i).getPosX());
		arcs.get(i).setLayoutY(game.getPacmans().get(i).getPosY());
	}
	
}
@FXML
void saveGame(ActionEvent event) throws FileNotFoundException, IOException {
	game.saveGame();
	System.out.println("Name: ");
	Scanner sn = new Scanner(System.in);
	String name = sn.nextLine();
	Player p = new Player(name);
	Score s = new Score(p, score);
	game.getScores().add(s);
}
@FXML
void betterScores(ActionEvent event) {
	Label l = new Label();
	l.setText(game.betterScores());
	ap2.getChildren().add(l);
}
}