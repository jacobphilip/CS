package edu.uwec.cs.kunseljp.program1;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

public class Mosaic {

	public static BufferedImage newImage;

	Mosaic(BufferedImage originalImage, int tileWidth, int tileHeight,
			ArrayList<BufferedImage> tiles, ArrayList<Color> tileColors,
			int horzNumTiles, int vertNumTiles) {

		Color avgColor;
		int width = tileWidth * horzNumTiles;
		int height = tileHeight * vertNumTiles;
		newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


		// goes through each tile in the original image and finds the average color then replaces it with the best image
		for (int vert = 0; vert < vertNumTiles; vert++) {
			for (int horz = 0; horz < horzNumTiles; horz++) {
				int xCurrent = (horz * tileWidth);
				int yCurrent = (vert * tileHeight);
				avgColor = ColorMethods.averageImageColor(originalImage, xCurrent,
						yCurrent, tileWidth, tileHeight);
				ArrayList<Integer> bestTile = BestTile.findBestTile(avgColor,
						tileColors);
				for (int a = 0; a < tileWidth; a++) {
					for (int b = 0; b < tileHeight; b++) {
						int xNew = (horz * tileWidth) + a;
						int yNew = (vert * tileHeight) + b;
						int bestIndexTile = 0;
						// grabs the best tile, saves the index, and copies it to the new image
						int pixelSample = (tiles.get(bestTile.get(bestIndexTile))).getRGB(a, b);

						newImage.setRGB(xNew, yNew, pixelSample);
					}
				}
			}
		}
	}

	//method to create new png image
	public void writeImage(String imageFilename) {
		File newPicture= new File(imageFilename);
		try {
			ImageIO.write(newImage, "png", newPicture);
		} catch (IOException e) {
			System.out.println("Error: could not create new image.");
			System.exit(1);
		}
	}
}