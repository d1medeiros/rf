package faceDetection_V5_T1;

public class Haar {
	
	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	private Ponto a;
	private Ponto b;
	private Ponto c;
	private Ponto d;
	
	public Haar(int minX, int maxX, int minY, int maxY){
		
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
		
		a = new Ponto(minX, minY);
		b = new Ponto(minX, maxY);
		c = new Ponto(maxX, minY);
		d = new Ponto(maxX, maxY);
		
	}
	
	public void h1(){
		
		
		
	}
	public void h2(){
		
	}
	public void h3(){
		
	}
	public void h4(){
		
	}

}
