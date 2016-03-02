package faceDetection_V5_T1;




public class Analise7 {
	

	
	private Imagem i;
	private ImagemIntegral ii;
	private int h2;
	private int w2;
	private int baseMin;
	private int baseMax;
	private Stage1 stage1;

	public Analise7(Imagem imagem, ImagemIntegral imagemIntegral){
		
		i = imagem;
		ii = imagemIntegral;
		h2 = ii.getH2();
		w2 = ii.getW2();
		baseMin = 1;
		baseMax = 24;
		stage1 = new Stage1(ii, baseMin, baseMax);

	}
	
	
	

}