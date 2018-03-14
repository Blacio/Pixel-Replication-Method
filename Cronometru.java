
public class Cronometru extends AfisareTimpExecutie {

	public Cronometru (String mesaj){
		super(mesaj);
	}
	
	
	public void startCronometru(){
		long start = System.nanoTime();
		super.setStart(start);
	}
	
	public void stopCronometru(){
		long stop = System.nanoTime();
		super.setStop(stop);
	}
		
}
