package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import obstruct.Castle;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder_Logic;

public class Field implements IRenderable {

	private static int[][] field = { { 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 1, 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 1, 1, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 2, 1, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } };

	public int getTerrain(int x, int y) {
		if (x < 0 || x >= field[0].length || y < 0 || y >= field.length)
			return -3;
		return field[y][x];
	}

	private int getTileIndex(int x, int y) {
		int terrain = getTerrain(x, y);
		if (terrain <= 0 && terrain >= -2)
			return -terrain;
		else
			return 0;
	}

	@Override
	public int getZ() {
		return -9999;
	}

	@Override
	public void draw(GraphicsContext gc) {
		Image bgImg = new Image(ClassLoader.getSystemResource("bgBrick.png").toString());
		gc.drawImage(bgImg, 0, 0);
		for (int x = 0; x < field[0].length; x++) {
			for (int y = 0; y < field.length; y++) {

				if (field[y][x] == 1) {
					Image img = new WritableImage(RenderableHolder_Logic.deadTreeSprite.getPixelReader(),
							getTileIndex(x, y) * 50, 0, 50, 50);
					gc.drawImage(img, x * 50, y * 50);

				} else if (field[y][x] == 2) {
					Image img = new WritableImage(RenderableHolder_Logic.tree1Sprite.getPixelReader(),
							getTileIndex(x, y) * 50, 0, 50, 50);
					gc.drawImage(img, x * 50, y * 50);
				}

			}
		}
	}

	@Override
	public boolean isDestroyed() {
		return false;
	}

}
