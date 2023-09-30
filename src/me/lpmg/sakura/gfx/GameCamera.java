package me.lpmg.sakura.gfx;

import java.awt.Dimension;

import me.lpmg.sakura.GamePanel;
import me.lpmg.sakura.entities.Player;
import me.lpmg.sakura.gamestate.GameState;
import me.lpmg.sakura.mapping.Map;
import me.lpmg.sakura.objects.Block;

public class GameCamera {

	private Player player;
	private Map map;
	private Dimension dim;

	public GameCamera(Player player, Map map, Dimension dim) {
		this.player = player;
		this.map = map;
		this.dim = dim;
	}

	public void tick() {
		focusWindow();
	}

	private void focusWindow() {

		GameState.xOffset = player.getX() - dim.width / 2 + player.getWidth() / 2;
		GameState.yOffset = player.getY() - dim.height / 2 + player.getHeight() / 2;
		if (player.isSliding()) {
			GameState.yOffset = player.getY() - dim.height / 2;
		}

		checkBlankSpace();
	}

	public void checkBlankSpace() {
		if (GameState.xOffset < 0) {
			GameState.xOffset = 0;
		} else if (GameState.xOffset > map.getWidth() * Block.blockSize - dim.width) {
			// standard map offset
			GameState.xOffset = map.getWidth() * Block.blockSize - dim.width;
		}

		if (GameState.yOffset < 0) {
			GameState.yOffset = 0;
		} else if (GameState.yOffset > map.getHeight() * Block.blockSize - dim.height) {
			GameState.yOffset = map.getHeight() * Block.blockSize - dim.height;
		}
	}

}
