package faceDetection_V5_T1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ToGray {
	
	private Ponto ponto;
	private BufferedImage image;
	private int h;
	private int w;
	private int h2;
	private int w2;
	private MLista mLista;
	

	public ToGray() {			
			
		
	}

	
	public ToGray(String file) {
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		h = image.getHeight();
		w = image.getWidth();
		ini();
	}


	public ToGray(BufferedImage image) {
		this.image = image;
		h = image.getHeight();
		w = image.getWidth();
		ini();
	}
	
	public void ini() {
		h2 = h + 1;
		w2 = w + 1;	
		mLista = new MLista(h2, w2);
		Color zero = new Color(0,0,0);
		for (int x = 0; x < h2; x++) {
			for (int y = 0; y < w2; y++) {
				int corImage = convertGray(zero.getRGB());
				Cor cor = new Cor(corImage);
				mLista.add(x, y, cor.getCor());
			}
		}
		for (int x = 0; x < h2; x++) {
			for (int y = 0; y < w2; y++) {
				if(y == w)
					break;
				else if(x == h)
					break;
				else{
				int nX = x + 1;
				int nY = y + 1;
				Pixel pixel;
				int corImage = convertGray(image.getRGB(x, y));
				Cor cor = new Cor(corImage);
				cor.setCorSoma(corImage);
				mLista.add(nX, nY, cor.getCor());
				}
			}
		}
		System.out.println("********togray----iniciado*******");
	}
	
	
	public int convertGray(int rgb){
		Color gray = new Color(rgb);
		int red = gray.getRed();
		int green = gray.getGreen();
		int blue = gray.getBlue();
		int g = (red + green + blue) / 3;
		return g;
	}

	
	public int desConvertGrey(int rgb){
		return new Color(rgb,rgb,rgb).getRGB();
	}
	



	public MLista getmLista() {
		return mLista;
	}


	public int getH() {
		return h;
	}


	public int getW() {
		return w;
	}


	public int getH2() {
		return h2;
	}


	public int getW2() {
		return w2;
	}

 
	
	
	
}
