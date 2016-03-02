package faceDetection_V5_T1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Imagem {
	
	//image = imagem direta do BufferedImage
	// pixel = coordenada de cada pixel na imagem
	//listaPixel = contem pixels da imagem organizados por Pontos
	//toGray = transforma em gray
	private BufferedImage image;
	private Pixel pixel;
	private MLista listaImagem;
	private ToGray toGray;
	private int pegaSomaPixel = 0;
	private int h;
	private int w;
	private int h2;
	private int w2;
	

	public Imagem(String file){
		
		try {
			image = ImageIO.read(new File(file));
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
		toGray = new ToGray(image);
		h = toGray.getH();
		h2 = toGray.getH2();
		w = toGray.getW();
		w2 = toGray.getW2();
		listaImagem = new MLista(h2,w2);
	    listaImagem = toGray.getmLista();
	    System.out.println("********imagem-----iniciada*******");
	}
	
	
	public int getPixel(int x, int y){
		return listaImagem.get(x, y);
	}

	
	public MLista getListaImagem() {
		return listaImagem;
	}
	
	
	public int somaPixel(int xMin, int xMax, int yMin, int yMax){	
		
		int soma = 0;
		for (int x = xMin; x <= xMax; x++) {
			for (int y = yMin; y <= yMax; y++) {

				int temp = listaImagem.get(x,y);
				soma += temp;
				
			}
		}
		return soma;
	}

	
	public void exportaJPG(){
		Exporta e = new Exporta();
		e.jpg(image.getHeight(), image.getWidth(), listaImagem, "imagem.jpg");
	}
	
	
	public void teste3(int xMin, int xMax, int yMin, int yMax) {
		somaPixel(xMin, xMax, yMin, yMax);
		System.out.println(pegaSomaPixel);
	}
	
	
	


	public int getH2() {
		return h2;
	}


	public int getW2() {
		return w2;
	}


	
	
}
