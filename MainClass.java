import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainClass {
	
	//   C:\\Users\\user\\Desktop\\parrots2.bmp
	//   C:\\Users\\user\\Desktop\\parrots.bmp
	
	static String input = null;
	static String output = null;
	static int n;
	public static boolean sw = false;
	
	public static void main(String[] argv) throws Exception {
	  
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		
	     ZoomImage obj1 = new ZoomImage();
	    
	     
	     Cronometru timer1 = new Cronometru("Incarcare Imagine");
	     Cronometru timer2 = new Cronometru("Prelucrare Imagine");
	     Cronometru timer3 = new Cronometru("Salvare Imagine");
	     
	     while(!sw){
	    	 
		     sw = true;
	    	 
	     System.out.println("Tastati locatia imaginii pe care doriti sa o utilizati: ");
	     input = sc.readLine();
	     

	     timer1.startCronometru();
		     try{
		    	 obj1.image = obj1.loadImage(input);
		     } catch(Exception e){sw=false;}
		 timer1.stopCronometru();
		     
	     };
	     
	     
	     sw = false;
	     
	     while(!sw){
	    	 sw = true;
	    	 
		     System.out.println("Care este scara la care care doriti sa redimensionati imaginea ? ");
		     
		     try{
		    	 n = Integer.parseInt(sc.readLine());
		    	 
			     try{
				     	timer2.startCronometru();
				     	BufferedImage imge = obj1.enlargeImage(obj1.image,n);
				     	 obj1.enlargedImage = imge;
				     	timer2.stopCronometru();
				     }
					 catch(Exception e){
				    	 sw = false;
					 }
		    	 
		     }catch(Exception e){
		    	 System.out.println("Tastati va rog un numar intreg!");
		    	 sw = false;
		     };
		    
	     };
	     
	    	 sw = false;
	    	 
			 while(!sw){
				 
		    	 sw = true;
				 
			     System.out.println("Tastati noua locatie a imaginii: ");
				 output = sc.readLine();
			     
				timer3.startCronometru();
				obj1.saveImage(obj1.enlargedImage,output);
				timer3.stopCronometru();

		    	 
			     
			 };
	     
	     
	     System.out.println();
	     System.out.println("Executia a fost finalizata");
	     timer1.afisareTimp();
	     timer2.afisareTimp();
	     timer3.afisareTimp();
  }
}