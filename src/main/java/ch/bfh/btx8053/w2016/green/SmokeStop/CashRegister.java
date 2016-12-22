
public class CashRegister {

	private int amount, x, y; 

	/*
	 * Calculate the amount 
	 */
	private void calculateSaved(int amount){
	this.amount = amount;
	}
	
	/*
	 * 
	 */
	private void Saved(int x){
		this.x = x;
	}
	
	/*
	 * Returns the stored values
	 */
	private int getSaved(){
	return x;
	}
	
	/*
	 * 
	 */
	
	private void Counter(int y){
		this.y = y;
	}
	
	/*
	 * Returns the Counter values
	 */
	private int getCounter(){
	return y;
	}

	
}
