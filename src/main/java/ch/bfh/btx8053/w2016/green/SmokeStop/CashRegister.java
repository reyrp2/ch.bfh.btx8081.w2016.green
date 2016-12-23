
package ch.bfh.btx8053.w2016.green.SmokeStop;

/*
 * This Class save the amount of the money not invested on Cigarrettes
 */

public class CashRegister {

	private int amount, x, y; 

	/*
	 * Calculate the amount 
	 */
	private void calculateSaved(int amount){
	this.amount = amount;
	}
	
	
	
	/*
	 * saved the amount of money
	 */
	private int getSaved(){
	return x;
	}


	/*
	 * Returns the Counter of Cigarrettes smoked 
	 */
	
	private int getCounter(){
	return y;
	}

	
}
