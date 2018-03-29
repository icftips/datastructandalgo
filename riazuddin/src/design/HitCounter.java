package design;

/*
 * Design a class with two methods 
 * 	hit() - counts hits every second, and 
 * 	getAverage() - returns the average of last 5 min (300 sec)
 * 
 */
public class HitCounter {
	
	private int[] hits = new int[300];
	private long[] ts = new long[300];
	private int idx = 0;
	private int LAST_300 = 300 * 1000;

	public void hit() {
		long currentTS = System.currentTimeMillis();
		boolean recent = (currentTS - ts[idx]) <= LAST_300;
		if(recent)
			hits[idx]++;
		
		ts[idx] = currentTS;
		if(idx+1 == 300)
			idx = 0;
	}
	
	public double getAverage() {
		long now = System.currentTimeMillis();
		int sum = 0;
		for(int i = 0; i < ts.length; i++) {
			if((now - ts[i]) <= LAST_300)
				sum += hits[i];
		}
		
		return sum/300;
	}
}
