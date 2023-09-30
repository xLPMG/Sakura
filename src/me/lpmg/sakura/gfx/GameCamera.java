package me.lpmg.sakura.gfx;

import me.lpmg.sakura.GamePanel;
import me.lpmg.sakura.entities.Player;
import me.lpmg.sakura.gamestate.GameState;
import me.lpmg.sakura.mapping.Map;
import me.lpmg.sakura.objects.Block;

public class GameCamera {

	private Player player;
	private Map map;

	public GameCamera(Player player, Map map) {
		this.player = player;
		this.map = map;
	}

	public void tick() {
		focusWindow();
	}

	private void focusWindow() {

		GameState.xOffset = player.getX() - GamePanel.WIDTH / 2 + player.getWidth() / 2;
		GameState.yOffset = player.getY() - GamePanel.HEIGHT / 2 + player.getHeight() / 2;
		if (player.isSliding()) {
			GameState.yOffset = player.getY() - GamePanel.HEIGHT / 2;
		}

		checkBlankSpace();
	}

	public void checkBlankSpace() {
		if (GameState.xOffset < 0) {
			GameState.xOffset = 0;
		} else if (GameState.xOffset > map.getWidth() * Block.blockSize - GamePanel.WIDTH) {
			// standard map offset
			GameState.xOffset = map.getWidth() * Block.blockSize - GamePanel.WIDTH;
		}

		if (GameState.yOffset < 0) {
			GameState.yOffset = 0;
		} else if (GameState.yOffset > map.getHeight() * Block.blockSize - GamePanel.HEIGHT) {
			GameState.yOffset = map.getHeight() * Block.blockSize - GamePanel.HEIGHT;
		}
	}

}
