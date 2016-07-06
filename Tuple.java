package com.digi.portal.mobdev.android.aphone.helper;

/**
 * Created by Dinesh BS on 2/25/2016.
 * org HCL tech
 */

/**
 * A small helper class used to pass two data type objects on method return.
 * 
 * @author dineshbs.b
 *
 * @param <X>
 * @param <Y>
 */
public class Tuple<X, Y> {

	public final X x;
	public final Y y;

	public Tuple(X x, Y y) {
		this.x = x;
		this.y = y;
	}
}
