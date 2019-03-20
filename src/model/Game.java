package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Game {
	private ArrayList<Pacman> pacmans;
	private int level;
	private final static String PATH_FILE = "data/levels";
	private ArrayList<Score> scores;
	public Game(int l) {
		pacmans = new ArrayList<>();
		level = l;
		scores = new ArrayList<>();
	}
	public void startGame() throws IOException, ClassNotFoundException {
		File archive = new File(PATH_FILE);
		FileReader reader = new FileReader(archive);
		BufferedReader br = new BufferedReader(reader);
		String ln = br.readLine();
		String dif = "#";
		int i = 0;
				while(ln != null) {
					String[] parts = ln.split(";");
					double radio =Double.parseDouble(parts[0]);
					double posX = Double.parseDouble(parts[1]);
					double posY = Double.parseDouble(parts[2]);
					double wait = Double.parseDouble(parts[3]);
					int direction = Integer.parseInt(parts[4]);
					int rebounds = Integer.parseInt(parts[5]);
					boolean state = Boolean.valueOf(parts[6]);
					Pacman pc = new Pacman(radio, posX, posY, wait, direction, rebounds, state);
					pacmans.add(pc);
					ln = br.readLine();
					i++;
				}
			reader.close();
			br.close();

	}
	public ArrayList<Pacman> getPacmans() {
		return pacmans;
	}
	public int totalRebounds() {
		int totalRebounds = 0;
		for(int i = 0; i<pacmans.size(); i++) {
			totalRebounds = totalRebounds + pacmans.get(i).getRebounds();
		}
		return totalRebounds;
	}
	public void saveGame() throws FileNotFoundException, IOException {
		File archive = new File(PATH_FILE);
		ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(archive));
		os.writeObject(pacmans);
		PrintWriter pw = new PrintWriter(archive);
		pw.print(os);
		os.close();
		pw.close();
	}
	public String betterScores() {
		String message = "";
		for(int i = 0; i<scores.size(); i++) {
			if(scores.get(i).getValue() > scores.get(i-1).getValue()) {
				message = ("Better Score: " + scores.get(i).getValue() + "Player: " + scores.get(i).getPlayer());
			}
		}
		return message;
	}
	public ArrayList<Score> getScores(){
		return scores;
	}

}
