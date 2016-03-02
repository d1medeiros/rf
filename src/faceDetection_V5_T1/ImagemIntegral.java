package faceDetection_V5_T1;

import java.util.Arrays;

public class ImagemIntegral {

	private MLista listaImagemIntegral;
	private MLista listaImagem;
	private int imageI = 0;
	private int soma1 = 0;
	private int soma2 = 0;
	private int soma3 = 0;
	private int somaTemp1 = 0;
	private int somaTemp2 = 0;
	private int somaTemp3 = 0;
	private int somaTemp4 = 0;
	private int h2 = 0;
	private int w2 = 0;
	private int pegaSomaPixel = 0;
	private int masks[][];
	
	
	public ImagemIntegral(Imagem imagem){	
		//define altura e largura
		h2 = imagem.getH2();
		w2 = imagem.getW2();
		
		//inicia listas
		listaImagemIntegral = new MLista(h2, w2);
		listaImagem = new MLista(h2, w2);
		
		listaImagemIntegral = imagem.getListaImagem();
		
		for (int x = 0; x < h2; x++) {
			for (int y = 0; y < w2; y++) {
				int temp = imagem.getListaImagem().get(x, y);
				listaImagem.add(x, y, temp);
			}
		}
				
		for (int x = 1; x < h2; x++) {
			for (int y = 1; y < w2; y++) {
				somaArea(x, y);
			}
		}
		
		System.out.println("********imagem----integral-----iniciada*******");
	}


	public void somaArea(int x, int y){
		int ii = pega(x, y);
		int s1 = pega(x -1, y);
		int s2 = pega(x, y -1);
		int s3 = pega(x -1, y -1);
		int imgI = ii + s1 + s2 - s3;
		//int pixel = listaPixel.get(x, y);
		listaImagemIntegral.add(x, y, imgI);
	}
	
	
	public int pega(int x, int y) {
		int colorPega = listaImagemIntegral.get(x, y);	
		return colorPega;	
	}
	
	

	public int somaPixelImgIntegral(int xMin, int xMax, int yMin, int yMax){
		if(xMax >= h2)
			xMax = h2 - 1;
		if(yMax >= w2)
			yMax = w2 -1;
		int pixelD = pega(xMax, yMax);								
		int pixelA = pega(xMin -1, yMin -1);
		int pixelB = pega(xMin -1, yMax);		
		int pixelC = pega(xMax, yMin -1);				
		pegaSomaPixel =  pixelA + pixelD - pixelB - pixelC;
		return pegaSomaPixel;
	}

	
	public void byImage(int pixels){
		int min = 1;
		int max = pixels;
		masks = new int[pixels -1][pixels -1];
		
		for (int x = min; x <= max; x++) {
			for (int y = min; y <= max; y++) {				
				masks[x-1][y-1] = pega(x, y);
			}
		}
		
	}
	
	public MLista getListaImagemIntegral() {
		return listaImagemIntegral;
	}

	public MLista getListaImagem() {
		return listaImagem;
	}

	
	public int getH2(){
		return this.h2;
	}
	
	
	public int getW2(){
		return this.w2;
	}



	

}
