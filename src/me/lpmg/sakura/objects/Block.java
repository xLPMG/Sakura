package me.lpmg.sakura.objects;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import me.lpmg.sakura.gamestate.GameState;
import me.lpmg.sakura.resources.Animation;
import me.lpmg.sakura.resources.Images;

public class Block extends Rectangle {

	public static final int blockSize = 64;
	public int blockWidth = blockSize;
	public int blockHeight = blockSize;
	private int id;
	private boolean isSolid;
	private ArrayList<Integer> nonSolid;
	private Rectangle collisionBounds;
	private Animation portal, portal_cl;

	public Block(int x, int y, int id) {
		setBounds(x,y,blockWidth,blockHeight);
		this.id = id;
		nonSolid = new ArrayList<Integer>();
		loadAttributes();
	}

	public void tick() {
	}

	public void draw(Graphics g) {
		if (id != 49) {			
			if (id ==500) {
				portal.tick();
				System.out.println("port");
				g.drawImage(portal.getCurrentFrame(), x -32 - (int) GameState.xOffset, y - (int) GameState.yOffset, blockWidth*3,
						blockHeight*3, null);	
			}else if (id ==600) {
				portal_cl.tick();
				g.drawImage(portal_cl.getCurrentFrame(), x -32 - (int) GameState.xOffset, y - (int) GameState.yOffset, blockWidth*3,
						blockHeight*3, null);	
			}else {
				g.drawImage(Images.blocks[id], x - (int) GameState.xOffset, y - (int) GameState.yOffset, blockWidth,
						blockHeight, null);		
//				g.setColor(Color.RED);
//				if(isSolid) {
//				g.drawRect(getCollisionBounds().x- (int) GameState.xOffset,getCollisionBounds().y - (int) GameState.yOffset,getCollisionBounds().width,getCollisionBounds().height);
//				}
			}
		}
	}
	
	private void loadAttributes() {
		collisionBounds = new Rectangle(x, y, blockWidth, blockHeight);
		if (id == 35) {
			collisionBounds.y+=44;
			collisionBounds.height-=44;
			collisionBounds.width-=40;
		}else if (id == 52) {
			collisionBounds.y+=18;
			collisionBounds.height-=18;
			collisionBounds.x+=10;
			collisionBounds.width-=10;
		}else if (id == 53) {
			collisionBounds.width-=35;
		}else if (id == 138||id ==139||id ==140||id ==141||id ==142||id == 216||id ==217||id ==218||id ==219||id ==220) {
			collisionBounds.height-=40;
		}
		else if (id == 127 || id == 109 || id==90 || id==127) {
			collisionBounds.x+=32;
			collisionBounds.width-=32;
			//bush
		}else if (id == 47) {
			collisionBounds.y+=52;
			collisionBounds.height-=12;
		}else if (id == 64) {
			collisionBounds.x+=16;
			collisionBounds.width-=16;
		}else if (id == 66) {
			collisionBounds.width-=32;
		}

		nonSolid.add(49);// air
		nonSolid.add(34);
		//grass
		nonSolid.add(36);
		nonSolid.add(37);
		nonSolid.add(38);
		nonSolid.add(39);
		nonSolid.add(40);
		nonSolid.add(41);
		nonSolid.add(42);
		nonSolid.add(43);
		nonSolid.add(44);
		nonSolid.add(45);
		nonSolid.add(54);
		nonSolid.add(55);
		nonSolid.add(58);
		nonSolid.add(60);
		nonSolid.add(61);
		
		nonSolid.add(162);
		nonSolid.add(163);
		nonSolid.add(164);
		nonSolid.add(165);
		nonSolid.add(166);
		nonSolid.add(167);
		nonSolid.add(180);
		nonSolid.add(181);
		nonSolid.add(182);
		nonSolid.add(183);
		nonSolid.add(184);
		nonSolid.add(185);
		//bush
		nonSolid.add(46);
		nonSolid.add(48);
		//small tree
		nonSolid.add(108);
		nonSolid.add(110);
		nonSolid.add(126);
		nonSolid.add(128);
		nonSolid.add(111);
		//big tree
		nonSolid.add(221);
		nonSolid.add(222);
		nonSolid.add(226);
		nonSolid.add(227);
		
		nonSolid.add(500);
		nonSolid.add(999);
		
		portal = new Animation(200, Images.portal,0);
		portal_cl = new Animation(150, Images.portal_cl,1);
		
		// nonSolid.add(36);
		// nonSolid.add(53);
		// nonSolid.add(54);

		if (nonSolid.contains(id)) {
			isSolid = false;
		} else {
			isSolid = true;
		}
	}

	public boolean isSolid() {
		return isSolid;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return id;
	}

	public Rectangle getCollisionBounds() {
		return collisionBounds;
	}

}
