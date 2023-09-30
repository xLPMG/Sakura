package me.lpmg.sakura;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import me.lpmg.sakura.gamestate.GameStateManager;
import me.lpmg.sakura.misc.DataHandler;
import me.lpmg.sakura.resources.Images;

public class GamePanel extends JPanel implements Runnable, KeyListener {

	public final static int WIDTH = 1920; //900
	public final static int HEIGHT = 1080; //563
	
	private int FPS = 60;
	private long targetTime = 1000 / FPS;
	private Dimension dim;

	private DataHandler dataHandler = new DataHandler();
	private GameStateManager gameStateManager;

	private Thread gameThread;
	private boolean isRunning = false;

	public GamePanel() {
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		if(dim.width > 1920) dim.width = 1920;
		if(dim.height > 1080) dim.height = 1080;
		
		setPreferredSize(dim);
		addKeyListener(this);
		setFocusable(true);
		new Images();		
		start();
	}

	private void start() {
		dataHandler.load();
		
		isRunning = true;	
		setCursor();
		gameStateManager = new GameStateManager(dataHandler, dim);
		gameThread = new Thread(this);
		gameThread.start();
		
		
	}

	@Override
	public void run() {
		long start, elapsed, wait;
		
		while (isRunning) {
			start = System.nanoTime();

			tick();
			repaint();
			elapsed = System.nanoTime() - start;
			wait = targetTime - elapsed / 1000000;

			if (wait < 0) {
				wait = 5;
			}

			try {
				gameThread.sleep(wait);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void tick() {
		gameStateManager.tick();
		if(gameStateManager.getExit()) {
			dataHandler.save();
			isRunning = false;
			gameThread.interrupt();
			System.exit(0);
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.clearRect(0, 0, dim.width, dim.height);
		gameStateManager.draw(g);
	}
	
	private void setCursor() {
		// Transparent 16 x 16 pixel cursor image.
		BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);

		// Create a new blank cursor.
		Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(
		    cursorImg, new Point(0, 0), "blank cursor");

		// Set the blank cursor to the JFrame.
		this.setCursor(blankCursor);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		gameStateManager.keyPressed(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gameStateManager.keyReleased(e.getKeyCode());
	}

}
