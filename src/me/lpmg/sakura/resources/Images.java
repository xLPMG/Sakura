package me.lpmg.sakura.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.lpmg.sakura.gfx.SpriteSheet;

public class Images {

	private final int tileSize = 16;

	SpriteSheet tilesheet;
	public static BufferedImage[] blocks;
	public static BufferedImage background_0, background_1, background_2, background_underground;

	public static BufferedImage[] player_idle_right, player_idle_left, player_run_right, player_run_left,
			player_jump_crouch_right, player_jumping_right, player_jump_end_right, player_jump_crouch_left,
			player_jumping_left, player_jump_end_left, player_falling_right, player_falling_left, player_slide_right,player_slide_left;
	public static BufferedImage[] player_health_3, player_health_2, player_health_1;

	public static BufferedImage[] monster1_walk_right, monster1_walk_left, monster1_hit_right, monster1_hit_left,
			monster1_idle_right, monster1_idle_left, monster1_attack_right, monster1_attack_left, monster1_death_right, monster1_death_left;

	public static BufferedImage[] portal, portal_cl;

	public Images() {
		blocks = new BufferedImage[2048];

		player_idle_right = new BufferedImage[4];
		player_idle_left = new BufferedImage[4];
		player_run_right = new BufferedImage[6];
		player_run_left = new BufferedImage[6];
		player_jump_crouch_right = new BufferedImage[2];
		player_jumping_right = new BufferedImage[1];
		player_jump_end_right = new BufferedImage[1];
		player_jump_crouch_left = new BufferedImage[2];
		player_jumping_left = new BufferedImage[1];
		player_jump_end_left = new BufferedImage[1];
		player_falling_right = new BufferedImage[2];
		player_falling_left = new BufferedImage[2];
		player_slide_right = new BufferedImage[2];
		player_slide_left = new BufferedImage[2];
		
		player_health_3= new BufferedImage[1];
		player_health_2= new BufferedImage[1];
		player_health_1= new BufferedImage[1];

		monster1_idle_right = new BufferedImage[11];
		monster1_idle_left = new BufferedImage[11];
		monster1_walk_right = new BufferedImage[8];
		monster1_walk_left = new BufferedImage[8];

		monster1_hit_right = new BufferedImage[3];
		monster1_hit_left = new BufferedImage[3];
		
		monster1_attack_right = new BufferedImage[8];
		monster1_attack_left = new BufferedImage[8];
		
		monster1_death_right = new BufferedImage[12];
		monster1_death_left = new BufferedImage[12];
		

		portal = new BufferedImage[8];
		portal_cl = new BufferedImage[7];
		try {
			tilesheet = new SpriteSheet(ImageIO.read(getClass().getResourceAsStream("/blocks/platformer_tileset.png")));

			blocks[0] = tilesheet.crop(tileSize * 0, tileSize * 0, tileSize, tileSize);
			blocks[1] = tilesheet.crop(tileSize * 1, tileSize * 0, tileSize, tileSize);
			blocks[2] = tilesheet.crop(tileSize * 2, tileSize * 0, tileSize, tileSize);
			blocks[3] = tilesheet.crop(tileSize * 3, tileSize * 0, tileSize, tileSize);
			blocks[4] = tilesheet.crop(tileSize * 4, tileSize * 0, tileSize, tileSize);
			blocks[5] = tilesheet.crop(tileSize * 5, tileSize * 0, tileSize, tileSize);
			blocks[6] = tilesheet.crop(tileSize * 6, tileSize * 0, tileSize, tileSize);
			blocks[7] = tilesheet.crop(tileSize * 7, tileSize * 0, tileSize, tileSize);
			blocks[8] = tilesheet.crop(tileSize * 8, tileSize * 0, tileSize, tileSize);
			blocks[9] = tilesheet.crop(tileSize * 9, tileSize * 0, tileSize, tileSize);
			blocks[10] = tilesheet.crop(tileSize * 10, tileSize * 0, tileSize, tileSize);
			blocks[11] = tilesheet.crop(tileSize * 11, tileSize * 0, tileSize, tileSize);
			blocks[12] = tilesheet.crop(tileSize * 12, tileSize * 0, tileSize, tileSize);
			blocks[13] = tilesheet.crop(tileSize * 13, tileSize * 0, tileSize, tileSize);
			blocks[14] = tilesheet.crop(tileSize * 14, tileSize * 0, tileSize, tileSize);
			blocks[15] = tilesheet.crop(tileSize * 15, tileSize * 0, tileSize, tileSize);
			blocks[16] = tilesheet.crop(tileSize * 16, tileSize * 0, tileSize, tileSize);
			blocks[17] = tilesheet.crop(tileSize * 17, tileSize * 0, tileSize, tileSize);
			blocks[18] = tilesheet.crop(tileSize * 0, tileSize * 1, tileSize, tileSize);
			blocks[19] = tilesheet.crop(tileSize * 1, tileSize * 1, tileSize, tileSize);
			blocks[20] = tilesheet.crop(tileSize * 2, tileSize * 1, tileSize, tileSize);
			blocks[21] = tilesheet.crop(tileSize * 3, tileSize * 1, tileSize, tileSize);
			blocks[22] = tilesheet.crop(tileSize * 4, tileSize * 1, tileSize, tileSize);
			blocks[23] = tilesheet.crop(tileSize * 5, tileSize * 1, tileSize, tileSize);
			blocks[24] = tilesheet.crop(tileSize * 6, tileSize * 1, tileSize, tileSize);
			blocks[25] = tilesheet.crop(tileSize * 7, tileSize * 1, tileSize, tileSize);
			blocks[26] = tilesheet.crop(tileSize * 8, tileSize * 1, tileSize, tileSize);
			blocks[27] = tilesheet.crop(tileSize * 9, tileSize * 1, tileSize, tileSize);
			blocks[28] = tilesheet.crop(tileSize * 10, tileSize * 1, tileSize, tileSize);
			blocks[29] = tilesheet.crop(tileSize * 11, tileSize * 1, tileSize, tileSize);
			blocks[30] = tilesheet.crop(tileSize * 12, tileSize * 1, tileSize, tileSize);
			blocks[31] = tilesheet.crop(tileSize * 13, tileSize * 1, tileSize, tileSize);
			blocks[32] = tilesheet.crop(tileSize * 14, tileSize * 1, tileSize, tileSize);
			blocks[33] = tilesheet.crop(tileSize * 15, tileSize * 1, tileSize, tileSize);

			//solid air
			blocks[94] = tilesheet.crop(tileSize * 4, tileSize * 5, tileSize, tileSize);
			// grass
			blocks[36] = tilesheet.crop(tileSize * 0, tileSize * 2, tileSize, tileSize);
			blocks[37] = tilesheet.crop(tileSize * 1, tileSize * 2, tileSize, tileSize);
			blocks[40] = tilesheet.crop(tileSize * 4, tileSize * 2, tileSize, tileSize);
			blocks[41] = tilesheet.crop(tileSize * 5, tileSize * 2, tileSize, tileSize);
			blocks[42] = tilesheet.crop(tileSize * 6, tileSize * 2, tileSize, tileSize);
			blocks[43] = tilesheet.crop(tileSize * 7, tileSize * 2, tileSize, tileSize);
			blocks[54] = tilesheet.crop(tileSize * 0, tileSize * 3, tileSize, tileSize);
			blocks[55] = tilesheet.crop(tileSize * 1, tileSize * 3, tileSize, tileSize);
			blocks[58] = tilesheet.crop(tileSize * 4, tileSize * 3, tileSize, tileSize);
			blocks[59] = tilesheet.crop(tileSize * 5, tileSize * 3, tileSize, tileSize);
			blocks[60] = tilesheet.crop(tileSize * 6, tileSize * 3, tileSize, tileSize);
			blocks[61] = tilesheet.crop(tileSize * 7, tileSize * 3, tileSize, tileSize);
			blocks[76] = tilesheet.crop(tileSize * 4, tileSize * 4, tileSize, tileSize);
			blocks[77] = tilesheet.crop(tileSize * 5, tileSize * 4, tileSize, tileSize);

			// flowers
			blocks[38] = tilesheet.crop(tileSize * 2, tileSize * 2, tileSize, tileSize);
			blocks[39] = tilesheet.crop(tileSize * 3, tileSize * 2, tileSize, tileSize);
			blocks[56] = tilesheet.crop(tileSize * 2, tileSize * 3, tileSize, tileSize);
			blocks[57] = tilesheet.crop(tileSize * 3, tileSize * 3, tileSize, tileSize);
			blocks[45] = tilesheet.crop(tileSize * 8, tileSize * 2, tileSize, tileSize);
			blocks[46] = tilesheet.crop(tileSize * 8, tileSize * 2, tileSize, tileSize);

			// rocks
			blocks[34] = tilesheet.crop(tileSize * 16, tileSize * 1, tileSize, tileSize); // 35
			blocks[35] = tilesheet.crop(tileSize * 17, tileSize * 1, tileSize, tileSize); // 36
			blocks[52] = tilesheet.crop(tileSize * 16, tileSize * 2, tileSize, tileSize); // 53
			blocks[53] = tilesheet.crop(tileSize * 17, tileSize * 2, tileSize, tileSize); // 54
			blocks[62] = tilesheet.crop(tileSize * 8, tileSize * 3, tileSize, tileSize); // 63

			// bush
			blocks[46] = tilesheet.crop(tileSize * 10, tileSize * 2, tileSize, tileSize);
			blocks[47] = tilesheet.crop(tileSize * 11, tileSize * 2, tileSize, tileSize);
			blocks[64] = tilesheet.crop(tileSize * 10, tileSize * 3, tileSize, tileSize);
			blocks[65] = tilesheet.crop(tileSize * 11, tileSize * 3, tileSize, tileSize);
			blocks[66] = tilesheet.crop(tileSize * 12, tileSize * 3, tileSize, tileSize);
			blocks[51] = tilesheet.crop(tileSize * 15, tileSize * 2, tileSize, tileSize);
			blocks[67] = tilesheet.crop(tileSize * 13, tileSize * 3, tileSize, tileSize);
			blocks[68] = tilesheet.crop(tileSize * 14, tileSize * 3, tileSize, tileSize);
			blocks[69] = tilesheet.crop(tileSize * 15, tileSize * 3, tileSize, tileSize);
			blocks[70] = tilesheet.crop(tileSize * 16, tileSize * 3, tileSize, tileSize);
			blocks[71] = tilesheet.crop(tileSize * 17, tileSize * 3, tileSize, tileSize);

			//small tree
			blocks[72] = tilesheet.crop(tileSize * 0, tileSize * 4, tileSize, tileSize);
			blocks[73] = tilesheet.crop(tileSize * 1, tileSize * 4, tileSize, tileSize);
			blocks[74] = tilesheet.crop(tileSize * 2, tileSize * 4, tileSize, tileSize);
			blocks[75] = tilesheet.crop(tileSize * 3, tileSize * 4, tileSize, tileSize);
			blocks[90] = tilesheet.crop(tileSize * 0, tileSize * 5, tileSize, tileSize);
			blocks[91] = tilesheet.crop(tileSize * 1, tileSize * 5, tileSize, tileSize);
			blocks[92] = tilesheet.crop(tileSize * 2, tileSize * 5, tileSize, tileSize);
			blocks[93] = tilesheet.crop(tileSize * 3, tileSize * 5, tileSize, tileSize);
			blocks[108] = tilesheet.crop(tileSize * 0, tileSize * 6, tileSize, tileSize);
			blocks[109] = tilesheet.crop(tileSize * 1, tileSize * 6, tileSize, tileSize);
			blocks[110] = tilesheet.crop(tileSize * 2, tileSize * 6, tileSize, tileSize);
			blocks[111] = tilesheet.crop(tileSize * 3, tileSize * 6, tileSize, tileSize);
			blocks[126] = tilesheet.crop(tileSize * 0, tileSize * 7, tileSize, tileSize);
			blocks[127] = tilesheet.crop(tileSize * 1, tileSize * 7, tileSize, tileSize);
			blocks[128] = tilesheet.crop(tileSize * 2, tileSize * 7, tileSize, tileSize);
			blocks[129] = tilesheet.crop(tileSize * 3, tileSize * 7, tileSize, tileSize);
			
			//big tree
			blocks[79] = tilesheet.crop(tileSize * 7, tileSize * 4, tileSize, tileSize);
			blocks[80] = tilesheet.crop(tileSize * 8, tileSize * 4, tileSize, tileSize);
			blocks[81] = tilesheet.crop(tileSize * 9, tileSize * 4, tileSize, tileSize);
			blocks[96] = tilesheet.crop(tileSize * 6, tileSize * 5, tileSize, tileSize);
			blocks[97] = tilesheet.crop(tileSize * 7, tileSize * 5, tileSize, tileSize);
			blocks[98] = tilesheet.crop(tileSize * 8, tileSize * 5, tileSize, tileSize);
			blocks[99] = tilesheet.crop(tileSize * 9, tileSize * 5, tileSize, tileSize);
			blocks[100] = tilesheet.crop(tileSize * 10, tileSize * 5, tileSize, tileSize);			
			blocks[113] = tilesheet.crop(tileSize * 5, tileSize * 6, tileSize, tileSize);
			blocks[114] = tilesheet.crop(tileSize * 6, tileSize * 6, tileSize, tileSize);
			blocks[115] = tilesheet.crop(tileSize * 7, tileSize * 6, tileSize, tileSize);
			blocks[116] = tilesheet.crop(tileSize * 8, tileSize * 6, tileSize, tileSize);
			blocks[117] = tilesheet.crop(tileSize * 9, tileSize * 6, tileSize, tileSize);
			blocks[118] = tilesheet.crop(tileSize * 10, tileSize * 6, tileSize, tileSize);
			blocks[119] = tilesheet.crop(tileSize * 11, tileSize * 6, tileSize, tileSize);			
			blocks[131] = tilesheet.crop(tileSize * 5, tileSize * 7, tileSize, tileSize);
			blocks[132] = tilesheet.crop(tileSize * 6, tileSize * 7, tileSize, tileSize);
			blocks[133] = tilesheet.crop(tileSize * 7, tileSize * 7, tileSize, tileSize);
			blocks[134] = tilesheet.crop(tileSize * 8, tileSize * 7, tileSize, tileSize);
			blocks[135] = tilesheet.crop(tileSize * 9, tileSize * 7, tileSize, tileSize);
			blocks[136] = tilesheet.crop(tileSize * 10, tileSize * 7, tileSize, tileSize);
			blocks[137] = tilesheet.crop(tileSize * 11, tileSize * 7, tileSize, tileSize);			
			blocks[149] = tilesheet.crop(tileSize * 5, tileSize * 8, tileSize, tileSize);
			blocks[150] = tilesheet.crop(tileSize * 6, tileSize * 8, tileSize, tileSize);
			blocks[151] = tilesheet.crop(tileSize * 7, tileSize * 8, tileSize, tileSize);
			blocks[152] = tilesheet.crop(tileSize * 8, tileSize * 8, tileSize, tileSize);
			blocks[153] = tilesheet.crop(tileSize * 9, tileSize * 8, tileSize, tileSize);
			blocks[154] = tilesheet.crop(tileSize * 10, tileSize * 8, tileSize, tileSize);			
			blocks[168] = tilesheet.crop(tileSize * 6, tileSize * 9, tileSize, tileSize);
			blocks[169] = tilesheet.crop(tileSize * 7, tileSize * 9, tileSize, tileSize);
			blocks[170] = tilesheet.crop(tileSize * 8, tileSize * 9, tileSize, tileSize);
			blocks[171] = tilesheet.crop(tileSize * 9, tileSize * 9, tileSize, tileSize);
			blocks[172] = tilesheet.crop(tileSize * 10, tileSize * 9, tileSize, tileSize);		
			blocks[187] = tilesheet.crop(tileSize * 7, tileSize * 10, tileSize, tileSize);
			blocks[188] = tilesheet.crop(tileSize * 8, tileSize * 10, tileSize, tileSize);
			blocks[189] = tilesheet.crop(tileSize * 9, tileSize * 10, tileSize, tileSize);
			blocks[190] = tilesheet.crop(tileSize * 10, tileSize * 10, tileSize, tileSize);
			blocks[205] = tilesheet.crop(tileSize * 7, tileSize * 11, tileSize, tileSize);
			blocks[206] = tilesheet.crop(tileSize * 8, tileSize * 11, tileSize, tileSize);
			blocks[207] = tilesheet.crop(tileSize * 9, tileSize * 11, tileSize, tileSize);		
			blocks[221] = tilesheet.crop(tileSize * 5, tileSize * 12, tileSize, tileSize);
			blocks[222] = tilesheet.crop(tileSize * 6, tileSize * 12, tileSize, tileSize);
			blocks[223] = tilesheet.crop(tileSize * 7, tileSize * 12, tileSize, tileSize);
			blocks[224] = tilesheet.crop(tileSize * 8, tileSize * 12, tileSize, tileSize);
			blocks[225] = tilesheet.crop(tileSize * 9, tileSize * 12, tileSize, tileSize);
			blocks[226] = tilesheet.crop(tileSize * 10, tileSize * 12, tileSize, tileSize);
			blocks[227] = tilesheet.crop(tileSize * 11, tileSize * 12, tileSize, tileSize);			
			// BRETT
			blocks[138] = tilesheet.crop(tileSize * 12, tileSize * 7, tileSize, tileSize);
			blocks[139] = tilesheet.crop(tileSize * 13, tileSize * 7, tileSize, tileSize);
			blocks[140] = tilesheet.crop(tileSize * 14, tileSize * 7, tileSize, tileSize);
			blocks[141] = tilesheet.crop(tileSize * 15, tileSize * 7, tileSize, tileSize);
			blocks[142] = tilesheet.crop(tileSize * 16, tileSize * 7, tileSize, tileSize);
			blocks[123] = tilesheet.crop(tileSize * 15, tileSize * 6, tileSize, tileSize);
			blocks[124] = tilesheet.crop(tileSize * 16, tileSize * 6, tileSize, tileSize);
			//cave
			blocks[144] = tilesheet.crop(tileSize * 0, tileSize * 8, tileSize, tileSize);
			blocks[145] = tilesheet.crop(tileSize * 1, tileSize * 8, tileSize, tileSize);
			blocks[146] = tilesheet.crop(tileSize * 2, tileSize * 8, tileSize, tileSize);
			blocks[147] = tilesheet.crop(tileSize * 3, tileSize * 8, tileSize, tileSize);
			blocks[148] = tilesheet.crop(tileSize * 4, tileSize * 8, tileSize, tileSize);
			
			blocks[162] = tilesheet.crop(tileSize * 0, tileSize * 9, tileSize, tileSize);
			blocks[163] = tilesheet.crop(tileSize * 1, tileSize * 9, tileSize, tileSize);
			blocks[164] = tilesheet.crop(tileSize * 2, tileSize * 9, tileSize, tileSize);
			blocks[165] = tilesheet.crop(tileSize * 3, tileSize * 9, tileSize, tileSize);
			blocks[166] = tilesheet.crop(tileSize * 4, tileSize * 9, tileSize, tileSize);
			blocks[167] = tilesheet.crop(tileSize * 5, tileSize * 9, tileSize, tileSize);
			
			blocks[180] = tilesheet.crop(tileSize * 0, tileSize * 10, tileSize, tileSize);
			blocks[181] = tilesheet.crop(tileSize * 1, tileSize * 10, tileSize, tileSize);
			blocks[182] = tilesheet.crop(tileSize * 2, tileSize * 10, tileSize, tileSize);
			blocks[183] = tilesheet.crop(tileSize * 3, tileSize * 10, tileSize, tileSize);
			blocks[184] = tilesheet.crop(tileSize * 4, tileSize * 10, tileSize, tileSize);
			blocks[185] = tilesheet.crop(tileSize * 5, tileSize * 10, tileSize, tileSize);
			
			blocks[198] = tilesheet.crop(tileSize * 0, tileSize * 11, tileSize, tileSize);
			blocks[199] = tilesheet.crop(tileSize * 1, tileSize * 11, tileSize, tileSize);
			blocks[200] = tilesheet.crop(tileSize * 2, tileSize * 11, tileSize, tileSize);
			blocks[201] = tilesheet.crop(tileSize * 3, tileSize * 11, tileSize, tileSize);
			blocks[202] = tilesheet.crop(tileSize * 4, tileSize * 11, tileSize, tileSize);
			blocks[203] = tilesheet.crop(tileSize * 5, tileSize * 11, tileSize, tileSize);
			blocks[204] = tilesheet.crop(tileSize * 6, tileSize * 11, tileSize, tileSize);
			
			blocks[216] = tilesheet.crop(tileSize * 0, tileSize * 12, tileSize, tileSize);
			blocks[217] = tilesheet.crop(tileSize * 1, tileSize * 12, tileSize, tileSize);
			blocks[218] = tilesheet.crop(tileSize * 2, tileSize * 12, tileSize, tileSize);
			blocks[219] = tilesheet.crop(tileSize * 3, tileSize * 12, tileSize, tileSize);
			blocks[220] = tilesheet.crop(tileSize * 4, tileSize * 12, tileSize, tileSize);
			// portal
			blocks[500] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_1.png"));
			blocks[501] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_2.png"));
			blocks[502] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_3.png"));
			blocks[503] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_4.png"));
			blocks[504] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_5.png"));
			blocks[505] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_6.png"));
			blocks[506] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_7.png"));
			blocks[507] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_8.png"));
			portal[0] = blocks[500];
			portal[1] = blocks[501];
			portal[2] = blocks[502];
			portal[3] = blocks[503];
			portal[4] = blocks[504];
			portal[5] = blocks[505];
			portal[6] = blocks[506];
			portal[7] = blocks[507];
			blocks[999] = tilesheet.crop(tileSize * 10, tileSize * 4, tileSize, tileSize);
			// portal closing
			blocks[600] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_1.png"));
			blocks[601] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_2.png"));
			blocks[602] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_3.png"));
			blocks[603] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_4.png"));
			blocks[604] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_5.png"));
			blocks[605] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_6.png"));
			blocks[606] = ImageIO.read(getClass().getResourceAsStream("/blocks/portal_cl_7.png"));
			portal_cl[0] = blocks[600];
			portal_cl[1] = blocks[601];
			portal_cl[2] = blocks[602];
			portal_cl[3] = blocks[603];
			portal_cl[4] = blocks[604];
			portal_cl[5] = blocks[605];
			portal_cl[6] = blocks[606];

			background_0 = ImageIO.read(getClass().getResourceAsStream("/background/background_0.png"));
			background_1 = ImageIO.read(getClass().getResourceAsStream("/background/background_1.png"));
			background_2 = ImageIO.read(getClass().getResourceAsStream("/background/background_2.png"));
			background_underground = ImageIO
					.read(getClass().getResourceAsStream("/background/background_underground.png"));

			player_idle_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-right-00.png"));
			player_idle_right[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-right-01.png"));
			player_idle_right[2] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-right-02.png"));
			player_idle_right[3] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-right-03.png"));

			player_idle_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-left-00.png"));
			player_idle_left[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-left-01.png"));
			player_idle_left[2] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-left-02.png"));
			player_idle_left[3] = ImageIO.read(getClass().getResourceAsStream("/adventurer-idle-left-03.png"));

			player_run_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-00.png"));
			player_run_right[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-01.png"));
			player_run_right[2] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-02.png"));
			player_run_right[3] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-03.png"));
			player_run_right[4] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-04.png"));
			player_run_right[5] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-right-05.png"));

			player_run_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-00.png"));
			player_run_left[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-01.png"));
			player_run_left[2] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-02.png"));
			player_run_left[3] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-03.png"));
			player_run_left[4] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-04.png"));
			player_run_left[5] = ImageIO.read(getClass().getResourceAsStream("/adventurer-run-left-05.png"));

			player_jump_crouch_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-right-00.png"));
			player_jump_crouch_right[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-right-01.png"));
			player_jumping_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-right-02.png"));
			player_jump_end_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-right-03.png"));

			player_jump_crouch_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-left-00.png"));
			player_jump_crouch_left[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-left-01.png"));
			player_jumping_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-left-02.png"));
			player_jump_end_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-jump-left-03.png"));

			player_falling_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-fall-right-00.png"));
			player_falling_right[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-fall-right-01.png"));

			player_falling_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-fall-left-00.png"));
			player_falling_left[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-fall-left-01.png"));
			
			player_slide_right[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-slide-right-00.png"));
			player_slide_right[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-slide-right-01.png"));

			player_slide_left[0] = ImageIO.read(getClass().getResourceAsStream("/adventurer-slide-left-00.png"));
			player_slide_left[1] = ImageIO.read(getClass().getResourceAsStream("/adventurer-slide-left-01.png"));

			player_health_3[0]= ImageIO.read(getClass().getResourceAsStream("/gui/3_hearts.png"));
			player_health_2[0]= ImageIO.read(getClass().getResourceAsStream("/gui/2_hearts.png"));
			player_health_1[0]= ImageIO.read(getClass().getResourceAsStream("/gui/1_hearts.png"));
			// monster1
			monster1_walk_right[0] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_1.png"));
			monster1_walk_right[1] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_2.png"));
			monster1_walk_right[2] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_3.png"));
			monster1_walk_right[3] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_4.png"));
			monster1_walk_right[4] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_5.png"));
			monster1_walk_right[5] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_6.png"));
			monster1_walk_right[6] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_7.png"));
			monster1_walk_right[7] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/walk_right_8.png"));

			monster1_walk_left[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_1.png"));
			monster1_walk_left[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_2.png"));
			monster1_walk_left[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_3.png"));
			monster1_walk_left[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_4.png"));
			monster1_walk_left[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_5.png"));
			monster1_walk_left[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_6.png"));
			monster1_walk_left[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_7.png"));
			monster1_walk_left[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/walk_left_8.png"));

			monster1_hit_right[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_right_1.png"));
			monster1_hit_right[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_right_2.png"));
			monster1_hit_right[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_right_3.png"));

			monster1_hit_left[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_left_1.png"));
			monster1_hit_left[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_left_2.png"));
			monster1_hit_left[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/hit_left_3.png"));

			monster1_idle_right[0] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_1.png"));
			monster1_idle_right[1] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_2.png"));
			monster1_idle_right[2] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_3.png"));
			monster1_idle_right[3] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_4.png"));
			monster1_idle_right[4] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_5.png"));
			monster1_idle_right[5] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_6.png"));
			monster1_idle_right[6] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_7.png"));
			monster1_idle_right[7] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_8.png"));
			monster1_idle_right[8] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_9.png"));
			monster1_idle_right[9] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_10.png"));
			monster1_idle_right[10] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_right_11.png"));

			monster1_idle_left[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_1.png"));
			monster1_idle_left[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_2.png"));
			monster1_idle_left[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_3.png"));
			monster1_idle_left[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_4.png"));
			monster1_idle_left[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_5.png"));
			monster1_idle_left[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_6.png"));
			monster1_idle_left[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_7.png"));
			monster1_idle_left[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_8.png"));
			monster1_idle_left[8] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_9.png"));
			monster1_idle_left[9] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/idle_left_10.png"));
			monster1_idle_left[10] = ImageIO
					.read(getClass().getResourceAsStream("/entities/monster1/idle_left_11.png"));
			
			monster1_attack_right[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_1.png"));
			monster1_attack_right[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_2.png"));
			monster1_attack_right[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_3.png"));
			monster1_attack_right[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_4.png"));
			monster1_attack_right[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_5.png"));
			monster1_attack_right[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_6.png"));
			monster1_attack_right[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_7.png"));
			monster1_attack_right[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_right_8.png"));
			
			monster1_attack_left[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_1.png"));
			monster1_attack_left[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_2.png"));
			monster1_attack_left[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_3.png"));
			monster1_attack_left[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_4.png"));
			monster1_attack_left[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_5.png"));
			monster1_attack_left[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_6.png"));
			monster1_attack_left[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_7.png"));
			monster1_attack_left[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/attack_left_8.png"));
			
			monster1_death_right[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_1.png"));
			monster1_death_right[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_2.png"));
			monster1_death_right[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_3.png"));
			monster1_death_right[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_4.png"));
			monster1_death_right[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_5.png"));
			monster1_death_right[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_6.png"));
			monster1_death_right[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_7.png"));
			monster1_death_right[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_8.png"));
			monster1_death_right[8] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_9.png"));
			monster1_death_right[9] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_10.png"));
			monster1_death_right[10] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_11.png"));
			monster1_death_right[11] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_right_12.png"));
			
			monster1_death_left[0] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_1.png"));
			monster1_death_left[1] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_2.png"));
			monster1_death_left[2] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_3.png"));
			monster1_death_left[3] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_4.png"));
			monster1_death_left[4] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_5.png"));
			monster1_death_left[5] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_6.png"));
			monster1_death_left[6] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_7.png"));
			monster1_death_left[7] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_8.png"));
			monster1_death_left[8] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_9.png"));
			monster1_death_left[9] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_10.png"));
			monster1_death_left[10] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_11.png"));
			monster1_death_left[11] = ImageIO.read(getClass().getResourceAsStream("/entities/monster1/death_left_12.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
