package faceDetection_V5_T1;

import java.io.File;
import java.util.ArrayList;


public class Learn {
	
private Imagem i;
private ImagemIntegral ii;
private int h2;
private int w2;
private int imgInicial;
private int imgFinalX;
private int imgFinalY;
private int sampleInicial;
private int qtdSampleInicialX;
private int qtdSampleInicialY;
private int sample;
private int sampleA1;
private int sampleA2;
private int sampleA3;
private int sampleA4;
private int sampleA5;
private int sampleA6;
private int sampleA7;
private int sampleA8;
private int sampleA9;
private ArrayList<Integer> listaP;


	public Learn(String file){	
		i = new Imagem(file);
		ii = new ImagemIntegral(i);
		h2 = ii.getH2();
		w2 = ii.getW2();
		listaP = new ArrayList<>();
	}

	public Learn(){
		listaP = new ArrayList<>();
		listaP.add(1);
		listaP.add(1);
		listaP.add(1);
	}

	public int compara(ArrayList<Integer> lista, int iniX, int fimX, int iniY, int fimY){
		int soma = 0;
		for (Integer integer : lista) {
			soma += integer;
		}
		//diferente de 3 pq sao 3 haar like
		if(soma == 3)
			System.out.println("soma = 3" + iniX + " " + fimX + " " + iniY + " " + fimY);
		
		return soma;
	}
	
	
	

}
