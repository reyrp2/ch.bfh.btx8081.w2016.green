
public class CashRegister {

	public int amount, x, y; 

	/*
	 * Calculate the amount 
	 */
	public void calculateSaved(int amount){
	this.amount = amount;
	}
	
	/*
	 * Returns the stored values
	 */
	public int getSaved(){
	return x;
	}
	
	/*
	 * Returns the Counter values
	 */
	public int getCounter(){
	return y;
	}

	
}
