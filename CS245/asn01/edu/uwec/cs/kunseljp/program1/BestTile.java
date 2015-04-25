package edu.uwec.cs.kunseljp.program1;

import java.awt.Color;
import java.util.ArrayList;

public class BestTile {

	public static ArrayList<Integer> findBestTile(Color mosaicColor, ArrayList<Color> tileColors){
		ArrayList<Double> tileDistance = new ArrayList<Double>();
		ArrayList<Integer> tileDistIndex = new ArrayList<Integer>();
		
		float[] mosaicHSB = Color.RGBtoHSB(mosaicColor.getRed(), mosaicColor.getGreen(), mosaicColor.getBlue(), null);
		
		//find the HSB distance of each tile
		for(int i=0; i<tileColors.size(); i++) {
			float[] tileColorsHSB = Color.RGBtoHSB(tileColors.get(i).getRed(), tileColors.get(i).getGreen(), tileColors.get(i).getBlue(), null);
			double hueDist = Math.pow(mosaicHSB[0] - tileColorsHSB[0], 2);
			double satDist = Math.pow(mosaicHSB[1] - tileColorsHSB[1], 2);
			double brightDist = Math.pow(mosaicHSB[2] - tileColorsHSB[2], 2);
			double distHSB = Math.sqrt(hueDist + satDist + brightDist);

			tileDistance.add(new Double(distHSB));
			tileDistIndex.add(new Integer(i));
		}
		
		//sorts the array lists
		for(int i=0; i<(tileDistance.size()-1); i++){
			int smallestIndex = i;
			for (int j=i+1; j<tileDistance.size(); j++) {
				if ( tileDistance.get(j).compareTo(tileDistance.get(smallestIndex)) < 0 ) {
					smallestIndex = j; 
				}
			}
			if (smallestIndex > i){
				double temp = tileDistance.get(smallestIndex);
				tileDistance.set(smallestIndex, tileDistance.get(i));
				tileDistance.set(i, temp);
				
				int temp2 = tileDistIndex.get(smallestIndex);
				tileDistIndex.set(smallestIndex, tileDistIndex.get(i));
				tileDistIndex.set(i, temp2);
			}
		}
		return tileDistIndex;
	}

}
