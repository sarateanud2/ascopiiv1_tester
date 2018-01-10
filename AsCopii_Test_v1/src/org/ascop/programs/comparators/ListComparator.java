package org.ascop.programs.comparators;

import java.util.Comparator;

public class ListComparator {
	
	private static ObjectComparator listComparator;
	
	@SuppressWarnings("rawtypes")
	public static Comparator getInstance() {
		if (listComparator == null) {
            listComparator = new ObjectComparator();
        }
		
		return listComparator;
		
	}
	
	@SuppressWarnings("rawtypes")
	private static class ObjectComparator implements Comparator{

		@Override
		public int compare(Object a1, Object a2) {
			
			return a1.toString().compareTo(a2.toString());
		}
		
	}
	
	
}
