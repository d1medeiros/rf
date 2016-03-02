package faceDetection_V5_T1.teste;

import java.io.IOException;

import faceDetection_V5_T1.ImageResizer;

public class TesteT {



	public static void main(String[] args) {
		
		ImageResizer ir = new ImageResizer();
		String inputImagePath = "b.jpg";
		String outputImagePath = "/Users/EOMATI/Desktop/testeRF/b.jpg";
		 
		        try {
		            // resize smaller by 50%
		            double percent = 0.4;
		            ir.resize(inputImagePath, outputImagePath, percent);
		 
		            
		 
		        } catch (IOException ex) {
		            System.out.println("Error resizing the image.");
		            ex.printStackTrace();
		        }
		
	}
	
	/*
	BufferedImage before = getBufferedImage(encoded);
int w = before.getWidth();
int h = before.getHeight();
BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
AffineTransform at = new AffineTransform();
at.scale(2.0, 2.0);
AffineTransformOp scaleOp = 
   new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
after = scaleOp.filter(before, after);
	 */
	

}
