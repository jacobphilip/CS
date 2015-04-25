package edu.uwec.cs.kunseljp.program1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ColorMethods {
	//compute the average color of every tile
	public static ArrayList<Color> computeTileColors(ArrayList<BufferedImage> tiles){
		Color tileColorList;
		ArrayList<Color> colorList = new ArrayList<Color>();
		for(int i=0; i<tiles.size(); i++) {
			tileColorList = averageImageColor(tiles.get(i));
			colorList.add(tileColorList);
		}
		return colorList;
	}
	
	//computes the average color of the original image
	private static Color averageImageColor(BufferedImage image) {
		return averageImageColor(image, 0, 0, image.getWidth(), image.getHeight());
	}
	
	//takes a section of the original image and computes the average color
	public static Color averageImageColor(BufferedImage image, int startX, int startY, int width, int height) {
		int packedColor;
		int red = 0;
		int green = 0;
		int blue = 0;
	
		//finds the amount of red, green and blue of every pixel in the section
		for(int x=0; x<width; x++) {
			for(int y=0; y<height; y++) {
				packedColor = image.getRGB((startX + x), (startY + y));
				red += (packedColor >> 16) & 255;
				green += (packedColor >> 8) & 255;
				blue += (packedColor >> 0) & 255;
			}
		}
		
		//saves the amount of red, green and blue as one new color
		red = red / (width*height);
		green = green / (width*height);
		blue = blue / (width*height);
		Color averageColor = new Color(red, green, blue);
		return averageColor;
	}
}
