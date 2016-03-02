package faceDetection_V5_T1;

import java.awt.Color;

public class Cor {

	private int r = 0;
	private int g = 0;
	private int b = 0;
	private int corSoma = 0;
	
	public Cor(){
		
	}

	public Cor(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
		
	}

	public Cor(int rgb){
		
		r = rgb;
		g = rgb;
		b = rgb;
	}
	
	public void setCorSoma(int corSoma){	
		this.corSoma = corSoma;	
	}
	
	public int getCorSoma(){
		return this.corSoma;
	}
	
	public int getCor(){
		return (r + g + b) / 3;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + b;
		result = prime * result + corSoma;
		result = prime * result + g;
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cor other = (Cor) obj;
		if (b != other.b)
			return false;
		if (corSoma != other.corSoma)
			return false;
		if (g != other.g)
			return false;
		if (r != other.r)
			return false;
		return true;
	}

	
	
	
}
