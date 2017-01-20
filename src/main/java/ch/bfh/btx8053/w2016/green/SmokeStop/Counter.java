package ch.bfh.btx8053.w2016.green.SmokeStop;

import NotComparableException;

public class Counter {

	
	private int counter, x, y; 
	
	public int counter() {
		return x;
	}
	
	
	public int getDailyGoal() {
		return y;
	}
	
	
	public boolean isComparable(Double object) {
		if (object == null)
			return false;
		return true;
	}
	
	public boolean isEqualTo(Double x, Double y) throws NotComparableException {
		if ((x.equals(null)) || (y.equals(null)))
			throw new NotComparableException();
		else if (x.equals(y))
			return true;
		return false;
	}
	
	public boolean isLessThan(Double x, Double y) throws NotComparableException {
		if ((y == null) || (x == null))
			throw new NotComparableException();
		else if (x < y)
			return true;
		return false;
	}
	
	public boolean isLessThanOrEqualTo(Double x, Double y) throws NotComparableException {
		if ((x == null) || (y == null))
			throw new NotComparableException();
		else if (x <= y)
			return true;
		return false;
	}
	
	public boolean isGreaterThan(Double x, Double y) throws NotComparableException {
		if ((x == null) || (y == null))
			throw new NotComparableException();
		else if (x > y)
			return true;
		return false;
	}
	public boolean isGreaterThanOrEqualTo(Double x, Double y) throws NotComparableException {
		if ((x == null) || (y == null))
			throw new NotComparableException();
		else if (x >= y)
			return true;
		return false;
	}
	
}
