package com.digi.portal.mobdev.android.aphone.helper;

import java.util.ArrayList;
import java.util.List;

/**
 * this class helps filter and modify items in array
 * 
 * @author Dinesh.BS
 *
 */
public class AppCollections {

	/**
	 * search multiple of items in array
	 * 
	 * @param list
	 *            search multiple item from this list object
	 * @param compare
	 *            object for check whether item need to be filtered or not.
	 * @return filtered items list or empty array
	 * @author Dinesh.BS
	 */
	public static <A> List<A> searchMultiple(List<? extends A> list, Compare<A> compare) {
		List<A> values = new ArrayList<A>();
		for (A item : list) {
			if (compare.forItem(item)) {
				values.add(item);
			}
		}
		return values;
	}

	/**
	 * 
	 * @param list
	 *            search single item from this list object
	 * @param compare
	 *            object for check whether item need to be filtered or not.
	 * @return filtered item or null
	 * @author Dinesh.BS
	 */
	public static <A> A searchItem(List<? extends A> list, Compare<A> compare) {
		for (A a : list) {
			if (compare.forItem(a))
				return a;
		}
		return null;
	}

	/**
	 * 
	 * @param list
	 *            list search single item from this list object
	 * @param compare
	 *            object for check whether item need to be removed or not.
	 * @author Dinesh.BS
	 */
	public static <A> void removeItem(List<? extends A> list, Compare<A> compare) {
		for (int i = 0; i < list.size(); i++) {
			A item = list.get(i);
			if (compare.forItem(item)) {
				list.remove(item);
				i--;
			}
		}
	}

	/**
	 * 
	 * @param list
	 * @param compare
	 * @return
	 * @author Dinesh.BS
	 */
	public static <A> int searchIndex(List<? extends A> list, Compare<A> compare) {
		for (int i = 0; i < list.size(); i++) {
			if (compare.forItem(list.get(i)))
				return i;
		}
		return -1;
	}

	/**
	 * having one method to filter from list by returning true or false
	 * 
	 * @author Dinesh.BS
	 * @param <Item>
	 *            Object type to compare
	 */
	public interface Compare<Item> {
		/**
		 * callback method for compare objects
		 * 
		 * @param a
		 *            current object from the list to compare
		 * @return true if need to be filtered or false to ignore
		 * @author Dinesh.BS
		 */
		boolean forItem(Item a);
	}
}
