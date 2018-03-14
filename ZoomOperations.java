import java.awt.image.BufferedImage;

public interface ZoomOperations {

	  BufferedImage enlargeImage(BufferedImage image, int n) ;
	 
	  BufferedImage loadImage(String path);
	 
	  void saveImage(BufferedImage img,String path) ;
}
