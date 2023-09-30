package me.lpmg.sakura.entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import me.lpmg.sakura.GamePanel;
import me.lpmg.sakura.gamestate.GameState;
import me.lpmg.sakura.gamestate.GameStateManager;
import me.lpmg.sakura.gamestate.MenuState;
import me.lpmg.sakura.objects.Block;
import me.lpmg.sakura.resources.Animation;
import me.lpmg.sakura.resources.Images;

public class Player implements Entity {

	private Animation animIdleRight, animIdleLeft, animRunRight, animRunLeft, animJumpCrouchRight, animJumpCrouchLeft,
			animFallRight, animFallLeft, animSlideRight, animSlideLeft;

	private boolean right = false, left = false, jumping = false, falling = false, idleRight = true, idleLeft = false,
			sliding = false, canSlide = true;;
	private boolean topCollision = false;

	private int maxHealth = 3;
	private int health = maxHealth;

	private double x, y;
	private int width, height;
	private Dimension dim;
	private int slideWidth, slideHeight, orgWidth, orgHeight;
	private double defaultSpeed = 2.8;
	private double moveSpeed = defaultSpeed;
	private double defaultJumpSpeed = 7.2;
	private double jumpSpeed = defaultJumpSpeed;
	private double currentJumpSpeed = jumpSpeed;

	private double maxFallSpeed = 8;
	private double currentFallSpeed = 0.2;
	private int walkingDirection = 1;

	private boolean rightCol = false;
	private boolean leftCol = false;

	private int level;

	private EntityManager eM;

	public Player(int width, int height, int x, int y, Dimension dim) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.dim = dim;
		slideWidth = width * 2;
		slideHeight = height / 2;
		orgWidth = width;
		orgHeight = height;

		animIdleRight = new Animation(250, Images.player_idle_right, 0);
		animIdleLeft = new Animation(250, Images.player_idle_left, 0);
		animRunRight = new Animation(150, Images.player_run_right, 0);
		animRunLeft = new Animation(150, Images.player_run_left, 0);
		animJumpCrouchRight = new Animation(100, Images.player_jump_crouch_right, 0);
		animJumpCrouchLeft = new Animation(100, Images.player_jump_crouch_left, 0);
		animFallRight = new Animation(100, Images.player_falling_right, 0);
		animFallLeft = new Animation(100, Images.player_falling_left, 0);
		animSlideRight = new Animation(100, Images.player_slide_right, 0);
		animSlideLeft = new Animation(100, Images.player_slide_left, 0);
	}

	public void tick(Block[][] blocks, Block[][] blocks2) {

		int iX = (int) x;
		int iY = (int) y;
		rightCol = false;
		leftCol = false;

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				if (blocks[i][j].getID() == 999) {
					System.out.println("Next level");
				}
				if (blocks[i][j].isSolid()) {
					// System.out.println("block y: "+blocks[i][j].getY()+", player y:
					// "+(y-height));

					// right side
					if (entityBlockEntityCollision(new Point(iX + width + 5, iY + 2), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height - 1), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height / 2 - 1),
									blocks[i][j])) {
						// right = false;
						rightCol = true;
					}
					// left side
					if (entityBlockEntityCollision(new Point(iX - 5, iY + 2), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height - 1), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height / 2 - 1), blocks[i][j])) {
						// left = false;
						leftCol = true;
					}
					// top
					if (entityBlockEntityCollision(new Point(iX + 1, iY), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width - 2, iY), blocks[i][j])) {
						jumping = false;
						falling = true;
					}
					// bottom
					if (entityBlockCollision(new Point(iX + 10, iY + height), blocks[i][j])
							|| entityBlockCollision(new Point(iX + width - 20, iY + height), blocks[i][j])
							|| entityBlockCollision(new Point(iX + width / 2 - 10, iY + height), blocks[i][j])) {
						// no entity col
						y = blocks[i][j].getCollisionBounds().getY() - height;
						falling = false;
						topCollision = true;

					} else {
						if (!topCollision && !jumping) {
							falling = true;
						}
					}
				}
			}
		}
		for (int i = 0; i < blocks2.length; i++) {
			for (int j = 0; j < blocks2[0].length; j++) {
				if (blocks2[i][j].getID() == 999) {
					System.out.println("Next level");
				}
				if (blocks2[i][j].isSolid()) {
					// System.out.println("block y: "+blocks2[i][j].getY()+", player y:
					// "+(y-height));

					// right side
					if (entityBlockEntityCollision(new Point(iX + width + 5, iY + 2), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height - 1), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height / 2 - 1),
									blocks2[i][j])) {
						// right = false;
						rightCol = true;
					}
					// left side
					if (entityBlockEntityCollision(new Point(iX - 5, iY + 2), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height - 1), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height / 2 - 1), blocks2[i][j])) {
						// left = false;
						leftCol = true;
					}
					// top
					if (entityBlockEntityCollision(new Point(iX + 1, iY), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width - 2, iY), blocks2[i][j])) {
						jumping = false;
						falling = true;
					}
					// bottom
					if (entityBlockCollision(new Point(iX + 10, iY + height), blocks2[i][j])
							|| entityBlockCollision(new Point(iX + width - 20, iY + height), blocks2[i][j])
							|| entityBlockCollision(new Point(iX + width / 2 - 10, iY + height), blocks2[i][j])) {
						// no entity col
						y = blocks2[i][j].getCollisionBounds().getY() - height;
						falling = false;
						topCollision = true;

					} else {
						if (!topCollision && !jumping) {
							falling = true;
						}
					}
				}
			}
		}
		if (entityEntityCollision(new Point(iX + 10, iY + height + 1))
				|| entityEntityCollision(new Point(iX + width - 20, iY + height + 1))
				|| entityEntityCollision(new Point(iX + width / 2 - 10, iY + height + 1))) {
			if (getCollidingEntity() != null) {
				// entity col
//				System.out.println("bot col");
//			y = getCollidingEntity().getY() - height;
				falling = false;
				jumping = true;
				getCollidingEntity().dealDamage(1);
			}
		}

		topCollision = false;

		if (right && !rightCol && !sliding) {
			x += moveSpeed;
		}
		if (left && !leftCol && !sliding) {
			x -= moveSpeed;
		}

		if (jumping) {
			y -= currentJumpSpeed;
			currentJumpSpeed -= 0.2;

			if (currentJumpSpeed <= 0) {
				currentJumpSpeed = jumpSpeed;
				jumping = false;
				falling = true;
			}
		}

		if (falling) {
			y += currentFallSpeed;
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.2;
			}
		} else {
			currentFallSpeed = 0.2;
		}

		if (sliding) {
			if (walkingDirection == 1 && !rightCol) {
				x += defaultSpeed * 2;
			} else if (walkingDirection == 2 && !leftCol) {
				x -= defaultSpeed * 2;
			}
		}

		if (!right && !left && !jumping && !falling && !sliding) {
			if (walkingDirection == 1) {
				idleRight = true;
				idleLeft = false;
			} else {
				idleLeft = true;
				idleRight = false;
			}
		} else {
			idleRight = false;
			idleLeft = false;
		}
		// animations
		animIdleRight.tick();
		animIdleLeft.tick();
		animRunRight.tick();
		animRunLeft.tick();
		animJumpCrouchRight.tick();
		animJumpCrouchLeft.tick();
		animFallRight.tick();
		animFallLeft.tick();

		if (y > 2000) {
			// die();
			// TODO
		}
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void draw(Graphics g) {
//		g.setColor(Color.red);
//		g.drawRect((int) x + 10 - (int) GameState.xOffset, (int) y - (int) GameState.yOffset, width - 10, height);

		if (idleRight) {
			g.drawImage(animIdleRight.getCurrentFrame(), (int) x - 14 * 3 - (int) GameState.xOffset,
					(int) y - 7 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (idleLeft) {
			g.drawImage(animIdleLeft.getCurrentFrame(), (int) x - 16 * 3 - (int) GameState.xOffset,
					(int) y - 7 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (right && !jumping && !falling && !sliding) {
			g.drawImage(animRunRight.getCurrentFrame(), (int) x - 18 * 3 - (int) GameState.xOffset,
					(int) y - 7 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (left && !jumping && !falling && !sliding) {
			g.drawImage(animRunLeft.getCurrentFrame(), (int) x - 14 * 3 - (int) GameState.xOffset,
					(int) y - 7 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
			// jumping right
		} else if (walkingDirection == 1 && jumping && currentJumpSpeed >= jumpSpeed - 2) {
			g.drawImage(animJumpCrouchRight.getCurrentFrame(), (int) x - 16 * 3 - (int) GameState.xOffset,
					(int) y - 7 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 1 && jumping && currentJumpSpeed > 2.5 && currentJumpSpeed < jumpSpeed - 2) {
			g.drawImage(Images.player_jumping_right[0], (int) x - 17 * 3 - (int) GameState.xOffset,
					(int) y - 5 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 1 && jumping && currentJumpSpeed <= 2.5) {
			g.drawImage(Images.player_jump_end_right[0], (int) x - 16 * 3 - (int) GameState.xOffset,
					(int) y - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
			// jumping left
		} else if (walkingDirection == 2 && jumping && currentJumpSpeed >= jumpSpeed - 2) {
			g.drawImage(animJumpCrouchLeft.getCurrentFrame(), (int) x - 15 * 3 - (int) GameState.xOffset,
					(int) y - 8 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 2 && jumping && currentJumpSpeed > 2.2 && currentJumpSpeed < jumpSpeed - 2) {
			g.drawImage(Images.player_jumping_left[0], (int) x - 14 * 3 - (int) GameState.xOffset,
					(int) y - 6 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 2 && jumping && currentJumpSpeed <= 2.2) {
			g.drawImage(Images.player_jump_end_left[0], (int) x - 15 * 3 - (int) GameState.xOffset,
					(int) y - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
			// end jumping
		} else if (walkingDirection == 1 && falling && !sliding) {
			g.drawImage(animFallRight.getCurrentFrame(), (int) x - 16 * 3 - (int) GameState.xOffset,
					(int) y - 3 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 2 && falling && !sliding) {
			g.drawImage(animFallLeft.getCurrentFrame(), (int) x - 15 * 3 - (int) GameState.xOffset,
					(int) y - 3 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		}
		// sliding
		else if (walkingDirection == 1 && sliding) {
			g.drawImage(animSlideRight.getCurrentFrame(), (int) x - 5 * 3 - (int) GameState.xOffset,
					(int) y - 21 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		} else if (walkingDirection == 2 && sliding) {
			g.drawImage(animSlideLeft.getCurrentFrame(), (int) x - 11 * 3 - (int) GameState.xOffset,
					(int) y - 21 * 3 - (int) GameState.yOffset, 50 * 3, 37 * 3, null);
		}

//		if (right && jumping && !falling) {
//			g.drawImage(playerJumpingRight, (int) x, (int) y, width,
//					(width / playerJumpingRight.getWidth(null) * playerJumpingRight.getHeight(null)), null);
//		} else if (left && jumping && !falling) {
//			g.drawImage(playerJumpingLeft, (int) x, (int) y, width,
//					(width / playerJumpingLeft.getWidth(null) * playerJumpingLeft.getHeight(null)), null);
//		} else if (right && !jumping && falling) {
//			g.drawImage(playerFallingRight, (int) x, (int) y, width,
//					(width / playerFallingRight.getWidth(null) * playerFallingRight.getHeight(null)), null);
//		} else if (left && !jumping && falling) {
//			g.drawImage(playerFallingLeft, (int) x, (int) y, width,
//					(width / playerFallingLeft.getWidth(null) * playerFallingLeft.getHeight(null)), null);
//		}

//		g.setColor(Color.red);
//		g.fillRect((int) x + 2-(int)GameState.xOffset, (int) y + height-(int)GameState.yOffset, width - 4, 10);
//		g.setColor(Color.black);
	}

	public void drawEntityGUI(Graphics g) {
		if (health == 3) {
			g.drawImage(Images.player_health_3[0], (int) dim.width - 263, (int) 16, 247, 76, null);
		}
		if (health == 2) {
			g.drawImage(Images.player_health_2[0], (int) dim.width - 263, (int) 16, 247, 76, null);
		}
		if (health == 1) {
			g.drawImage(Images.player_health_1[0], (int) dim.width - 263, (int) 16, 247, 76, null);
		}
		g.setFont(new Font("New Courier", Font.PLAIN, 48));
		g.setColor(Color.white);
		g.drawString(level + "", 16, 48);

		g.setFont(new Font("New Courier", Font.PLAIN, 16));
		g.drawString("X: " + (int) x + " Y:  " + (int) y, dim.width / 2, 24);
	}

	public void keyPressed(int k) {
		if (k == KeyEvent.VK_D) {
			right = true;
			walkingDirection = 1;
		}
		if (k == KeyEvent.VK_A) {
			left = true;
			walkingDirection = 2;
		}
		if (k == KeyEvent.VK_SHIFT) {
			moveSpeed = defaultSpeed * 2;
			jumpSpeed = defaultJumpSpeed * 1.22;
		}
		if (k == KeyEvent.VK_SPACE && !falling && !jumping)
			jumping = true;
		sliding = false;

		if (k == KeyEvent.VK_S && !falling && !jumping && canSlide) {
			if (right || left) {
				sliding = true;
				canSlide = false;
				y = y += slideHeight;
				height = slideHeight;
				width = slideWidth;

				// slide duration
				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						sliding = false;
						y = y -= slideHeight;
						height = orgHeight;
						width = orgWidth;
					}
				}, 400);
				// slide cooldown
				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						canSlide = true;
					}
				}, 800);
			}
		}
	}

	public void keyReleased(int k) {
		if (k == KeyEvent.VK_D)
			right = false;
		if (k == KeyEvent.VK_A)
			left = false;
		if (k == KeyEvent.VK_SHIFT) {
			moveSpeed = defaultSpeed;
			jumpSpeed = defaultJumpSpeed;
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public Rectangle getEntityRect() {
		return new Rectangle((int) x, (int) y, width, height);
	}

	public void setEntityManager(EntityManager eM) {
		this.eM = eM;
	}

	private boolean entityBlockCollision(Point p, Block b) {
		return b.getCollisionBounds().contains(p);
	}

	private boolean entityBlockEntityCollision(Point p, Block b) {
		if (b.getCollisionBounds().contains(p)) {
			return true;
		}
		for (Entity e : eM.getEntities()) {
			if (e.getEntityRect().contains(p) && !e.equals(this)) {
				return true;
			}
		}
		return false;
	}

	private boolean entityEntityCollision(Point p) {
		for (Entity e : eM.getEntities()) {
			if (e.getEntityRect().contains(p) && !e.equals(this)) {
				return true;
			}
		}
		return false;
	}

	private Entity getCollidingEntity() {
		Rectangle bot = new Rectangle((int) x + 2, (int) y + height, width - 4, 10);
		for (Entity e : eM.getEntities()) {
			if (e.getEntityRect().intersects(bot) && !e.equals(this)) {
				return e;
			}
		}
		return null;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void heal() {
		health = maxHealth;
	}

	public void dealDamage(int damage) {
		if (health - damage > 0) {
			health -= damage;
		} else if (health - damage <= 0) {
			die();
		}
	}

	private void die() {
		eM.removeEntity(this);
	}

	public boolean isSliding() {
		return sliding;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
