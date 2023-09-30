package me.lpmg.sakura.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import me.lpmg.sakura.GamePanel;

public class WonState extends GameState {

	private int charPosition = 0;
	private int wait = 0;
	private int wait2 = 0;
	private int charPosition2 = 0;
	private String text = "Nice.";
	private String text2 = "For once you actually did a good job.";
	private boolean done1 = false;
	private boolean done2 = false;

	public WonState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	public void init() {
		Random rn = new Random();
		int rand = 1 + rn.nextInt(3 - 1 + 1);
		switch(rand){
		case 1: 
			text="Nice";
			text2="For once you actually did a good job.";
		case 2: 
			text="Uh, it was..";
			text2="mediocre. But at least you've finished.";
		case 3: 
			text="Hmmm..";
			text2="that wasn't too bad.";
		}
	}

	public void tick() {
		if (charPosition < text.length() * 6) {
			charPosition++;
		} else {
			done1 = true;
		}

		if (done1) {
			wait++;
			if (wait >= 60) {
				if (charPosition2 < text2.length() * 6) {
					charPosition2++;
				} else {
					done2 = true;
					wait2++;
				}
			}
		}

		if (done2 && wait2 >= 80) {
			gameStateManager.nextLevel();
			gameStateManager.states.pop();
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, dim.width, dim.height);

		g.setFont(new Font("New Courier", Font.PLAIN, 48));
		g.setColor(Color.white);
		FontMetrics metrics = g.getFontMetrics(new Font("New Courier", Font.PLAIN, 48));
		int x = (int) ((dim.width - metrics.stringWidth(text)) / 2);
		int x2 = (int) ((dim.width - metrics.stringWidth(text2)) / 2);

		if (!done1) {
			g.drawString(text.substring(0, (int) (charPosition / 6)) + "_", x, (dim.height / 2));
		} else if(done1 && !done2){
			g.drawString(text, x, (dim.height / 2));
			g.drawString(text2.substring(0, (int) (charPosition2 / 6)) + "_", x2, (dim.height / 2) + 48);
		}else {
			g.drawString(text, x, (dim.height / 2));
			g.drawString(text2, x2, (dim.height / 2) + 48);
		}

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {

		}
	}

	public void keyReleased(int k) {

	}

}
