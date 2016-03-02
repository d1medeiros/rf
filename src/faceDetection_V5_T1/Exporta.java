package faceDetection_V5_T1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Exporta {
	
	public void jpg(int height, int width, MLista listaPixelI, String name){	
			BufferedImage bi = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
			for (int x = 0; x < height; x++) {
				for (int y = 0; y < width; y++) {
					int rgb = desConvertGrey(listaPixelI.get(x, y));
					bi.setRGB(x, y, rgb);
					//System.out.println(rgb);
				}
					
			}
			String n = name + ".jpg";
			o(n, bi);
	}

	
	public void jpg(ImagemIntegral ii, String name){	
		int height = ii.getH2();
		int width = ii.getW2();
		MLista listaPixelI = ii.getListaImagem();
		BufferedImage bi = new BufferedImage(height, width, BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < height; x++) {
			for (int y = 0; y < width; y++) {
				int rgb = desConvertGrey(listaPixelI.get(x, y));
				bi.setRGB(x, y, rgb);
				//System.out.println(rgb);
			}
			
		}
		String n = name + ".jpg";
		o(n, bi);
	}


	public void o(String name, BufferedImage bi) {
		File outputfile = new File(name);
		try {
			ImageIO.write(bi, "jpg", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int desConvertGrey(int rgb){
		
		return new Color(rgb,rgb,rgb).getRGB();
		
	}
	
}
