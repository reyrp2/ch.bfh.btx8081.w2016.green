package ch.bfh.btx8053.w2016.green.SmokeStop;


public class Cigarettes {
	
	
	public int NumberOfCigarette;
	
	public int NicotinLevel;
	
	private int calculateNicotinLevelPerCigarette;

	public Cigarettes(){
		
		NumberOfCigarette = 0;
		NicotinLevel = 12;
	}
	
	
	public int getCalculateNicotinLevelPerCigarette() {
		
		calculateNicotinLevelPerCigarette = NicotinLevel * NumberOfCigarette;	
		return calculateNicotinLevelPerCigarette;
	}


}
