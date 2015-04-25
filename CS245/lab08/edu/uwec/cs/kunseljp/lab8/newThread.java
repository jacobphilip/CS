package edu.uwec.cs.kunseljp.lab8;

public class newThread implements Runnable {

	public int startX;
	public int maxX;
	public int startY;
	public int maxY;
	public int maskWidth;
	public int maskHeight;
	public Thread mask;
	
	public newThread(int x, int mx, int y, int my, int mW, int mH) {
		this.startX = x;
		this.maxX = mx;
		this.startY = y;
		this.maxY = my;
		this.maskWidth = mW;
		this.maskHeight = mH;
		
		this.startThread();
	}
	
	public void run() {
		for (int x = startX; x < maxX; x++) {
			for (int y = startY; y < maxY; y++) {
				double redResult = 0, greenResult = 0, blueResult = 0;

				for (int u = 0; u < maskWidth; u++) {
					for (int v = 0; v < maskHeight; v++) {
						int xoffset = x + (u - (maskWidth / 2));
						int yoffset = y + (v - (maskHeight / 2));

						redResult += Convolution.mask.getValue(u, v) * Convolution.in.getRed(xoffset, yoffset);
						greenResult += Convolution.mask.getValue(u, v) * Convolution.in.getGreen(xoffset, yoffset);
						blueResult += Convolution.mask.getValue(u, v) * Convolution.in.getBlue(xoffset, yoffset);
					}
				}
				
				// Add any bias required by the mask
				redResult += Convolution.mask.getBias();
				greenResult += Convolution.mask.getBias();
				blueResult += Convolution.mask.getBias();
				
				// Clamp the values
				if (redResult < 0) {
					redResult = 0;
				} else if (redResult > 255) {
					redResult = 255;
				}
				if (greenResult < 0) {
					greenResult = 0;
				} else if (greenResult > 255) {
					greenResult = 255;
				}
				if (blueResult < 0) {
					blueResult = 0;
				} else if (blueResult > 255) {
					blueResult = 255;
				}
				
				Convolution.out.setRGB(x, y, (int) redResult, (int) greenResult, (int) blueResult);
				Convolution.outPanel.repaint();
			}
		}
	}
	
	public void startThread() {
		mask = new Thread(this);
		mask.start();
	}
	
	public void stopThread() {
		try {
			mask.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
