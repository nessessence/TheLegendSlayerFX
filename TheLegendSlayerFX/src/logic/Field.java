package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import obstruct.Castle;
import sharedObject.IRenderable;
import sharedObject.RenderableHolder;

public class Field implements IRenderable {

	private static int[][] field = { {0,0,0,0,0,0,6,6,6,6,0,0,0,0,0,0 },
			   {0,0,0,0,0,0,6,6,6,6,1,1,0,0,0,0},
			   {0,0,0,0,0,0,6,6,6,6,6,1,0,0,0,0},
			   {0,0,0,0,0,0,6,6,6,6,6,1,1,1,1,0},
			   {0,0,0,0,0,0,6,6,6,0,0,0,0,6,1,0},
			   {0,0,0,8,0,0,0,0,0,0,0,0,0,6,6,0},
			   {0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,0},
			   {0,0,0,0,0,0,0,0,0,0,0,0,0,6,6,0},
			   {0,0,0,0,0,0,0,0,0,0,6,6,6,6,6,0},
			   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			   {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0} };
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

//	@Override
//	public void draw(GraphicsContext gc) {
//		for (int x = 0; x <= field[0].length; x++) {
//			for (int y = 0; y <= field.length; y++) {
//				WritableImage croppedImage = new WritableImage(RenderableHolder.mapSprite.getPixelReader(),
//						getTileIndex(x, y) * 64, 0, 64, 64);
//				gc.drawImage(croppedImage, x * 64, y * 64);
//			}
//		}
//	}
	@Override
    public void draw(GraphicsContext gc) {
        Image bgImg = new Image(ClassLoader.getSystemResource("bgBrick.png").toString()) ;
        gc.drawImage(bgImg, 0, 0);
		for (int x = 0; x < field[0].length; x++) {
            for (int y = 0; y < field.length; y++) {
//                
////            	if(field[y][x] == 0) {	
////            		 img = new WritableImage(RenderableHolder.mapSprite.getPixelReader(),getTileIndex(x,y)*50,0,50,50);
////                } else {
//                if(field[y][x] == 1 ) {
//                	 Image img = new WritableImage(RenderableHolder.deadTreeSprite.getPixelReader(),getTileIndex(x,y)*50,0,50,50);
//                	 gc.drawImage(img,x*50,y*50);
//                }else if(field[y][x] == 2) {
//                	Image img = new WritableImage(RenderableHolder.pondSprite.getPixelReader(),getTileIndex(x,y)*50,0,210,200);
//                	gc.drawImage(img, x*50, y*50);
//                }
//                else if(field[y][x] == 3) {
//                	Image img = new Image(ClassLoader.getSystemResource("castle.gif").toString()) ;
//                	gc.drawImage(img, x*50, y*50);
//                }else if(field[y][x] == 4) {
//                	Image img = new Image(ClassLoader.getSystemResource("enemycastle.png").toString()) ;
//                	gc.drawImage(img, x*50, y*50);
//                }else if(field[y][x] == 5) {
//                	Image img = new WritableImage(RenderableHolder.barbewireSprite.getPixelReader(),getTileIndex(x,y)*50,0,86,50);
//                	gc.drawImage(img,x*50,y*50);
//                }else if(field[y][x] == 6) {
//                	Image img = new WritableImage(RenderableHolder.tree1Sprite.getPixelReader(),getTileIndex(x,y)*50,0,50,50);
//                	gc.drawImage(img,x*50,y*50);
//                }else if(field[y][x] == 7){
//                	Image img = new Image(ClassLoader.getSystemResource("antena.png").toString()) ;
//                	gc.drawImage(img,x*50,y*50);
//                }else if(field[y][x] == 8) {
//                	Image img = new WritableImage(RenderableHolder.cannonSprite.getPixelReader(),getTileIndex(x,y)*50,0,100,100);
//                	gc.drawImage(img,x*50,y*50);
//                }
////            
            	
               if(field[y][x] == 1 ) {
               	 Image img = new WritableImage(RenderableHolder.deadTreeSprite.getPixelReader(),getTileIndex(x,y)*50,0,50,50);
               	 gc.drawImage(img,x*50,y*50);
               }else if(field[y][x] == 2) {
               	Image img = new WritableImage(RenderableHolder.pondSprite.getPixelReader(),getTileIndex(x,y)*50,0,210,200);
               	gc.drawImage(img, x*50, y*50);
               }
               else if(field[y][x] == 3) {
            	   Castle img = new Castle(x*50,y*50);
            	   img.draw(gc);
            	   
               }else if(field[y][x] == 4) {
               	Image img = new Image(ClassLoader.getSystemResource("enemycastle.png").toString()) ;
               	gc.drawImage(img, x*50, y*50);
               }else if(field[y][x] == 5) {
               	Image img = new WritableImage(RenderableHolder.barbewireSprite.getPixelReader(),getTileIndex(x,y)*50,0,86,50);
               	gc.drawImage(img,x*50,y*50);
               }else if(field[y][x] == 6) {
               	Image img = new WritableImage(RenderableHolder.tree1Sprite.getPixelReader(),getTileIndex(x,y)*50,0,50,50);
               	gc.drawImage(img,x*50,y*50);
               }else if(field[y][x] == 7){
               	Image img = new Image(ClassLoader.getSystemResource("antena.png").toString()) ;
               	gc.drawImage(img,x*50,y*50);
               }else if(field[y][x] == 8) {
               	Image img = new WritableImage(RenderableHolder.cannonSprite.getPixelReader(),getTileIndex(x,y)*50,0,100,100);
               	gc.drawImage(img,x*50,y*50);
               }
            	
            
              
            }
        }
    }

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return true;
	}
}
