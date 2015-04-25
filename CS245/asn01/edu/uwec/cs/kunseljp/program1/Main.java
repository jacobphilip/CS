package edu.uwec.cs.kunseljp.program1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// copy the tileImages folder and its graphics files into the project directory before running 

		String originalFilename = "apollo/apollo.jpg";
		String mosaicFilename = "opolloMosaic.png";

		String tileFolder = "edu/uwec/cs/kunseljp/program1/tileImages";
		int horzNumTiles = 100;  // experiment with different values for this
		int vertNumTiles = 100;  // experiment with different values for this

		// read the original file into a BufferedImage and the tile images into an ArrayList
		BufferedImage originalImage = LoadTiles.readImage(originalFilename);
		
		// Use the number of tiles and the size of the original image to compute individual tile size
        // Rounding and then truncating the fractional part with (int) is performed to find tiles
        // that will approximately fit the width and height of the original image
		int tileWidth = (int) Math.round((double) originalImage.getWidth() / (double) horzNumTiles);
		int tileHeight = (int) Math.round((double) originalImage.getHeight() / (double) vertNumTiles);
		
		// You’ve only got an approximate fit for placing tiles across the image.  Resize originalImage
        	// to make this an exact fit.  Resize based on the tile size so we get an even number of tiles
		originalImage = ScaleImage.scaleImage(originalImage, horzNumTiles * tileWidth, vertNumTiles * tileHeight);

		// Read in the images to be used as tiles and convert them to tile size
		ArrayList<BufferedImage> tiles = LoadTiles.loadTileImages(tileFolder, tileWidth, tileHeight);		

		// Compute the metric (color) for each tile
		ArrayList<Color> tileColors = ColorMethods.computeTileColors(tiles);

		// Form a mosaic of the original image using the given tiles
		Mosaic mosaicImage = new Mosaic(originalImage, tileWidth, tileHeight, tiles, tileColors, horzNumTiles, vertNumTiles);

		// Write out the mosaic version
		mosaicImage.writeImage(mosaicFilename);
		System.out.println("Finished");
	}
}
