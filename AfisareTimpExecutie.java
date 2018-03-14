
public class AfisareTimpExecutie {
	
	long start;
	long stop;
	String message;

	public AfisareTimpExecutie(String message){
		this.message = message;	
	}
	
	
	public void afisareTimp(){
		System.out.println("Etapa :  " + message + " a durat " + calculateTime() + " nanosecunde");
	}
	
	
	private double calculateTime(){
		return stop - start;
	}


	public void setStart(long start){
		this.start = start;
	}
	
	public void setStop(long stop){
		this.stop = stop;
	}
	
	public double getStart(){
		return start;
	}
	
	public double getStop(){
		return stop;
	}

	
	
}