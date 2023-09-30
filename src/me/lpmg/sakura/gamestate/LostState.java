package me.lpmg.sakura.gamestate;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.Random;

import me.lpmg.sakura.GamePanel;

public class LostState extends GameState {

	private int charPosition = 0;
	private int wait = 0;
	private int wait2 = 0;
	private int charPosition2 = 0;
	private String text = "You lost.";
	private String text2 = "Are you really this bad?";
	private boolean done1 = false;
	private boolean done2 = false;

	public LostState(GameStateManager gameStateManager) {
		super(gameStateManager);
		init();
	}

	public void init() {
		Random rn = new Random();
		int rand = 1 + rn.nextInt(3 - 1 + 1);
		switch(rand){
		case 1: 
			text="You lost.";
			text2="Are you really this bad?";
		case 2: 
			text="To be fair,";
			text2="I already expected this outcome from you.";
		case 3: 
			text="lmaoooo";
			text2="I could've done that better blindfolded..";
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
			gameStateManager.states.pop();
		}
	}

	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

		g.setFont(new Font("New Courier", Font.PLAIN, 48));
		g.setColor(Color.white);
		FontMetrics metrics = g.getFontMetrics(new Font("New Courier", Font.PLAIN, 48));
		int x = (int) ((GamePanel.WIDTH - metrics.stringWidth(text)) / 2);
		int x2 = (int) ((GamePanel.WIDTH - metrics.stringWidth(text2)) / 2);

		if (!done1) {
			g.drawString(text.substring(0, (int) (charPosition / 6)) + "_", x, (GamePanel.HEIGHT / 2));
		} else if(done1 && !done2){
			g.drawString(text, x, (GamePanel.HEIGHT / 2));
			g.drawString(text2.substring(0, (int) (charPosition2 / 6)) + "_", x2, (GamePanel.HEIGHT / 2) + 48);
		}else {
			g.drawString(text, x, (GamePanel.HEIGHT / 2));
			g.drawString(text2, x2, (GamePanel.HEIGHT / 2) + 48);
		}

	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_ENTER) {

		}
	}

	public void keyReleased(int k) {

	}

}
