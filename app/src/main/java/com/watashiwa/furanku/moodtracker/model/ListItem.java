package com.watashiwa.furanku.moodtracker.model;

/**
 * This class set the list
 * Created by Furanku Watashiwa on 03/02/2018.
 */
public class ListItem {
	/**
	 * this represents the image to add to the list
	 */
	private int mImageResource;

	/**
	 * this represents the color to add to the list
	 */
	private String mColorResource;

	/**
	 * constructor of this class
	 * each item added to the list has an image and a color
	 * @param imageResource
	 * @param colorResource
	 */
	public ListItem(int imageResource , String colorResource) {
		mImageResource = imageResource;
		mColorResource = colorResource;
	}

	/**
	 * To get the image added to the list
	 * @return the image
	 */
	public int getImageResource() {
		return mImageResource;
	}

	/**
	 * to get the color added to the list
	 * @return the color
	 */
	public String getColorResource() {
		return mColorResource;
	}
}
