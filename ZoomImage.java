import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class ZoomImage implements ZoomOperations {
	
	BufferedImage image;
	BufferedImage enlargedImage;
	
	public ZoomImage(){
		image = null;
		enlargedImage = null;
	}
	
	public BufferedImage loadImage(String path){
		
		BufferedImage image = null;
		
		  File f = new File(path);

	      try
	      {
	    	  image = ImageIO.read(f);
	      } catch (IOException e)
	      {
	    	  System.out.println("Locatia introdusa nu exista !");
	    	  MainClass.sw = false;
	      }
	      
	      return image;
	}
	
	
	public BufferedImage enlargeImage(BufferedImage image, int n){
		
		int w,h;
		
		if(n>=0){
			w = n * image.getWidth();
			h = n * image.getHeight();
		}
		else{
			w = -image.getWidth()/n;
			h = -image.getHeight()/n;
		}

	    BufferedImage enlargedImage = null;
	    
	    try{
	    enlargedImage = new BufferedImage(w, h, image.getType());
	    }catch(Exception e){
	    	  System.out.println("Tastati va rog un numar diferit de 0");
	    	  MainClass.sw = false;
	    };

	    
	    if(n>=0){
		    for (int y = 0; y < h; ++y){
		      for (int x = 0; x < w; ++x){
		        enlargedImage.setRGB(x, y, image.getRGB(x / n, y / n));
		      }
		    }
	    }
	    else{
		    for (int y = 0; y < h; ++y){
			      for (int x = 0; x < w; ++x){
			        enlargedImage.setRGB(x, y, image.getRGB(x * (-n), y * (-n)));
			      }
			    }
	    }
	    
	    
	    return enlargedImage;
	}
	
	public void saveImage(BufferedImage enlargedImage,String path){
	    try {
    	    File outputfile = new File(path);
    	    ImageIO.write(enlargedImage, "bmp", outputfile);
    	} catch (IOException e) {
    		System.out.println("Locatia introdusa nu exista !");
	    	  MainClass.sw = false;
    	}
	}

}
