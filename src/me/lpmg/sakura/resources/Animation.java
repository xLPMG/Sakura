package me.lpmg.sakura.resources;

import java.awt.image.BufferedImage;

public class Animation {

	private int speed, index, counter, repeat;
	private long lastTime, timer;
	private boolean hasEnded = false;
	private BufferedImage[] frames;

	public Animation(int speed, BufferedImage[] frames, int repeat) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		timer = 0;
		counter = 0;
		this.repeat = repeat;
		lastTime = System.currentTimeMillis();
	}

	public void tick() {
		if (!hasEnded) {
			timer += System.currentTimeMillis() - lastTime;
			lastTime = System.currentTimeMillis();

			if (timer > speed) {
				index++;
				timer = 0;
				if (index >= frames.length) {
					index = 0;
					counter++;
				}
			}

			if (repeat != 0) {
				if (counter == repeat) {
					hasEnded = true;
				}
			}
		}
	}
	
	public boolean hasEnded() {
		return hasEnded;
	}

	public BufferedImage getCurrentFrame() {
		return hasEnded ? null : frames[index];
	}

}
