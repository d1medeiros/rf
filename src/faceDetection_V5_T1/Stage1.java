package faceDetection_V5_T1;

import java.util.ArrayList;

public class Stage1 {

	private ImagemIntegral ii;
	private int baseMin;
	private int baseMax;
	private ArrayList box;
	private ArrayList listaAdaboost;
	private Imagem i;
	private int adaboost[];
	private int h2;
	private int w2;
	private MLista listaTemp;
	int countArqNome = 0;
	

	public Stage1(ImagemIntegral ii, int baseMin, int baseMax){
		//inicia imagen
		this.ii = ii;
		
		//define altura e largura
		h2 = ii.getH2();
		w2 = ii.getW2();
		
		//tamanho do quadrado
		this.baseMin = baseMin;
		this.baseMax = baseMax;
		
		listaTemp = new MLista(h2, w2);
		
		for (int x = 0; x < h2; x++) {
			for (int y = 0; y < w2; y++) {
				int temp = ii.getListaImagem().get(x, y);
				listaTemp.add(x, y, temp);
			}
		}
		
		// inicia array com 24 somas para fazer o haar like
		box = new ArrayList<Integer>();
	
		//inicia array com  resultado do primeiro estagio
		adaboost = new int[6];
		
		//inicia lista de arrays com  resultados do adaboost
		listaAdaboost = new ArrayList<int[]>();
		
		//inicia tudo
		correQuadradoSomaArea();
		System.out.println("");
	}

	public void correQuadradoSomaArea(){
		int xMin = baseMin;
		int xMax = baseMax;   
		int yMin = baseMin;
		int yMax = baseMax; 
		do{
			if(yMax > (w2 -1)){
				yMin = baseMin;
				yMax = baseMax;
				xMin+= 1;
				xMax+= 1;
				if(xMax > (w2 - 1)){					
					break;
				}
			}
		determinaTamanhoQuadrado(xMin, xMax, yMin, yMax);
		yMin += 1;
		yMax += 1;
		}while(xMax <= (w2 - 1));
	}

	public void correQuadradoSomaArea(int a){
		int xMin = baseMin;
		int xMax = baseMax;   
		int yMin = baseMin;
		int yMax = baseMax; 
		
		determinaTamanhoQuadrado(xMin, xMax, yMin, yMax);
			
	}


	public void determinaTamanhoQuadrado(int xMin, int xMax, int yMin, int yMax){ 
		int divisaoBoxX = xMax / 4;
		int divisaoBoxY = xMax / 4;
		int xMin1 = xMin;
		int xMax1 = divisaoBoxX;   
		int yMin1 = yMin;
		int yMax1 = divisaoBoxY; 
		
		while(!(xMax1 > baseMax)){
			if(yMax1 > baseMax){
				yMin1 = baseMin;
				yMax1 = divisaoBoxY;
				xMin1 = xMax1;
				xMax1 += divisaoBoxX;
				if(xMax1 > baseMax)
					break;
			}
			int teste = ii.somaPixelImgIntegral(xMin1, xMax1, yMin1, yMax1);
			int c2 = divisaoBoxX * divisaoBoxY;
			teste /= c2;
			box.add(teste);
			yMin1 = yMax1;
			yMax1 += divisaoBoxY ;
		}
		haar();
		listaAdaboost.add(adaboost);
		imp(xMin, xMax, yMin, yMax);
		
	}


	//pega o numero referente a imagem estudada, onde retorna a soma de pixels para fazer o haar like
	public int pega(int posicao){
		int temp = (int) box.get(posicao);
		return temp;
	}

	//haar like 
	public void h(Boolean pb, int posicao){
		int escolha = 0;
		if(pb){
			escolha = 1;
		}else{
			escolha = 0;
		}
		adaboost[posicao] = escolha;
	}

	public void haar() {
		
//		h(pega(1) + pega(2) > pega(5) + pega(6), 0);											//1 + 2 = Branco 5 + 6 = Preto
//		h(pega(3) + pega(4) > pega(7) + pega(8), 1);											//3 + 4 = Branco 7 + 8 = Preto
//		h(pega(2) > pega(6), 2);																//2 = Branco  6 = Preto
//		h(pega(3)  > pega(7), 3);																//3 = Branco 7 = Preto
//		h(pega(2) + pega(3) > pega(6) + pega(7), 4);											//2 + 3 = Branco 6 + 7 = Preto
//		h(pega(1) + pega(2) + pega(3) + pega(4) > pega(5) + pega(6) + pega(7) + pega(8), 5);	//1 + 2 + 3 + 4 = Branco 5 + 6 + 7 + 8 = Preto

		int a0 = pega(0);
		int a1 = pega(1);
		int a2 = pega(2);
		int a3 = pega(3);
		int a4 = pega(4);
		int a5 = pega(5);
		int a6 = pega(6);
		int a7 = pega(7);
		int a8 = pega(8);
		int a9 = pega(9);
		int a10 = pega(10);
		int a11 = pega(11);
		int a12 = pega(12);
		int a13 = pega(13);
		int a14 = pega(14);
		int a15 = pega(15);
		
		boolean h0 = a0 + a4 > a1 + a5;
		boolean h1 = a8 + a12 > a9 + a13;
		boolean h2 = a4 > a5;
		boolean h3 = a8  > a9;
		boolean h4 = a4 + a8 > a5 + a9;
		boolean h5 = a0 + a4 + a8 + a12 > a1 + a5 + a9 + a13;
		
		h(h0, 0);									//1 + 2 = Branco 5 + 6 = Preto
		h(h1, 1);									//3 + 4 = Branco 7 + 8 = Preto
		h(h2, 2);									//2 = Branco  6 = Preto
		h(h3, 3);									//3 = Branco 7 = Preto
		h(h4, 4);									//2 + 3 = Branco 6 + 7 = Preto
		h(h5, 5);									//1 + 2 + 3 + 4 = Branco 5 + 6 + 7 + 8 = Preto
				

	}
	
	public void imp() {	
		//fim pintaImg
		countArqNome++;
		Exporta e = new Exporta();
		String i = "/Users/EOMATI/Desktop/testeRF/teste" + countArqNome;
		e.jpg(this.ii, i);
	}
	
	public void imp(int iniX, int fimX, int iniY, int fimY) {
		if(fimX > h2)
			fimX = h2;
		if(fimY > w2)
			fimY = w2;
		
		for (int x = iniX; x < fimX ; x++) {
			for (int y = iniY; y < fimY ; y++) {
				this.ii.getListaImagem().add(x, y, 0);
			}
		}
		
		imp();
		
		for (int x = 0; x < h2; x++) {
			for (int y = 0; y < w2; y++) {
				int temp = listaTemp.get(x, y);
				this.ii.getListaImagem().add(x, y, temp);
			}
		}
		
	}


}
