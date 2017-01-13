/**
 * It is an CashRegister Class which calculates the saved money
 * @author Team Green
 *
 */

public class CashRegister {

	/**
	 * Defines the variables 
	 */
	public int amount, saved, counter;
	
	/**
	 *Constructs a cash register with no money in it
	 */
	
	
	public CashRegister(){
		saved = 0;
		counter = 0;
		amount = 0;	
	
	}
	
	/**
	 * Calculate the saved money
	 * @param amount
	 */
	
	public void calculateSaved(int amount){
	amount = saved + counter;
	}
	
	/**
	 * Calculate the change of the saved money
	 * @return
	 */
	public int giveChange()
	   {    
	      int change = counter - saved;
	      return change;
	   }
	
	/**
	 * it is return the saved money
	 * @return
	 */
	public int getSaved(){
		return saved;
	}
	
	/**
	 *It return the counter money
	 * @return
	 */
	public int getCounter(){
	return counter;
	
	}	
	
	
}