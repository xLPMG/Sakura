package me.lpmg.sakura.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

import me.lpmg.sakura.gamestate.GameState;
import me.lpmg.sakura.objects.Block;
import me.lpmg.sakura.resources.Animation;
import me.lpmg.sakura.resources.Images;

public class Monster1 implements Entity {

	private Animation animIdleRight, animIdleLeft, animWalkRight, animWalkLeft, animHitRight, animHitLeft, animAttackRight, animAttackLeft, animDeathRight,animDeathLeft;
	private boolean right = false, left = false, falling = true, idleRight = true, idleLeft = false, dying=false, attacking=false;

	private int maxHealth = 2;
	private int health = maxHealth;

	private double x, y;
	private int width, height;
	private double defaultSpeed = 2.4;
	private double moveSpeed = defaultSpeed;

	private double maxFallSpeed = 8;
	private double currentFallSpeed = 0.2;

	private int walkingDirection = 1;

	private boolean rightCol = false;
	private boolean leftCol = false;

	private int walkTick;
	private int deathCountDown = 60;

	private boolean hit = false;
	
	private Entity target = null;

	private EntityManager eM;

	public Monster1(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;

		animIdleRight = new Animation(250, Images.monster1_idle_right,0);
		animIdleLeft = new Animation(250, Images.monster1_idle_left,0);
		animWalkRight = new Animation(160, Images.monster1_walk_right,0);
		animWalkLeft = new Animation(160, Images.monster1_walk_left,0);
		animHitRight = new Animation(150, Images.monster1_hit_right,0);
		animHitLeft = new Animation(150, Images.monster1_hit_left,0);
		//animAttackRight = new Animation(120, Images.monster1_attack_right,0);
		//animAttackLeft = new Animation(120, Images.monster1_attack_left,0);
		animDeathRight = new Animation(40, Images.monster1_death_right,1);
		animDeathLeft = new Animation(40, Images.monster1_death_left,1);
		
		Random rn = new Random();
		walkTick = (rn.nextInt((6 - 1) + 1) + 1)*100;
	}

	public void tick(Block[][] blocks, Block[][] blocks2) {

		walkTick++;

		int iX = (int) x;
		int iY = (int) y;
		rightCol = false;
		leftCol = false;

		move();

		for (int i = 0; i < blocks.length; i++) {
			for (int j = 0; j < blocks[0].length; j++) {
				if (blocks[i][j].isSolid()) {
					// right side
					if (entityBlockEntityCollision(new Point(iX + width + 5, iY + 2), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height - 1), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height / 2 - 1),
									blocks[i][j])) {
						// right = false;
						rightCol = true;
						if(walkingDirection == 1 && !attacking && !dying && entityPlayerCollision(new Point(iX + width + 5, iY + height / 2 - 1))) {
							animAttackRight = new Animation(120, Images.monster1_attack_right,1);
							getCollidingPlayer().dealDamage(1);
							attacking = true;
						}
					}
					// left side
					if (entityBlockEntityCollision(new Point(iX - 5, iY + 2), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height - 1), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height / 2 - 1), blocks[i][j])) {
						// left = false;
						leftCol = true;
						if(walkingDirection == 2 && !attacking && !dying && entityPlayerCollision(new Point(iX - 5, iY + height / 2 - 1))) {
							animAttackLeft = new Animation(120, Images.monster1_attack_left,1);
							getCollidingPlayer().dealDamage(1);
							attacking = true;
						}
					}
					// bottom
					if (entityBlockEntityCollision(new Point(iX + 10, iY + height), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width - 10, iY + height), blocks[i][j])
							|| entityBlockEntityCollision(new Point(iX + width / 2 - 10, iY + height), blocks[i][j])) {
						y = blocks[i][j].getCollisionBounds().getY() - height;
						falling = false;
					}
				}
			}
		}
		for (int i = 0; i < blocks2.length; i++) {
			for (int j = 0; j < blocks2[0].length; j++) {
				if (blocks2[i][j].isSolid()) {
					// right side
					if (entityBlockEntityCollision(new Point(iX + width + 5, iY + 2), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height - 1), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width + 5, iY + height / 2 - 1),
									blocks2[i][j])) {
						// right = false;
						rightCol = true;
						if(walkingDirection == 1 && !attacking && !dying && entityPlayerCollision(new Point(iX + width + 5, iY + height / 2 - 1))) {
							animAttackRight = new Animation(120, Images.monster1_attack_right,1);
							getCollidingPlayer().dealDamage(1);
							attacking = true;
						}
					}
					// left side
					if (entityBlockEntityCollision(new Point(iX - 5, iY + 2), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height - 1), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX - 5, iY + height / 2 - 1), blocks2[i][j])) {
						// left = false;
						leftCol = true;
						if(walkingDirection == 2 && !attacking && !dying && entityPlayerCollision(new Point(iX - 5, iY + height / 2 - 1))) {
							animAttackLeft = new Animation(120, Images.monster1_attack_left,1);
							getCollidingPlayer().dealDamage(1);
							attacking = true;
						}
					}
					// bottom
					if (entityBlockEntityCollision(new Point(iX + 10, iY + height), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width - 10, iY + height), blocks2[i][j])
							|| entityBlockEntityCollision(new Point(iX + width / 2 - 10, iY + height), blocks2[i][j])) {
						y = blocks2[i][j].getCollisionBounds().getY() - height;
						falling = false;
					}
				}
			}
		}
		
		if (right && !rightCol) {
			x += moveSpeed;
		}
		if (left && !leftCol) {
			x -= moveSpeed;
		}
		if (right && rightCol) {
			idleRight = true;
			right=false;
		}
		if (left && leftCol) {
			idleLeft = true;
			left=false;
		}

		if (falling) {
			y += currentFallSpeed;
			if (currentFallSpeed < maxFallSpeed) {
				currentFallSpeed += 0.25;
			}
		} else {
			currentFallSpeed = 0.2;
		}

		if (!right && !left && !falling) {
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
		animWalkRight.tick();
		animWalkLeft.tick();
		animHitRight.tick();
		animHitLeft.tick();
		
		if(attacking) {
			if(animAttackRight!=null) animAttackRight.tick();
			if(animAttackLeft!=null) animAttackLeft.tick();
			
			if((animAttackRight!=null && animAttackRight.hasEnded()) || (animAttackLeft!=null && animAttackLeft.hasEnded())) {
				attacking=false;
				animAttackRight=null;
				animAttackLeft=null;
			}
		}
		
		if(dying&&deathCountDown>0) {
			animDeathRight.tick();
			animDeathLeft.tick();
			
			deathCountDown--;
			if(deathCountDown<=0) {
				eM.removeEntity(this);
			}
		}
		
		if(y>2000) {
			die();
		}
	}

	private void move() {
		if (!falling&&!dying&&!attacking) {
			if (walkTick < 300) {
				left = false;
				right = true;
				walkingDirection = 1;
			} else if (walkTick >= 300 && walkTick < 600) {
				right = false;
				left = true;
				walkingDirection = 2;
			} else {
				walkTick = 0;
			}
		} else if(!attacking&&!dying){
			walkingDirection = 2;
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
//		g.drawRect((int) x - (int) GameState.xOffset, (int) y - (int) GameState.yOffset, width, height);

		if (!hit && !dying && !attacking) {
			if (idleRight) {
				g.drawImage(animIdleRight.getCurrentFrame(), (int) x - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			} else if (idleLeft) {
				g.drawImage(animIdleLeft.getCurrentFrame(), (int) x - 9*3 - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			} else if (right && !falling) {
				g.drawImage(animWalkRight.getCurrentFrame(), (int) x - 0 * 3 - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			} else if (left && !falling) {
				g.drawImage(animWalkLeft.getCurrentFrame(), (int) x - 9 * 3 - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
				// end jumping
			} else if (walkingDirection == 1 && falling) {
				g.drawImage(animIdleRight.getCurrentFrame(), (int) x - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			} else if (walkingDirection == 2 && falling) {
				g.drawImage(animIdleLeft.getCurrentFrame(), (int) x - 9*3 - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			}
		} else if(!dying && attacking){
			if(walkingDirection==1&& animAttackRight!=null) {
				g.drawImage(animAttackRight.getCurrentFrame(), (int) x - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
		  } else if(walkingDirection==2 && animAttackLeft!=null) {
			g.drawImage(animAttackLeft.getCurrentFrame(), (int) x - 9*3 - (int) GameState.xOffset,
					(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			}
		} else if(dying && !attacking){
			if(walkingDirection==1) {
				g.drawImage(animDeathRight.getCurrentFrame(), (int) x - (int) GameState.xOffset,
						(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
		  } else if(walkingDirection==2) {
			g.drawImage(animDeathLeft.getCurrentFrame(), (int) x - 9*3 - (int) GameState.xOffset,
					(int) y - 12 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			}
		}else {
			if (walkingDirection == 1) {
				g.drawImage(animHitRight.getCurrentFrame(), (int) x - 0 * 3 - (int) GameState.xOffset,
						(int) y - 13 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			} else {
				g.drawImage(animHitLeft.getCurrentFrame(), (int) x - 9 * 3 - (int) GameState.xOffset,
						(int) y - 13 * 3 - (int) GameState.yOffset, 32 * 3, 32 * 3, null);
			}
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

	private boolean entityPlayerCollision(Point p) {
		for (Entity e : eM.getEntities()) {
			if (e.getEntityRect().contains(p) && e instanceof Player) {
				return true;
			}
		}
		return false;
	}

	private Entity getCollidingPlayer() {
		Rectangle bot = new Rectangle((int) x - 8, (int) y - 8, width + 16, height + 16);
		for (Entity e : eM.getEntities()) {
			if (e.getEntityRect().intersects(bot) && e instanceof Player) {
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
		hit = true;
		new java.util.Timer().schedule(new java.util.TimerTask() {
			@Override
			public void run() {
				hit = false;
			}
		}, 450);
	}

	private void die() {
		dying=true;
		eM.addDeath();
		//eM.removeEntity(this);
	}

	@Override
	public void drawEntityGUI(Graphics g) {
	
		
	}

}
