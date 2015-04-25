package edu.uwec.cs.kunseljp.program1;

import java.awt.image.BufferedImage;

public class ScaleImage {
	//scales tile images to fit the original image
	public static BufferedImage scaleImage(BufferedImage originalImage, int newWidth, int newHeight){
		BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
		
		//calculates the x scale and y scale factors
		double xScale = (double) originalImage.getWidth() / (double) newWidth;
		double yScale = (double) originalImage.getHeight() / (double) newHeight;
		
		//scales each pixel of the original image to the percentage from above
		for(int x=0; x<newWidth; x++){
			for(int y=0; y<newHeight; y++){
				int pixelSample = originalImage.getRGB((int) (x * xScale), (int) (y * yScale));
				newImage.setRGB(x, y, pixelSample);
			}
		}
		return newImage;
	}
}
