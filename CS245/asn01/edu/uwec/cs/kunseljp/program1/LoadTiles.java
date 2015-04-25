package edu.uwec.cs.kunseljp.program1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LoadTiles {
	//loads original file
	public static BufferedImage readImage(String imageFilename){
		File picName =  new File(imageFilename);
		BufferedImage picture = null;
		try {
			picture = ImageIO.read(picName);
		} catch (IOException e) {
			System.err.println("Unable to load the image.");
			System.exit(0);
		}
		return picture;
	}
	//loads tiles from a folder
	public static ArrayList<BufferedImage> loadTileImages(String folder, int tileWidth, int tileHeight){
		ArrayList<String> fileNames = new ArrayList<String>();
		File newFolder = new File(folder);
		String child [] = newFolder.list();
		if (child == null){
			System.out.println("Folder does not exist!");
			System.exit(1);
		} else {
			for(int l=0; l<child.length; l++){
				fileNames.add(child[l]);
			}
		}
		ArrayList<BufferedImage> tileImages = new ArrayList<BufferedImage>();
		for(int x=0; x<fileNames.size(); x++) {
			BufferedImage tileScale;
			tileScale = readImage(folder + "/" +fileNames.get(x));
			tileScale = ScaleImage.scaleImage(tileScale, tileWidth, tileHeight);
			tileImages.add(tileScale);
		}
		return tileImages;
	}
}
