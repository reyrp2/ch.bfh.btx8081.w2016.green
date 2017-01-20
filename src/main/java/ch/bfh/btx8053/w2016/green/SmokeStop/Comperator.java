package ch.bfh.btx8053.w2016.green.SmokeStop;


public interface Comperator {
	
	public boolean isLessThan(int x, int y) throws NotComparableException;
	
	public boolean isLessThanOrEqualTo(int x, int y) throws NotComparableException;

	public boolean isEqualTo(int x, int y) throws NotComparableException;

	public boolean isGreaterThan(int x, int y) throws NotComparableException;

	public boolean isGreaterThanOrEqualTo(int x, int y) throws NotComparableException;

	public boolean isComparable(int x, int y);

}
