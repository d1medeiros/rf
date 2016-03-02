package faceDetection_V5_T1.teste;

import faceDetection_V5_T1.Analise7;
import faceDetection_V5_T1.Imagem;
import faceDetection_V5_T1.ImagemIntegral;

public class Teste {
	
	public static void main(String[] args)  {
		//inicia imagem
		Imagem i = new Imagem("b.jpg");
		//inicia imagem integral
		ImagemIntegral ii = new ImagemIntegral(i);
		//faz analise
		Analise7 a = new Analise7(i, ii);
		
		
	}

}



