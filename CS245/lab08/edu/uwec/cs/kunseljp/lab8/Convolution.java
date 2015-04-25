
package edu.uwec.cs.kunseljp.lab8;

public class Convolution {

	public static UWECImage out;
	public static ImagePanel outPanel;
	public static Mask mask;
	public static UWECImage in;

	public static int width;
	public static int height;
	public static int maskWidth;
	public static int maskHeight;

	public static UWECImage convolve(UWECImage in2, Mask m2, UWECImage out2, ImagePanel outPanel2) {
		width = in2.getWidth();
		height = in2.getHeight();
		maskWidth = m2.getWidth();
		maskHeight = m2.getHeight();
		out = out2;
		outPanel = outPanel2;
		mask = m2;
		in = in2;

		newThread my1 = new newThread((width / 10) * 0, (width / 10) * 1, 0, height, maskWidth, maskHeight);
		newThread my2 = new newThread((width / 10) * 1, (width / 10) * 2, 0, height, maskWidth, maskHeight);
		newThread my3 = new newThread((width / 10) * 2, (width / 10) * 3, 0, height, maskWidth, maskHeight);
		newThread my4 = new newThread((width / 10) * 3, (width / 10) * 4, 0, height, maskWidth, maskHeight);
		newThread my5 = new newThread((width / 10) * 4, (width / 10) * 5, 0, height, maskWidth, maskHeight);
		newThread my6 = new newThread((width / 10) * 5, (width / 10) * 6, 0, height, maskWidth, maskHeight);
		newThread my7 = new newThread((width / 10) * 6, (width / 10) * 7, 0, height, maskWidth, maskHeight);
		newThread my8 = new newThread((width / 10) * 7, (width / 10) * 8, 0, height, maskWidth, maskHeight);
		newThread my9 = new newThread((width / 10) * 8, (width / 10) * 9, 0, height, maskWidth, maskHeight);
		newThread my10 = new newThread((width / 10) * 9, (width / 10) * 10, 0, height, maskWidth, maskHeight);

		my1.stopThread();
		my2.stopThread();
		my3.stopThread();
		my4.stopThread();
		my5.stopThread();
		my6.stopThread();
		my7.stopThread();
		my8.stopThread();
		my9.stopThread();
		my10.stopThread();

		return out;
	}
}