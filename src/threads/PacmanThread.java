package threads;
import ui.*;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import model.*;
public class PacmanThread extends Thread{
	private PacmanController pc;
	private Game g;
	public PacmanThread(PacmanController pacmanc, Game g) {
		pc = pacmanc;
		this.g = g;
	}
	public void run() {
				while(true) {
					for(int i = 0; i<g.getPacmans().size(); i++) {
						g.getPacmans().get(i).move(pc.getWidth());
						pc.updatePacmans();
						g.totalRebounds();
						try {
							sleep((long) g.getPacmans().get(i).getWait());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			
		}

}
